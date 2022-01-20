package com.br.gustavogithub.cep.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Endereco {

	private String logradouro;
	private String bairro;
	private String localidade;
	
	 @Override
	    public String toString() {
	        return "Endereco{" + "logradouro=" + logradouro + ", bairro=" + bairro + ", localidade=" + localidade + '}';
	    }
}
