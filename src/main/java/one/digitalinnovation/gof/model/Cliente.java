package one.digitalinnovation.gof.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {
	@Schema(description = "Id do cliente")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@Schema(description = "Nome do cliente", example = "Jessica Abigail", required = true)
	@NotNull(message = "O nome deve ser informado")
	@Size(min = 3, max = 50, message = "O nome deve conter entre 3 e 50 caracteres")
	@Valid
	private String nome;

	@Schema(description = "Endereço do cliente")
	@ManyToOne
	@Valid
	@NotNull(message = "O cep deve ser informado")
	private Endereco endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
