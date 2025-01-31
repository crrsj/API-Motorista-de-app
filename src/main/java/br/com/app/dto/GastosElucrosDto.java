package br.com.app.dto;

import br.com.app.entidade.Aplicativo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GastosElucrosDto {
	
	private String data;
	private Double totalGastos;
	private Double lucro;

	public GastosElucrosDto(Aplicativo dados ){
		this.data = dados.getData();
		this.totalGastos = dados.getTotalGastos();
		this.lucro = dados.getLucro();
	}
}
