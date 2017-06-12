package com.circluarDoublyLinkedList;

public class CircluarDoublyLinkedListImpl {

	private CDoublyNode head;
	private CDoublyNode dynamicList;
	private int size;

	CircluarDoublyLinkedListImpl() {

		size = 0;

	}

	public void insertNode(int data) {

		if (data == 0)
			return;

		CDoublyNode newNode = new CDoublyNode(data);

		if (head == null) {
			dynamicList = newNode;
			dynamicList.next = dynamicList;
			dynamicList.prev = dynamicList;
			head = dynamicList;
		} else {
			newNode.prev = dynamicList.prev;
			newNode.next = dynamicList;
			dynamicList.prev.next = newNode;
			dynamicList.prev = newNode;
			head = dynamicList;
		}
		size++;
	}

	public void printElements() {

		if (size == 0)
			return;

		CDoublyNode temp = head;
		System.out.println("Print Circlar list elements");

		do {
			System.out.println(temp.data);
			temp = temp.next;

		} while (temp != head);

	}

	public void insertAtPosition(int pos, int nodeData) {

		CDoublyNode newNode = new CDoublyNode(nodeData);

		CDoublyNode current = head;

		// imp: here i<pos not i<=pos because each iteration we are moving
		// forward node so
		for (int i = 0; i < pos; i++) {

			current = current.next;

		}

		newNode.prev = current.prev;
		newNode.next = current;
		// what relation between current and new node ?
		current.prev.next = newNode;
		current.prev = newNode;

		size++;

	}

	public void deleteAt(int pos) {

		if (pos > size - 1)
			return;

		CDoublyNode deleteNode = head;

		// imp: here i<pos not i<=pos because each iteration we are moving
		// forward node so
		for (int i = 0; i < pos; i++) {

			deleteNode = deleteNode.next;

		}

		deleteNode.prev.next = deleteNode.next;
		deleteNode.next.prev = deleteNode.prev;
		size--;

	}

	public class CDoublyNode {

		private int data;
		private CDoublyNode prev;
		private CDoublyNode next;

		CDoublyNode(int data) {

			this.data = data;
		}
	}

	public static void main(String[] args) {

		CircluarDoublyLinkedListImpl obj = new CircluarDoublyLinkedListImpl();
		obj.insertNode(10);
		obj.insertNode(20);
		obj.insertNode(30);
		obj.insertNode(40);
		obj.insertNode(50);
		obj.printElements();
		obj.insertAtPosition(2, 25);
		obj.printElements();
		obj.deleteAt(2);
		obj.printElements();

	}
}
