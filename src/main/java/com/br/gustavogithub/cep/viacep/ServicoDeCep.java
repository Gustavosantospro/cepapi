package com.br.gustavogithub.cep.viacep;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.br.gustavogithub.cep.model.Endereco;
import com.google.gson.Gson;

public class ServicoDeCep {
	
	//endpoint viacep
	static String webService = "http://viacep.com.br/ws/";
	//código de retorno da requisição http
	static int codSucesso = 200;
	
	
	public static Endereco buscaEnderecoPelo(String cep) throws Exception {
		
		// regra da api - ViaCep
		String urlParaChamada = webService + cep + "/json";
		
		try {
			// abrindo conexão com a urlParaChamada
			URL url = new URL(urlParaChamada);
			HttpURLConnection  con = (HttpURLConnection) url.openConnection();
			
			// se o código de resposta da requisição não for 200, o método lançará uma Exception
			if (con.getResponseCode() != codSucesso)
			{
				throw new RuntimeException("HTTP error code: " + con.getResponseCode());
			}
			
			// armazenando o fluxo de dados da conexão da url, que virá em formato de Json.
            BufferedReader resposta = new BufferedReader(new InputStreamReader((con.getInputStream())));
			
            // método para converter json em string
            String jsonEmString = Util.converteJsonEmString(resposta);

	
			Gson gson = new Gson();
			Endereco enderecoreal = gson.fromJson(jsonEmString, Endereco.class);
			
			return enderecoreal;
			
		} catch(Exception e) {
			throw new Exception("ERRO: " + e);
		}
	}
}
