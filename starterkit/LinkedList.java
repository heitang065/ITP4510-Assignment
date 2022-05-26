/*
 * Class : L i n k e d L i s t
 * 
 * @Name : Tang Chun Hei
 * @StdID: 200022972
 * @Class: IT114105/1D
 * @2021-02-19
 */
public class LinkedList {
    protected ListNode head, tail;
    // protected Comparator comparator;

    public LinkedList(/* Comparator comparator */) {
        head = tail = null;
        // this.comparator = comparator;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public void addToHead(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            tail.next = new ListNode(item);
            tail =  tail.next;
        }
    }

    public Object removeFromHead() throws EmptyListException {
         Object item = null;
         if (isEmpty()) {
             throw new EmptyListException();
         }
         item = head.data;
         if (head == tail)      // there's only one single node
             head = tail = null;
         else
             head = head.next;
         return item;

     }
	// unnecessary
    // public Object removeFromTail() throws EmptyListException {
        // if (isEmpty()) {
            // throw new EmptyListException();
        // } 
        // Object item = tail.data;
        // if (head == tail) {   // there is only one node
            // head = tail = null;
            // return item;
        // }
        // ListNode current = head;
        // while (current.next != tail)
            // current = current.next;
        // tail = current;
        // tail.next = null;
        // return item;
    // }

    // public String toString() {
        // String s = "[ ";
        // ListNode current = head;
        // while (current != null) {
            // s += current.data + " ";
            // current = current.next;
        // }
        // return s + "]";
    // }
}
