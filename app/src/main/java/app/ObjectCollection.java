package app;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.prefs.BackingStoreException;
import org.apache.commons.lang3.StringUtils;

import util.Collectable;

public class ObjectCollection<T> implements Collectable<T> {

	private int topViewCounter = 0;
	private TreeSet<T> collection = null;

	public ObjectCollection(int topView) {
		if (topView <= 0) {
			throw new IllegalArgumentException("Invalid index. Must be greater than zero.");
		}

		this.setTopViewCounter(topView);
		this.setCollection(new TreeSet<T>());
	}

	public boolean offer(T o) {
		if (o == null) {
			throw new NullPointerException("Invalid argument. Null value.");
		}

		if (StringUtils.isBlank(o.toString())) {
			throw new IllegalArgumentException("Invalid argument. Empty value.");
		}

		return (this.getCollection().add(o));

	}

	public List<T> getTopK() throws BackingStoreException {

		/*
		// This will not happen, unless someone uses reflection to create
		//  the object without a backing store.
		// Throw exception if the backing store is not initialized.
		if (this.getCollection() == null) {
			throw new BackingStoreException("Invalid backing store.");
		}
		*/

		List<T> subCollection = new ArrayList<T>();

		int n = 1;

		int topK = this.getTopViewCounter();

		// Running a for loop is more performant than usig other APIs
		// like, subview.
		for (T t : this.getCollection()) {
			if (n > topK) {
				break;
			}
			subCollection.add(t);
			n++;
		}

		return subCollection;
	}

	/**
	 * Gets the TopView Counter.
	 * 
	 * @return
	 */
	private int getTopViewCounter() {
		return topViewCounter;
	}

	/**
	 * Sets the TopView Counter
	 * 
	 * @param topViewCounter
	 */
	private void setTopViewCounter(int topViewCounter) {
		this.topViewCounter = topViewCounter;
	}

	/**
	 * Gets the internal backing store
	 * 
	 * @return
	 */
	private TreeSet<T> getCollection() {
		return collection;
	}

	/**
	 * Sets the internal backing store
	 * 
	 * @param collection
	 */
	private void setCollection(TreeSet<T> collection) {
		this.collection = collection;
	}
}