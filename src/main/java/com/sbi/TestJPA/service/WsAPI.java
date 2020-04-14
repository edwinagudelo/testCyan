package com.sbi.TestJPA.service;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import com.sbi.TestJPA.model.LLamadoWrap;
import com.sbi.TestJPA.model.Llamado;

@Controller
//@RequestMapping(path="/analyse")
public class WsAPI {
	
	@Autowired
	private Servicios serv;
	
	@RequestMapping(value="/analyse/new",  method=RequestMethod.POST, consumes="application/json", produces="application/json")
	@ResponseBody public List<Integer> analizar(@RequestBody LLamadoWrap urls){
		List<String> parametro = new ArrayList<String>();
		//Servicios serv = new Servicios();
		for(Llamado tll : urls.getUrls()) {
			parametro.add(tll.getUrl());
		}
		return serv.procesarURL(parametro);
	}
	
	
	@RequestMapping(path="/frequency/{id}",  method=RequestMethod.GET, produces="application/json")
	@ResponseBody public HashMap<String, Integer> frecuencia(@PathVariable("id") Integer petid){
		//Servicios serv = new Servicios();
		return serv.frecuencia(petid);
	}
}
