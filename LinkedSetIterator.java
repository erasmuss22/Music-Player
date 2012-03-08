///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  Browser.java
// File:             LinkedSetIterator.java
// Semester:         Spring 2011
//
// Author:           Erin Rasmussen  ejrasmussen2@wisc.edu
// CS Login:         rasmusse
// Lecturer's Name:  Beck Hasti
// Lab Section:      Lecture 2
//
//                   
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.*;

/**
 * Implementation of the {@link Iterator} interface for use with
 * {@link LinkedSet}.
 * <p>
 * <strong>Modify this class to implement the required {@link Iterator} methods
 * along with any constructors, fields, or other methods you feel are
 * necessary.</strong>
 * 
 * @author Ben Liblit
 * @param <E>
 *            the type of data stored in the list
 */
public class LinkedSetIterator<E> implements Iterator<E> {
	private DoubleListnode<E> curr;
	private DoubleListnode<E> prev;


	LinkedSetIterator(DoubleListnode<E> head){
		curr = head;
	}

	@Override
	public boolean hasNext() {
		return curr != null;
	}

	public E next() {
		if (!hasNext()){
			throw new NoSuchElementException();
		}
		E stuff = curr.getData();
		prev = curr;
		curr = curr.getNext();
		return stuff;
	}

	public void remove() {
		prev = prev.getPrev();
		prev.setNext(curr);
		curr.setPrev(prev);
	}
}
