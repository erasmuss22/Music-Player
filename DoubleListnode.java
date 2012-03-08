/**
 * Generic doubly linked list node. It serves as the basic building block for
 * storing data in doubly linked lists, but is not visible outside of the linked
 * list implementation. <strong>Do not modify this file in any way!</strong>
 * 
 * @author Ben Liblit
 * @param <E>
 *            the type of data to be stored in each node
 * @see <a href="../../../../../../readings/Linked-Lists/#double">Doubly linked
 *      lists</a>
 */
public final class DoubleListnode<E> {
    /**
     * the data value stored in this node
     */
    private E data;

    /**
     * the next node after this one, or {@code null} if there is no following
     * node
     */
    private DoubleListnode<E> next;

    /**
     * the previous node before this one, or {@code null} if there is no
     * preceding node
     */
    private DoubleListnode<E> prev;

    /**
     * constructs a new list node and links it to its neighbors
     * 
     * @param prev
     *            the node before this one
     * @param data
     *            the data to be stored in this node
     * @param next
     *            the node after this one
     */
    public DoubleListnode(final DoubleListnode<E> prev, final E data, final DoubleListnode<E> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /**
     * constructs a new list node with no connections to neighbors. The node's
     * {@link #next} and {@link #prev} fields are set to {@code null}.
     * 
     * @param data
     *            the data to be stored in this node
     */
    public DoubleListnode(final E data) {
        this(null, data, null);
    }

    /**
     * @return the current data
     */
    public E getData() {
        return data;
    }

    /**
     * @return the current next node
     */
    public DoubleListnode<E> getNext() {
        return next;
    }

    /**
     * @return the current previous node
     */
    public DoubleListnode<E> getPrev() {
        return prev;
    }

    /**
     * @param data
     *            the new data
     */
    public void setData(final E data) {
        this.data = data;
    }

    /**
     * @param next
     *            the new next node
     */
    public void setNext(final DoubleListnode<E> next) {
        this.next = next;
    }

    /**
     * @param prev
     *            the new previous node
     */
    public void setPrev(final DoubleListnode<E> prev) {
        this.prev = prev;
    }

    /**
     * Returns a string representation of this node's data, or "(null)" if this
     * node's data is {@code null}.
     * 
     * @return the node's data as a string
     */
    @Override
    public String toString() {
        return data == null ? "(null)" : data.toString();
    }
}
