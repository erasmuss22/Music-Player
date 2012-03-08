
/**
 * Public interface to abstract data types representing sets of values.
 * <p>
 * <strong>Do not modify this file in any way!</strong>
 * 
 * @author Ben Liblit
 * @param <E>
 *            the type of data to be stored in this set
 **/

public interface SimpleSet<E> extends Iterable<E> {

	/**
	 * Adds the given item to this set if it is not already present.
	 * 
	 * @param item
	 *            reference to the item to be added
	 * @return true if the given item was added, false if it's already present
	 **/
	public boolean add(E item);

	/**
	 * Removes the given item from this set if it is present.
	 * 
	 * @param item
	 *            reference to the item to be removed
	 * @return true if the given item was removed, false otherwise
	 **/
	public boolean remove(E item);

	/**
	 * Determines if this set contains the given item.
	 * 
	 * @param item
	 *            reference to the item to be found
	 * @return true if the given item is in the set, false otherwise
	 **/
	public boolean contains(E item);

	/**
	 * Constructs a new set containing the items in this set and the given set
	 * but excluding duplicates.
	 * 
	 * <p>
	 * Note: this operation does not change the original sets!
	 * </p>
	 * 
	 * @param other
	 *            the other set to unify with this set
	 * 
	 * @return the new set containing the union
	 **/
	public SimpleSet<E> union(SimpleSet<E> other);

	/**
	 * Constructs a new set containing only the items that this set and the
	 * given set share in common.
	 * 
	 * <p>
	 * Note: this operation does not change the original sets!
	 * </p>
	 * 
	 * @param other
	 *            the other set to intersect with this set
	 * 
	 * @return the new set containing the intersection
	 **/
	public SimpleSet<E> intersection(SimpleSet<E> other);

	/**
	 * Removes all of the items from this set.
	 **/
	public void clear();

	/**
	 * Returns the size of this set, i.e., the number of items it contains.
	 * 
	 * @return the number of items in this set
	 **/
	public int size();

	/**
	 * Determines if this set is empty, i.e., contains no items.
	 * 
	 * @return true of the set is empty, false otherwise
	 **/
	public boolean isEmpty();
}
