package linklist;

public class LinkedList {
    private Node head;
    private Node tail;
    public int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value, int index) {
        if (head == null) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }
        Node prev = get(size - 2);
        int val = tail.value;
        tail = prev;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) return deleteFirst();
        if (index == size - 1) return deleteLast();
        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public void deleteByValue(int val) {
        if (head == null) return;
        if (head.value == val) {
            deleteFirst();
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == val) {
                current.next = current.next.next;
                size--;
                if (current.next == null) {
                    tail = current;
                }
                return;
            }
            current = current.next;
        }
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + "->");
            node = node.next;
        }
        System.out.print("End");
    }
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void reverse() {
        Node node = head;
        Node prev = null;
        Node next;
        tail = head;
        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head = prev;
    }
    //two pointers
    public void make() {
        Node curr = head;
        curr = get(4);
        System.out.println(curr);
    }
    public void reorder() {
        if (head == null || head.next == null) return;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondhalf = reverseList(slow.next);
        slow.next = null;
        Node firstHalf = head;
        while (secondhalf != null) {
            Node temp1 = firstHalf.next;
            Node temp2 = secondhalf.next;
            firstHalf.next = secondhalf;
            secondhalf.next = temp1;
            firstHalf = temp1;
            secondhalf = temp2;
        }
    }

    private Node reverseList(Node node) {
        Node prev = null;
        Node curr = node;
        while (curr != null) {
            Node nextTemp = prev;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}


