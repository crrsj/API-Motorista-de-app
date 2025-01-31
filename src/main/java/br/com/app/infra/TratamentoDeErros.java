package br.com.app.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.app.dto.MensagemDeErro;
import br.com.app.dto.ValidandoCampos;

@ControllerAdvice
public class TratamentoDeErros {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
		var valide = ex.getFieldErrors();
		return ResponseEntity.badRequest()
				.body(valide.stream()
				.map(ValidandoCampos::new).toList());
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>objetoNaoEncontrado(){
		var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "Objeto não encontrado !");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<MensagemDeErro>campoIncorreto(){
		var erros = new MensagemDeErro(HttpStatus.BAD_REQUEST, "campos combustível,alimentação,quilometragem,corrida deve conter apenas números !");
		return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MensagemDeErro>appInvalido(){
		var app = new MensagemDeErro(HttpStatus.BAD_REQUEST, "App incorreto, escolha uber ou umnovenove !" );
		return new ResponseEntity<>(app,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MensagemDeErro>movimentacaoJaCadastrada(){
		var erros = new MensagemDeErro(HttpStatus.BAD_REQUEST, "Movimentação já cadastrada !");
		return new ResponseEntity<>(erros,HttpStatus.BAD_REQUEST);
	}
}
