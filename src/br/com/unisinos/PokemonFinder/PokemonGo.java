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
			while ((line = reader.readLine()) != null) {
				String[] vert = line.split(";");
				for (int i = 0; i < vert.length; i++) {
					matriz[lineCount][i] = Integer.parseInt(vert[i]);
				}
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

}
