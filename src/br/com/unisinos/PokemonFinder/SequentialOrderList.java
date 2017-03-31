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
		for (int i = 0; i < size(); i++) {
			if (elements[i] == null || 
					((E) elements[i]).compareTo(element) > 0) {
				insertAt(i, element);
				break;
			}
		}
	}

	@Override
	public int size() {
		return elements.length;
	}
	
	private void insertAt(int index, E element) {
		for (int i = size() - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
	}
}
