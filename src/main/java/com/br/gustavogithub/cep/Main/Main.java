package com.br.gustavogithub.cep.Main;

import java.util.Scanner;

import com.br.gustavogithub.cep.model.Endereco;
import com.br.gustavogithub.cep.viacep.ServicoDeCep;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.print("Informe seu cep:");
		
		String cep ;
		Scanner sc= new Scanner(System.in);
		cep = sc.nextLine();
		 
		Endereco endereco = ServicoDeCep.buscaEnderecoPelo(cep);
		
		System.out.println("Lougradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Localidade: " + endereco.getLocalidade());
		sc.close();
		
	}
}
