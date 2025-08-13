package linklist;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return "Node [data=" + data + "]";
    }

    public static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static Node findMiddle(Node head) {
        Node s = head;
        Node f = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
//
//    public static Node create(int[] ar) {
//        if (ar == null || ar.length == 0) return null;
//        Node head = new Node(ar[0]);
//        Node current = head;
//        for (int i = 1; i < ar.length; i++) {
//            Node temp = new Node(ar[i]);
//            current.next = temp;
//            current = current.next;
//        }
//        return head;
//    }


//public static boolean isPalindrome(Node head){
//        Node current=head;
//}

    public static void main(String[] args) {
        int[] ar={5,3,20};
        int[] ar1={2,11,22};
//        Node current=create(ar);
//        Node current=create(ar1);
//        Node current2= merfe
    }
}
