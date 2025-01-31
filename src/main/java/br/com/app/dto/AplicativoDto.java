package br.com.app.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.app.entidade.Aplicativo;
import br.com.app.enums.APP;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class AplicativoDto {

	private Long id;	
	private String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	private APP app;	
	private Integer quilometragem;	
	private Double combustivel;	
	private Double alimentacao;	
	private Double corridas;	
	private Double manutencao;	
	private Double totalGastos;	
	private Double lucro;
	private String descricao;
	
	public AplicativoDto( Aplicativo aplicativo ){
		this.id = aplicativo.getId();
		this.data = aplicativo.getData();
		this.app = aplicativo.getApp();
		this.quilometragem = aplicativo.getQuilometragem();
		this.combustivel = aplicativo.getCombustivel();
		this.alimentacao = aplicativo.getAlimentacao();
		this.corridas = aplicativo.getCorridas();
		this.manutencao  = aplicativo.getManutencao();
		this.totalGastos = aplicativo.getTotalGastos();
		this.lucro = aplicativo.getLucro();
		this.descricao = aplicativo.getDescricao();
		
	}

}
