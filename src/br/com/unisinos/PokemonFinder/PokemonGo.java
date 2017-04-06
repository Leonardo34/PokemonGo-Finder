package br.com.unisinos.PokemonFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Classe que implementa a lógica principal da aplicação, mantém uma matriz que representa
 * o mapa para localizar pokemons. Guarda os melhores Chromosomes em uma Lista Ordenada de elementos.
 */

public class PokemonGo implements IPokemonGo {
	private static final int MAX_VERTICES = 16;
	private static final int MAX_CHROMOSOME_GENES = 6;
	private static final int MAX_SAVED_CHROMOSOMES = 10;
	private static final int MAX_GENERATED_CHROMOSOMES = 100;
	
	private final int[][] matriz;
	private SortedList<Chromosome> chromosomes;
	
	public PokemonGo() {
		chromosomes = new StaticSequentialSortedList<>(MAX_SAVED_CHROMOSOMES);
		matriz = new int[MAX_VERTICES][MAX_VERTICES];
	}
	
	/*
	 * Carrega a matriz, ou seja, o mapa para calculo dos caminhos através de um 
	 * arquivo de texto passado por parametro.
	 */
	@Override
	public void loadMatrix(File file) throws IOException {
		try (BufferedReader reader = 
				new BufferedReader(new FileReader(file))) {
			String line;
			int lineCount = 0;
			while ((line = reader.readLine()) != null && lineCount < MAX_VERTICES) {
				String[] vert = line.split(";");
				for (int i = 0; i < vert.length && i < MAX_VERTICES; i++) {
					matriz[lineCount][i] = Integer.parseInt(vert[i]);
				}
				lineCount++;
			}
		}
	}

	/*
	 * Gera um chromosomo, ou seja, um caminho de forma aleátoria.
	 * Delega ao método distance o calculo da distância total(fitness)
	 */
	@Override
	public Chromosome generateChromosome() {
		int[] genes = new int[MAX_CHROMOSOME_GENES];
		genes[0] = 0;
		genes[1] =  1 + (int) (Math.random() * 3);
		genes[2] =  4 + (int) (Math.random() * 4);
		genes[3] =  8 + (int) (Math.random() * 4);
		genes[4] =  12 + (int) (Math.random() * 3);
		genes[5] = 15;
		return new Chromosome(genes, distance(genes));
	}

	@Override
	public void insertOrderedChromosome(Chromosome chromosome) {
		chromosomes.insert(chromosome);
	}

	/*
	 * Calcula através da matriz previamente carregada a distancia total de um Chromosomo, ou seja, seu fitness.
	 */
	@Override
	public int distance(int[] genes) {
		int distance = 0;
		for (int i = 1; i < genes.length; i++) {
			distance += matriz[genes[i - 1]][genes[i]];
		}
		return distance;
	}

	/*
	 * Gera 100 chromosomos de forma aleatória e insere na Lista de melhores chromosomos.
	 */
	@Override
	public void evolve() {
		for (int i = 0; i < MAX_GENERATED_CHROMOSOMES; i++) {
			insertOrderedChromosome(generateChromosome());
		}
	}

	@Override
	public void print() {
		 for (int i = 0; i < chromosomes.size(); i++) {
			 System.out.println(chromosomes.get(i));
		 }
	}
	
	public void printMatriz() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
}
