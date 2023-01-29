import java.io.IOException;
import java.io.PrintWriter;

// PROGRAMMER: COREY TAYLOR
public class DynamicArray<E> {

	// INSTANCE VARIABLES
	private final int INITIAL_SIZE = 8;
	private int numberOfElements;
	private E[] array;

	// DEFAULT CONSTRUCTOR
	@SuppressWarnings("unchecked")
	public DynamicArray() {
		numberOfElements = 0;
		array = (E[]) new Object[INITIAL_SIZE];
	}

	// INSTANCE METHODS
	public void addToEnd(E element) {
		if (array.length == 0) {
			@SuppressWarnings("unchecked")
			E[] largerArray = (E[]) new Object[INITIAL_SIZE];
			array = largerArray;
		} else if (numberOfElements == array.length) {
			@SuppressWarnings("unchecked")
			E[] largerArray = (E[]) new Object[2 * INITIAL_SIZE];

			for (int index = 0; index < numberOfElements; index++) {
				largerArray[index] = array[index];
			}
			array = largerArray;
		}
		array[numberOfElements] = element;
		numberOfElements++;
	}

	public E remove(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("ArrayList index cannot be a negative number");
		} else if (index >= numberOfElements) {
			throw new IndexOutOfBoundsException("ArrayList index exceeds the last element index");
		}
		E removedElement = (E) array[index];

		for (; index < (numberOfElements - 1); index++) {
			array[index] = array[index + 1];
		}
		array[numberOfElements - 1] = null;
		numberOfElements--;
		return (removedElement);
	}
	
	public void clear() {
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}

	public int getNumberOfElements() {
		return array.length;
	}

	public E get(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("ArrayList index cannot be a negative number");
		} else if (index >= numberOfElements) {
			throw new IndexOutOfBoundsException("ArrayList index exceeds the last element index");
		} else {
			return array[index];
		}
	}

	public void set(int index, E element) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("ArrayList index cannot be a negative number");
		} else if (index >= numberOfElements) {
			throw new IndexOutOfBoundsException("ArrayList index exceeds the last element index");
		} else {
			array[index] = element;
		}
	}

	public int occurrences(E element) {
		int count = 0;
		for (int index = 0; index < array.length - 1; index++) {
			if (array[index] == element) {
				count++;
			}
		}
		return count;
	}
	public boolean empty() {
		if (array.length == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void saveToFile(String filename) throws IOException {
		PrintWriter fileOutput = new PrintWriter(filename);
		for (int index = 0; index < array.length - 1; index++) {
			fileOutput.println(array[index]);
		}
		fileOutput.close();
	}
}
