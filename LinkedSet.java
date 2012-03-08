///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Browser.java
// File:             LinkedSet.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen  ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//                   
//                   STUDENTS WHO GET HELP FROM ANYONE OTHER THAN THEIR PARTNER
// Credits:          Jason Power
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Iterator;

/**
 * Concrete implementation of sets using doubly-linked lists.
 * <p>
 * <strong>Modify this class to implement the required {@link SimpleSet} methods
 * along with any private fields or methods you feel are
 * necessary.</strong>
 * 
 * @param <E>
 *            the type of data to be stored in this set
 **/

public class LinkedSet<E> implements SimpleSet<E> {
	private DoubleListnode<E> tail;
	private DoubleListnode<E> head = null;
	private int numItems;
	private Iterator<E> iter;

	/**
	 * Create a new, empty list.
	 */
	public LinkedSet() {
		tail = null;
		numItems = 0;
	}

	@Override
	public boolean add(E item) {
		DoubleListnode<E> newNode;
		if (numItems == 0){
			tail = new DoubleListnode<E>(item);
			head = tail;
			numItems++;
			return true;
		}
		else {
			iter = iterator();
			while (iter.hasNext()){
				if (item.equals(iter.next())){
					return false;
				}
			}
			newNode = new DoubleListnode<E>(tail, item, null);
			tail.setNext(newNode);
			tail = newNode;
			numItems++;
		}
		return false;
	}

	@Override
	public boolean contains(E target) {
		iter = iterator();
		while (iter.hasNext()){
			if (target ==  iter.next()){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		iter = iterator();
		while (iter.hasNext()){
			return false;
		}
		return true;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedSetIterator<E>(head);
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public boolean remove(E item) {
		if (!contains(item) || isEmpty()){
			return false;
		}
		if (item.equals(head.getData())){
			if (head.equals(tail)){
				tail = null;
				head = null;
				numItems = 0;
				return true;
			}
			else if (head.getNext().equals(tail)){
				tail.setPrev(null);
				head = tail;
				numItems--;
				return true;
			}
			else {
				head = head.getNext();
				head.getNext().setPrev(null);
				head = head.getNext();
				numItems--;
				return true;
			}
		}
		else if (item.equals(tail.getData())){
			if (tail.equals(head)){
				tail = null;
				head = null;
				numItems = 0;
				return true;
			}
			else if (tail.getPrev().equals(head)){
				head.setNext(null);
				tail = null;
				numItems--;
				return true;
			}
			else {
				tail.getPrev().setNext(null);
				tail = tail.getPrev();
				numItems--;
				return true;
			}
		}
		else {
			iter = iterator();
			E curr;
			while (iter.hasNext()){
				curr = iter.next();
				if (item.equals(curr)){
					iter.remove();
					numItems--;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public SimpleSet<E> union(SimpleSet<E> other) {
		LinkedSet<E> ls = new LinkedSet<E>();
		iter = iterator();
		Iterator<E> iter2;
		E curr;
		E curr2;
		while (iter.hasNext()){
			curr = iter.next();
			ls.add(curr);
		}
		iter = iterator();
		while(iter.hasNext()){
			curr = iter.next();
			iter2 = other.iterator();
			while(iter2.hasNext()){
				curr2 = iter2.next();
				if (!curr.equals(curr2)){
					ls.add(curr2);
				}
			}
		}

		return ls;
	}

	@Override
	public SimpleSet<E> intersection(SimpleSet<E> other) {
		LinkedSet<E> ls = new LinkedSet<E>();
		iter = iterator();
		Iterator<E> iter2;
		E curr;
		E curr2;
		while(iter.hasNext()){
			curr = iter.next();
			iter2 = other.iterator();
			while(iter2.hasNext()){
				curr2 = iter2.next();
				if (curr.equals(curr2)){
					if (!ls.contains(curr2)){
						ls.add(curr2);
					}
				}
			}
		}

		return ls;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		if (head != (null)){
			head.setNext(null);
		}
		numItems = 0;
	}
}
