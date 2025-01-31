package br.com.app.dto;

import org.hibernate.validator.constraints.NotBlank;

import br.com.app.entidade.Aplicativo;
import br.com.app.enums.APP;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AtualizarDto {
	
	private Long id;		
	private APP app;
	@NotNull(message = "não pode estar em branco")
	private Integer quilometragem;	
	@NotNull(message = "não pode estar em branco")
	private Double combustivel;	
	@NotNull(message = "não pode estar em branco")
	private Double alimentacao;
	@NotNull(message = "não pode estar em branco")
	private Double corridas;
	@NotNull(message = "não pode estar em branco")
	private Double manutencao;	
	@NotNull(message = "não pode estar em branco")
	private Double totalGastos;	
	@NotNull(message = "não pode estar em branco")
	private Double lucro;
	
	private String descricao;
	
	
	public AtualizarDto(Aplicativo atualizarDto) {
		this.id = atualizarDto.getId();
		this.app = atualizarDto.getApp();
		this.quilometragem = atualizarDto.getQuilometragem();
		this.combustivel = atualizarDto.getCombustivel();
		this.alimentacao = atualizarDto.getAlimentacao();
		this.corridas = atualizarDto.getCorridas();
		this.manutencao  =atualizarDto.getManutencao();
		this.totalGastos = atualizarDto.getTotalGastos();
		this.lucro = atualizarDto.getLucro();
		this.descricao = atualizarDto.getDescricao();
	}

}
