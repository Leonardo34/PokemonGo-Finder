package br.com.unisinos.PokemonFinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PokemonGo implements IPokemonGo {
	private final int[][] matriz = new int[16][16];

	@Override
	public void loadMatrix(File file) throws IOException {
		try (BufferedReader reader = 
				new BufferedReader(new FileReader(file))) {
			String line;
			int lineCount = 0;
			while ((line = reader.readLine()) != null && lineCount < 16) {
				String[] vert = line.split(";");
				for (int i = 0; i < vert.length; i++) {
					matriz[lineCount][i] = Integer.parseInt(vert[i]);
				}
				lineCount++;
			}
		}
	}

	@Override
	public Chromosome generateChromosome() {
		// TODO
		return null;
	}

	@Override
	public void insertOrderedChromosome(Chromosome chromosome) {
		// TODO

	}

	@Override
	public int distance(int[] genes) {
		// TODO
		return 0;
	}

	@Override
	public void evolve() {
		// TODO 

	}

	@Override
	public void print() {
		// TODO 

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
