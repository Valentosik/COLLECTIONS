public class LinkedList<E> {
    private Node<E> first;
    private Node<E> last;

    private int length;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedList() {
        first = null;
        length = 0;
        last = null;
        first = null;
    };

    public LinkedList(int length) {
//        Создать с нужной длиной
//        А оно надо?
    }

    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        length++;
    }

    public void add(int index, E e) {
        checkPosition(index);

        if (index == length) {
            add(e);
        } else {
            connectBefore(e, getNode(index));
        }
    }

    public void checkPosition(int index) throws IllegalArgumentException {
        if (!isPositionInIndex(index)) {
            throw new IllegalArgumentException("Range out");
        }

    }

    public boolean isPositionInIndex(int index) {
        return index >= 0 && index <= length;
    }

    public void print() {
        StringBuilder s = new StringBuilder(length);
        s.append("[");
        Node<E> tmp = first;
        for (int i = 0; i < length; i++ ) {
            s.append(tmp.element + ", ");
            tmp = tmp.next;
        }
        s.setLength(s.length() - 2);
        s.append("]");
        System.out.println(s);
    }

    public void connectBefore(E e, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);

        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        length++;
    }


    Node<E> getNode(int index) {
        checkPosition(index);


        // Начать с конца?
        Node<E> tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }

        return tmp;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(25);

        System.out.println(linkedList.getNode(1).element);
        linkedList.print();
    }

}
