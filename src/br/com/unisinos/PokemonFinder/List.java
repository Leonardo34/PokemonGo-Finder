package br.com.unisinos.PokemonFinder;

public interface List<E> {
	public E get(int index);
	public void insert(E element);
	public int size();
}