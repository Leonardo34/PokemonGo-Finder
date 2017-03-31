package br.com.unisinos.PokemonFinder;

public class SequentialOrderList<E extends Comparable<E>> implements List<E> {
	private Object[] elements;
	
	public SequentialOrderList(int size) {
		elements = new Object[size];
	}
	
	@Override
	public E get(int index) {
		return (E) elements[index];
	}
	
	@Override
	public void insert(E element) {
		
	}
	
	@Override
	public int size() {
		return elements.length;
	}
}
