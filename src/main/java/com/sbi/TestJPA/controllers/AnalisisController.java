package com.sbi.TestJPA.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sbi.TestJPA.models.Llamado;
import com.sbi.TestJPA.models.LLamadoWrap;
import com.sbi.TestJPA.services.ServicioNoticias;

@RestController
@RequestMapping("analysis")
public class AnalisisController {

	private Logger logger = LoggerFactory.getLogger(AnalisisController.class);
	
	@Autowired
	private ServicioNoticias serv;
	
	@PostMapping(path="/new",  consumes="application/json", produces="application/json")
	@ResponseBody public List<Integer> analize(@RequestBody LLamadoWrap urls){
		List<String> parametro = new ArrayList<String>();
		for(Llamado tll : urls.getUrls()) {
			logger.info("URL used " + tll.getUrl());
			parametro.add(tll.getUrl());
		}
		return serv.procesarURL(parametro);
	}
	
	
	@GetMapping(path="/frequency/{id}",   produces="application/json")
	@ResponseBody public HashMap<String, Integer> frecuencia(@PathVariable("id") Integer petid){
		logger.info(String.format("Receiving request for ID %d", petid));
		return serv.frecuencia(petid);
	}
}
