/**
 * 
 */
package br.com.fake.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fake.model.Medico;
import br.com.fake.service.MedicoService;

/**
 * @author carlosbarbosagomesfilho
 * Sep 12, 2019
 * 
 */
@RestController
@RequestMapping("/api")
public class ControllerMedicoResource {

	@Autowired
	private MedicoService service;
	
	@GetMapping("/medicos")
	public ResponseEntity<?> lista(){
		List<Medico> medicos = this.service.lista();
		return !medicos.isEmpty() ? ResponseEntity.ok(medicos) : ResponseEntity.noContent().build();
	}
	
	@PostMapping("/medicos")
	public ResponseEntity<Medico> save(@Valid @RequestBody Medico medico, HttpServletResponse response) {
		this.service.salva(medico);
		return ResponseEntity.status(HttpStatus.CREATED).body(medico);
	}
	
	@GetMapping("/medicos/{id}")
	public Medico medico(@PathVariable Long id){
		Medico medico = this.service.getMedidoById(id);
		return medico;
	}
	
	@PutMapping("/medicos")
	public ResponseEntity<Medico> edita(@Valid @RequestBody Medico medico, HttpServletResponse response){
		 this.service.update(medico);
		 return ResponseEntity.status(HttpStatus.CREATED).body(medico);
		
	}
}
