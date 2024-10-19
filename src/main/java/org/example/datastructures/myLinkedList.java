package org.example.datastructures;

public class myLinkedList<T> {

    Node<T> head;

    static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    void addDataNode(T data)  {
        if(head == null) {
            head = new Node<T>(data);
            head.next = null;
        } else {
            Node<T> tempNode;
            tempNode = head;
            while(tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = new Node(data);
        }
    }

    void removeNodeAtLast() {

        if (head == null) {
            return;
        }

        Node tempNode = head;
        Node prevNode = head;

        while(tempNode.next != null) {
            prevNode = tempNode;
            tempNode = tempNode.next;
        }

        if(head == tempNode) {
            head = null;
            return;
        }

        prevNode.next = null;
    }

    void display() {

        if (head == null) {
            System.out.println("empty list");
            return;
        }

        Node temp = head;

        while(temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        myLinkedList<String> linkedList = new myLinkedList<>();

        linkedList.addDataNode("hello");
        linkedList.addDataNode("hi");
        linkedList.addDataNode("kya");
        linkedList.addDataNode("kya2");
        linkedList.addDataNode("kya3");

        linkedList.removeNodeAtLast();
        linkedList.removeNodeAtLast();

        linkedList.display();
    }
}
