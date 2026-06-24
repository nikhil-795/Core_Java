package org.Revision;

public class NodeCaller {
    public static void main(String[] args) {
        // head [10,next]->[20,next]->[30,null

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
