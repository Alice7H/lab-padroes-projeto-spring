package one.digitalinnovation.gof.exception;

import java.util.stream.Collectors;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RecordNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleNotFoundException(RecordNotFoundException ex) {
    String message = "Error: " + ex.getMessage();
    ErrorResult errorResult = new ErrorResult(HttpStatus.NOT_FOUND, message);
    return buildResponseEntity(errorResult, errorResult.getStatus());
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResult> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    String errors = ex.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

    ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, errors);
    return ResponseEntity.badRequest().body(errorResult);
  }

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ErrorResult> handleConstraintValidation(HttpMessageNotReadableException ex) {
    String errors = "Nao foi possível ler o documento JSON";
    ErrorResult errorResult = new ErrorResult(HttpStatus.BAD_REQUEST, errors);
    return ResponseEntity.badRequest().body(errorResult);
  }

  private ResponseEntity<Object> buildResponseEntity(ErrorResult errorResult, HttpStatus status) {
    return new ResponseEntity<Object>(errorResult, new HttpHeaders(), status);
  }

}