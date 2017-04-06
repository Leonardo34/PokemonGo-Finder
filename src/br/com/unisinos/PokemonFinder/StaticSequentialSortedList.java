package br.com.unisinos.PokemonFinder;

/*
 * Lista sequencial ordenada baseada em Array. Não permite itens repetidos, não permite 
 * remoção e possui  tamanho estático, ou seja, não é redimensionável. 
 */

public class StaticSequentialSortedList<E extends Comparable<E>> implements SortedList<E> {
	private Object[] elements;
	private int size;

	public StaticSequentialSortedList(int maxSize) {
		elements = new Object[maxSize];
		size = 0;
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
		return size;
	}
	
	@Override
	public boolean contains(E element) {
		for (int i = 0; i < size(); i++) {
			if (elements[i].equals(element)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean isFull() {
		return size == elements.length;
	}
	
	private void insertAt(int index, E element) {
		if (isFull()) {
			for (int i = size() - 2; i >= index; i--) {
				elements[i + 1] = elements[i];
			}
		} else {
			for (int i = size() - 1; i >= index; i--) {
				elements[i + 1] = elements[i];
			}
			size++;
		}
		elements[index] = element;
	}
}
