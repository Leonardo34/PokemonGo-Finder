package br.com.unisinos.PokemonFinder;

public class Chromosome implements Comparable<Chromosome>{
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
		String s = "Fitness: " + fitness + "\n";
		for (int i = 0; i < genes.length; i++) {
			s += "Gene[" + i + "] = " + genes[i] + "\n";
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
}
