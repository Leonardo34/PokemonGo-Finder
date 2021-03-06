package br.com.unisinos.PokemonFinder;

import java.io.File;
import java.io.IOException;

/*
 * Classe utilizada para testes durante o desenvolvimento da aplica��o.
 */

public class TestClass {
	public static final String DIRECTORY = "C:/Users/Leonardo/Trab-Lab2-GrauA/Trab-Grau-A-Lab2/Matriz.txt";
	
	public static void main(String[] args) {
		//testList();
		//testLoadMatrix();
		//testGenerateChromosome();
		testPokemonGo();
	}
	
	public static void testList() {
		int[] array = {1, 2, 3};
		int[] otherArray = {2, 5, 4};
		SortedList<Chromosome> list = new StaticSequentialSortedList(10);
		list.insert(new Chromosome(array, 10));
		list.insert(new Chromosome(array, 9));
		list.insert(new Chromosome(array, 8));
		list.insert(new Chromosome(array, 7));
		list.insert(new Chromosome(array, 6));
		list.insert(new Chromosome(array, 5));
		list.insert(new Chromosome(array, 4));
		list.insert(new Chromosome(array, 3));
		list.insert(new Chromosome(array, 2));
		list.insert(new Chromosome(array, 1));
		list.insert(new Chromosome(array, 3));
		list.insert(new Chromosome(array, 5));
		list.insert(new Chromosome(array, 12));
		list.insert(new Chromosome(otherArray, 2));
		list.insert(new Chromosome(otherArray, 3));
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				System.out.println(list.get(i).getFitness());
			}
		}
	}
	
	public static void testLoadMatrix() {
		PokemonGo pokemonGo = new PokemonGo();
		File file = new File(DIRECTORY);
		try {
			pokemonGo.loadMatrix(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pokemonGo.printMatriz();
	}
	
	public static void testGenerateChromosome() {
		PokemonGo pokemonGo = new PokemonGo();
		File file = new File(DIRECTORY);
		try {
			pokemonGo.loadMatrix(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] array = {0, 2, 6, 9, 12, 15};
		Chromosome chromosome = new Chromosome(array, pokemonGo.distance(array));
		System.out.println(chromosome);
		for (int i = 0; i < 10; i++) {
			System.out.println(pokemonGo.generateChromosome());
		}
	}
	
	public static void testPokemonGo() {
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
