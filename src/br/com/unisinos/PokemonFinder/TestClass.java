package br.com.unisinos.PokemonFinder;

public class TestClass {
	public static void main(String[] args) {
		testList();
	}
	
	public static void testList() {
		int[] array = {1, 2, 3};
		List<Chromosome> list = new SequentialOrderList(10);
		list.insert(new Chromosome(array, 10));
		list.insert(new Chromosome(array, 9));
		list.insert(new Chromosome(array, 12));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != null) {
				System.out.println(list.get(i).getFitness());
			}
		}
	}
}
