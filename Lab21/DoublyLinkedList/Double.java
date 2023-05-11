class Node {
	private final char m_val;
        static int count;
	Node prev;
	Node next;
	Node(char m_val) {
                this.m_val=m_val;
                count++;
        }
	public char getVal() {
                return this.m_val;
        }
}
class DoubleList {
	Node head;
	Node current;
	DoubleList() {
                head = null;
                current = null;
        }
	Node head() {
                current = head;
                return current;
        }
	Node current() {
                return current;
        }
	Node peek() {
		if (current == null)
                        return null;
                else
		        return current.next;
	}
	Node next() {
		Node retval = current;
		if (current != null)
			current = current.next;
		return retval;
	}
	void add(Node n) throws IndexOutOfBoundsException {
                if(head() == null) {
                        head = current;
                        current = n;
                        current.prev = null;
                        current.next = null;
                } else {
                        n.next = current.next;
                        current.next = n;
                        n.prev = current;
                        if(n.next != null)
                                n.next.prev = n;
                }
                current = n;
	}
	void add(char c) {
                add(new Node(c));
        }
	void remove() throws IndexOutOfBoundsException {
                if(current == null)
                        return;
                if(head == current)
                        head = current.next;
                if(current.next != null)
                        current.next.prev = current.prev;
                if(current.prev != null)
                        current.prev.next = current.next;
                return;
                /*
                if(current == null) {
                        System.out.println("null");
                        return;
                } else if(current.prev != null && current.next != null) {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                        System.out.println("0");
                } else if(current.prev == null) {
                        current = current.next;
                        System.out.println("1");
                } else if(current.next == null) {
                        current = current.prev;
                        System.out.println("2");
                }
                */
	}
}

public class Double {
	static void PrintList(DoubleList list) {
                while(list.current != null) {
                        System.out.println("hi");
                        System.out.println(list.current().getVal());
                        list.next();
                }
	}
	public static void main(String[] args) {
		DoubleList list = new DoubleList();
		// Put the letters 'a' through 'z' into the list.
		for(char c = 'a'; c <= 'z'; c++) {
			list.add(c);
		}
		// Go through a sequence of list operations.
		// These should not cause any errors.
		list.head();
		list.add('!');
		list.head();
		list.remove();
		list.next();
		list.remove();
		list.next();
		list.remove();
		list.add('@');
		list.next();
		list.next();
		list.add('#');
		list.remove();
		list.next();
		list.add('$');
		list.next();
		list.remove();
		list.next();
		list.next();
		list.next();
		list.next();
		list.next();
		list.next();
		list.remove();
		list.next();
		list.next();
		// Output the final list.
		PrintList(list);
	} // end main()

} // end class Double
