package com.concessionaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.concessionaria.models.Carro;
import com.concessionaria.respository.CarroRepository;

@Controller
public class ControllerGeral {
    
	@Autowired
	private CarroRepository carroRepository;
	
	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "cadastro/cadastro";
	}
	
	@RequestMapping(value="/cadastro", method = RequestMethod.POST)
	public ModelAndView cadastro(Carro carro) {
		carroRepository.save(carro);
		ModelAndView model = new ModelAndView("cadastro/mostrarcarros");
		Iterable<Carro> carros = carroRepository.findAll();
		model.addObject("carros", carros);
		
		return model;
	}
	
	@RequestMapping("/listarcarros")
	public ModelAndView listarCarros() {
		ModelAndView model = new ModelAndView("cadastro/mostrarcarros");
		Iterable<Carro> carros = carroRepository.findAll();
		model.addObject("carros", carros);
		return model;
	}
	
	@RequestMapping("/deletar")
	public ModelAndView deletarCarro(Integer cod) {
		Carro carro = carroRepository.findByCod(cod);
		carroRepository.delete(carro);
		
		ModelAndView model = new ModelAndView("cadastro/mostrarcarros");
		Iterable<Carro> carros = carroRepository.findAll();
		model.addObject("carros", carros);
		
		return model;
	}
	
	@RequestMapping("editarCarro/{cod}")
	public ModelAndView editarRegistro(@PathVariable("cod") Integer cod) {
		ModelAndView model = new ModelAndView("cadastro/editar");
	    Carro carros = carroRepository.findByCod(cod);
	    model.addObject("carros", carros);
		return model;
	}
	
	
	
	
}
