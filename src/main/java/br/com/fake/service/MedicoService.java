/**
 * 
 */
package br.com.fake.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fake.model.Medico;
import br.com.fake.repository.MedicoRepository;

/**
 * @author carlosbarbosagomesfilho
 * Aug 30, 2019
 * 
 */
@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repository;
	
	@Transactional(readOnly=true)
	public List<Medico> lista(){
		return this.repository.findAll();
	}
	
	@Transactional
	public Medico salva(Medico medico) {
		return this.repository.save(medico);
	}

	public Medico getMedidoById(Long id) {
		return this.repository.getOne(id);
	}

	public void update(@Valid Medico medico) {
		this.repository.flush();
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
