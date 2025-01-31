package br.com.app.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.app.dto.AplicativoDto;
import br.com.app.dto.AtualizarDto;
import br.com.app.dto.GastosElucrosDto;
import br.com.app.servico.AplicativoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aplicativo")
@RequiredArgsConstructor
public class AplicativoControle {

	private final AplicativoServico aplicativoServico;
	
		
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar as despesas.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<AplicativoDto>cadastrarMovimentacaoDoDia(@RequestBody AplicativoDto aplicativoDto){
		var cadastrar = aplicativoServico.cadastrarMovimentacaoDoDia(aplicativoDto);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new AplicativoDto(cadastrar));
	}	
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Endpoint responsável por calcular as despesas e o lucro.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<AtualizarDto>calcularDespesas(@RequestBody @Valid AtualizarDto atualizarDto,@PathVariable Long id){
		var calcular = aplicativoServico.calcularDespesas(atualizarDto,id);
		return ResponseEntity.ok().body(new AtualizarDto(calcular));
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todas as despesas.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<List<AplicativoDto>>listarDespesasElucro(){
		var listar = aplicativoServico.listarDespesasElucro();
		return ResponseEntity.ok(listar);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Endpoint responsável por buscar despesas pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<AplicativoDto>buscarPorId(@PathVariable Long id){
		var buscar = aplicativoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new AplicativoDto(buscar));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir despesas.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<Void>excluirMovimentacao(@PathVariable Long id){
		aplicativoServico.excluirMovimentacao(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/{apps}")
	@Operation(summary = "Endpoint responsável por buscar despesas pelo app.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<List<AplicativoDto>>listarMovimentacoesPorApp(@PathVariable String apps){
		var buscar = aplicativoServico.listarMovimentacoesPorApp(apps);
		return ResponseEntity.ok(buscar);
	}
	
	
	@GetMapping("/resumoDespesas")
	@Operation(summary = "Endpoint responsável por buscar despesas resumida, apenas data,gastos e lucro.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<List<GastosElucrosDto>>listarGastosElucros(){
		var listar = aplicativoServico.listarGastosElucros();
		return ResponseEntity.ok(listar);
	}
}
