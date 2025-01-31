package br.com.app.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.app.dto.AplicativoDto;
import br.com.app.dto.AtualizarDto;
import br.com.app.dto.GastosElucrosDto;
import br.com.app.entidade.Aplicativo;
import br.com.app.enums.APP;
import br.com.app.repositorio.AplicativoRepositorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AplicativoServico {

	private final AplicativoRepositorio aplicativoRepositorio;
	
	public Aplicativo cadastrarMovimentacaoDoDia(AplicativoDto aplicativoDto) {
		var cadastrar = new Aplicativo(aplicativoDto);	
		cadastrar.setQuilometragem(0);
		cadastrar.setManutencao(0.0);
		cadastrar.setTotalGastos(0.0);
		cadastrar.setLucro(0.0);
		return aplicativoRepositorio.save(cadastrar);
	}
	
	
	public List<AplicativoDto>listarDespesasElucro(){
		return aplicativoRepositorio.findAll().stream().map(AplicativoDto::new).toList();
	}
	
	
	public Aplicativo  calcularDespesas(AtualizarDto atualizarDto,Long id) {
		
		var calcular = new Aplicativo(atualizarDto);	
		calcular.setId(id);
		calcular.setTotalGastos(atualizarDto.getCombustivel() + atualizarDto.getAlimentacao() + atualizarDto.getManutencao());
		calcular.setLucro(calcular.getCorridas() - calcular.getTotalGastos());
		return aplicativoRepositorio.save(calcular);
	}
	
	
	public Aplicativo buscarPorId(Long id) {
		Optional<Aplicativo>buscar = aplicativoRepositorio.findById(id);
		return buscar.get();
	}
	
	public void excluirMovimentacao(Long id) {
		aplicativoRepositorio.deleteById(id);
	}
	
	public List<AplicativoDto> listarMovimentacoesPorApp(String app ) {
	try {
		APP  appEnum = APP.valueOf(app.toUpperCase());
		return aplicativoRepositorio.findByApp(appEnum).stream().map(AplicativoDto::new).toList();
	}catch(IllegalArgumentException ex){
		throw new IllegalArgumentException();
	}
		
	}
	
	public List<GastosElucrosDto> listarGastosElucros() {
		return aplicativoRepositorio.findAll().stream().map(GastosElucrosDto::new).toList();
	}
			
}
