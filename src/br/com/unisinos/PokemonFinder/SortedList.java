package br.com.unisinos.PokemonFinder;

public interface SortedList<E> {
	public E get(int index);
	public void insert(E element);
	public int size();
}