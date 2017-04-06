package br.com.unisinos.PokemonFinder;

import java.io.File;
import java.io.IOException;

/*
 * Classe para rodar a aplicação.
 */

public class PokemonGoTest {
	public static final String DIRECTORY = "C:/Users/Leonardo/Trab-Lab2-GrauA/Trab-Grau-A-Lab2/Matriz.txt";
	
	public static void main(String[] args) {
		IPokemonGo pokemonGo = new PokemonGo();
		try {
			pokemonGo.loadMatrix(new File(DIRECTORY));
		} catch (IOException e) {
			e.printStackTrace();
		}
		pokemonGo.evolve();
		pokemonGo.print();
	}
}
