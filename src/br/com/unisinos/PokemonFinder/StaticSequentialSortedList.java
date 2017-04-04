package br.com.unisinos.PokemonFinder;

public class StaticSequentialSortedList<E extends Comparable<E>> implements SortedList<E> {
	private Object[] elements;

	public StaticSequentialSortedList(int size) {
		elements = new Object[size];
	}

	@Override
	public E get(int index) {
		return (E) elements[index];
	}

	@Override
	public void insert(E element) {
		if (!contains(element)) {
			for (int i = 0; i < elements.length; i++) {
				if (elements[i] == null || 
						((E) elements[i]).compareTo(element) > 0) {
					insertAt(i, element);
					break;
				}
			}
		}
	}

	@Override
	public int size() {
		return elements.length;
	}
	
	@Override
	public boolean contains(E element) {
		for (int i = 0; i < size() && elements[i] != null; i++) {
			if (elements[i] != null && elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	private void insertAt(int index, E element) {
		for (int i = size() - 2; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
	}
}
