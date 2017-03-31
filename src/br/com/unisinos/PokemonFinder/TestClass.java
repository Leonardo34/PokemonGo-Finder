package br.com.unisinos.PokemonFinder;

public class TestClass {
	public static void main(String[] args) {
		testList();
	}
	
	public static void testList() {
		int[] array = {1, 2, 3};
		OrderedList<Chromosome> list = new SequentialOrderedList(10);
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
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				System.out.println(list.get(i).getFitness());
			}
		}
	}
}
