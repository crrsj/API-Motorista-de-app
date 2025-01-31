package br.com.app.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.app.dto.AplicativoDto;
import br.com.app.dto.AtualizarDto;
import br.com.app.enums.APP;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_app")
@Data
@NoArgsConstructor
public class Aplicativo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    @Column(unique = true)
	private String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	@Enumerated(EnumType.STRING)
	private APP app;
	private Integer quilometragem;
	private Double combustivel;
	private Double alimentacao;
	private Double corridas;
	private Double manutencao;
	private Double totalGastos;
	private Double lucro;
	private String descricao;
	
	public Aplicativo(AplicativoDto aplicativoDto) {
		this.data = aplicativoDto.getData();
		this.app = aplicativoDto.getApp();
		this.quilometragem = aplicativoDto.getQuilometragem();
		this.combustivel = aplicativoDto.getCombustivel();
		this.alimentacao = aplicativoDto.getAlimentacao();
		this.corridas = aplicativoDto.getCorridas();
		this.lucro = aplicativoDto.getLucro();
		this.manutencao = aplicativoDto.getManutencao();
		this.totalGastos = aplicativoDto.getTotalGastos();
		this.lucro = aplicativoDto.getLucro();
		this.descricao = aplicativoDto.getDescricao();
	}

	public Aplicativo(AtualizarDto atualizarDto) {
		this.id = atualizarDto.getId();
		this.app = atualizarDto.getApp();
		this.quilometragem = atualizarDto.getQuilometragem();
		this.combustivel =atualizarDto.getCombustivel();
		this.alimentacao = atualizarDto.getAlimentacao();
		this.corridas = atualizarDto.getCorridas();
		this.manutencao = atualizarDto.getManutencao();
		this.totalGastos = atualizarDto.getTotalGastos();
		this.lucro = atualizarDto.getLucro();
		this.descricao = atualizarDto.getDescricao();
		
	}

}
