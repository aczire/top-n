package util;

import java.util.List;
import java.util.prefs.BackingStoreException;

public interface Collectable<T> {

	/***
	 * Appends the specified element to the end of this list.
	 * @param o element to be appended to this list
     * @return {@code true} if this set did not already contain the specified
     *         element
     * @throws ClassCastException if the specified object cannot be compared
     *         with the elements currently in this set
     * @throws NullPointerException if the specified element is null
     *         and this set uses natural ordering, or its comparator
     *         does not permit null elements
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements
     * @throws BackingStoreException if the backing store is null
	 */
	public boolean offer(T o);

	/***
	 * Returns the top view of the portion of the member list specified
     * <tt>fromIndex</tt>, during the instantiation of the collection, inclusive.
	 * @return a view of the specified range within this list
     * @throws BackingStoreException if the backing store is null
	 */
	public List<T> getTopK() throws BackingStoreException;
}