package one.digitalinnovation.gof.model;

// import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

/**
 * Os atributos desse modelo foram gerados automaticamente pelo site
 * jsonschema2pojo.org. Para isso, usamos o JSON de retorno da API do ViaCEP.
 *
 * @see <a href="https://www.jsonschema2pojo.org">jsonschema2pojo.org</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 */
@Entity
public class Endereco {
	@Schema(description = "Cep", example = "02329050", required = true)
	@Valid
	@Pattern(regexp = "^[0-9]{5}\\-?[0-9]{3}$", message = "Cep inválido")
	@Id
	private String cep;

	@Schema(description = "Logradouro", example = "Rua dos Campos")
	private String logradouro;

	@Schema(description = "Complemento", example = "lado ímpar")
	private String complemento;

	@Schema(description = "Bairro", example = "Jardim Hebrom")
	private String bairro;

	@Schema(description = "Localidade", example = "São Paulo")
	private String localidade;

	@Schema(description = "UF", example = "SP")
	private String uf;

	@Schema(description = "IBGE", example = "3550308")
	private String ibge;

	@Schema(description = "GIA", example = "1004")
	private String gia;

	@Schema(description = "DDD", example = "11")
	private String ddd;

	@Schema(description = "SIAFI", example = "7107")
	private String siafi;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getGia() {
		return gia;
	}

	public void setGia(String gia) {
		this.gia = gia;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getSiafi() {
		return siafi;
	}

	public void setSiafi(String siafi) {
		this.siafi = siafi;
	}

}
