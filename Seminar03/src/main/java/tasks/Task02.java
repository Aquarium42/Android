package tasks;

import java.util.Iterator;
import java.util.NoSuchElementException;
class ArrayIterator<T> implements Iterator<T> {
	private int index;
	private final T[] array;
	
    public ArrayIterator(T[] array) {
    	this.array = array;
    	this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
        	throw new NoSuchElementException();
        }
    	return array[index++];
    }
}
