package com.sv.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.main.service.IRequestService;

@RestController
@RequestMapping("/firebase")
public class PersonaController {

	@Autowired
	private IRequestService service;

	@GetMapping("/sensor/{tipo}/{valor}")
	public ResponseEntity<Integer> enviar(@PathVariable("tipo") int tipo,@PathVariable("valor") int valor) {
		int rpta = 0;
		try {
			rpta = service.firebase(tipo,valor);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	
}
