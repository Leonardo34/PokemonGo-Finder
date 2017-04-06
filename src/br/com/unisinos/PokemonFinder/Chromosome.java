package br.com.unisinos.PokemonFinder;

public class Chromosome implements Comparable<Chromosome> {
	private int[] genes;
	private int fitness;

	public Chromosome(int[] genes, int fitness) {
		this.genes = genes;
		this.fitness = fitness;
	}

	public int[] getGenes() {
		return genes;
	}

	public void setGenes(int[] genes) {
		this.genes = genes;
	}

	public int getFitness() {
		return fitness;
	}

	public void setFitness(int fitness) {
		this.fitness = fitness;
	}

	@Override
	public int compareTo(Chromosome obj) {
		if (fitness < obj.getFitness()) {
			return -1;
		}
		if (fitness > obj.getFitness()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		String s = "Short path -> " + fitness + " ";
		for (int i = 0; i < genes.length; i++) {
			s += translateGene(genes[i]) + " ";
		}
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Chromosome chromosome = (Chromosome) obj;
		if (this.fitness != chromosome.fitness) {
			return false;
		}
		for (int i = 0; i < genes.length; i++) {
			if (genes[i] != chromosome.genes[i]) {
				return false;
			}
		}
		return true;
	}

	public String translateGene(int gene) {
		switch (gene) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		case 3:
			return "D";
		case 4:
			return "E";
		case 5:
			return "F";
		case 6:
			return "G";
		case 7:
			return "H";
		case 8:
			return "I";
		case 9:
			return "J";
		case 10:
			return "K";
		case 11:
			return "L";
		case 12:
			return "M";
		case 13:
			return "N";
		case 14:
			return "O";
		case 15:
			return "P";
		default:
			return "Vertice Invalido";
		}
	}
}
