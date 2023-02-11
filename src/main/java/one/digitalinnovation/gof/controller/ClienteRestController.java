package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 */
@RestController
@RequestMapping("clientes")
@Tag(name = "clientes", description = "Clientes API")
@Validated
public class ClienteRestController {

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Busca todos os clientes", tags = { "clientes" })
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
	@ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> buscarTodos() {
		return ResponseEntity.ok(clienteService.buscarTodos());
	}

	@Operation(summary = "Busca cliente por ID", tags = { "clientes" })
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
	@ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
	@GetMapping("/{id}")
	public Cliente buscarPorId(@PathVariable("id") Long id) {
		return clienteService.buscarPorId(id);
	}

	@Operation(summary = "Adiciona um novo cliente", tags = { "clientes" })
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
	@ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void inserir(@Valid @RequestBody Cliente cliente) {
		clienteService.inserir(cliente);
	}

	@Operation(summary = "Atualiza um cliente", tags = { "clientes" })
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
	@ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
	@PutMapping("/{id}")
	public void atualizar(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente) {
		clienteService.atualizar(id, cliente);
	}

	@Operation(summary = "Remove um cliente", tags = { "clientes" })
	@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content)
	@ApiResponse(responseCode = "404", description = "Not Found", content = @Content)
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable("id") Long id) {
		clienteService.deletar(id);
	}
}
