package com.concessionaria.respository;

import org.springframework.data.repository.CrudRepository;

import com.concessionaria.models.Carro;

public interface CarroRepository extends CrudRepository<Carro, Integer>{
    
	Carro findByCod(Integer cod);   
}
