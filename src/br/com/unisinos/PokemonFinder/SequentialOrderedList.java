package br.com.unisinos.PokemonFinder;

public class SequentialOrderedList<E extends Comparable<E>> implements OrderedList<E> {
	private Object[] elements;

	public SequentialOrderedList(int size) {
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
		for (int i = size() - 2; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
	}
}
