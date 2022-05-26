/*
 * Interface : S t r i n g C o m p a r a t o r
 * 
 * @Name : Tang Chun Hei
 * @StdID: 200022972
 * @Class: IT114105/1D
 * @2021-02-19
 */
public class IdenList extends LinkedList {
	private Comparator comparator;
	public IdenList(Comparator comparator) {
		super();
		this.comparator = comparator;
	}

	private Identifier newIden(Object item, int line) { // method for create a sup-linked list and add line number.
		Identifier iden = (Identifier) item;
		iden.list = new LinkedList();
		iden.list.addToTail(line);
		return iden;
	}
	
	public void insertInOrder(Object item, int line) {
        if (isEmpty()) {
            head = tail = new ListNode(newIden(item, line));
        } else {
            if (comparator.isGreaterThan(head.data, item)) {
                addToHead(newIden(item, line));
            } else if (comparator.isLessThan(tail.data, item)) {
                addToTail(newIden(item, line));
            } else if (comparator.isEqualTo(head.data, item)) {
				((Identifier) head.data).list.addToTail(line);
			} else {
                // insert in the middle
                ListNode current = head;
                while (current.next != null) {
                    if (comparator.isEqualTo(current.next.data, item)) {
                        ((Identifier) current.next.data).list.addToTail(line);
                        return;
                    } else if (comparator.isGreaterThan(current.next.data, item)) {
                        ListNode newNode = new ListNode(newIden(item, line));
                        newNode.next = current.next;
                        current.next = newNode;
                        return;
                    }
                    current = current.next;
                }
            }
        }
    }
}