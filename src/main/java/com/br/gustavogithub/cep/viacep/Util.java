package com.br.gustavogithub.cep.viacep;

import java.io.BufferedReader;

public class Util {

	public static String converteJsonEmString(BufferedReader buffereReader) throws Exception {
		String resposta, jsonEmString = "";
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString += resposta;
		}
		return jsonEmString;
	}
}
