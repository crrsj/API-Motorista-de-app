package br.com.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.entidade.Aplicativo;
import br.com.app.enums.APP;

public interface AplicativoRepositorio extends JpaRepository<Aplicativo, Long> {

	List<Aplicativo> findByApp(APP appEnum);

	

}
