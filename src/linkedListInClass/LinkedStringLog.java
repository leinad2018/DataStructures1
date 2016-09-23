package linkedListInClass;

import java.util.Arrays;

public class LinkedStringLog implements StringLogInterface {
	protected LLStringNode log; // reference to first node of linked
								// list that holds the StringLog strings
	protected String name; // name of this StringLog

	public LinkedStringLog(String name)
	// Instantiates and returns a reference to an empty StringLog object
	// with name "name".
	{
		log = null;
		this.name = name;
	}

	public void insert(String element)
	// Precondition: This StringLog is not full.
	//
	// Places element into this StringLog.
	{
		LLStringNode newNode = new LLStringNode(element);
		newNode.setLink(log);
		log = newNode;
	}

	public boolean isFull()
	// Returns true if this StringLog is full, false otherwise.
	{
		return false;
	}

	public int size()
	// Returns the number of Strings in this StringLog.
	{
		int count = 0;
		LLStringNode node;
		node = log;
		while (node != null) {
			count++;
			node = node.getLink();
		}
		return count;
	}

	public boolean contains(String element)
	// Returns true if element is in this StringLog,
	// otherwise returns false.
	// Ignores case difference when doing string comparison.
	{
		LLStringNode node;
		node = log;

		while (node != null) {
			if (element.equalsIgnoreCase(node.getInfo())) // if they match
				return true;
			else
				node = node.getLink();
		}

		return false;
	}

	public void clear()
	// Makes this StringLog empty.
	{
		log = null;
	}

	public String getName()
	// Returns the name of this StringLog.
	{
		return name;
	}

	public String toString()
	// Returns a nicely formatted string representing this StringLog.
	{
		String logString = "Log: " + name + "\n\n";
		LLStringNode node;
		node = log;
		int count = 0;

		while (node != null) {
			count++;
			logString = logString + count + ". " + node.getInfo() + "\n";
			node = node.getLink();
		}

		return logString;
	}

	public void remove(String element) throws Exception {
		if (this.contains(element)) {
			if (log == null)
				throw new Exception("empty list");
			LLStringNode toRemove;
			if (log.getInfo().equalsIgnoreCase(element)) {
				toRemove = log;
				log = log.getLink();
				toRemove.setLink(null);
				return;
			}

			LLStringNode tempNode = log;
			while (tempNode != null) {
				if (tempNode.getLink().getInfo().equalsIgnoreCase(element)) {
					toRemove = tempNode.getLink();
					tempNode.setLink(tempNode.getLink().getLink());
					toRemove.setLink(null);
					return;
				}
				tempNode = tempNode.getLink();
			}
		}
		throw new Exception("Node not found");
	}

	public void insertLast(String element) {
		LLStringNode tempNode = log;
		while (tempNode.getLink() != null) {
			tempNode = tempNode.getLink();
		}
		tempNode.setLink(new LLStringNode(element));
	}

	public boolean equals(Object anObject) {
		LinkedStringLog other;
		if (anObject instanceof LinkedStringLog) {
			other = (LinkedStringLog) anObject;
		} else {
			return false;
		}

		int length = size();
		if (other.size() != length) {
			return false;
		}

		String[] list1 = new String[length];
		String[] list2 = new String[length];

		LLStringNode tempNode1 = log;
		LLStringNode tempNode2 = other.log;

		for (int i = 0; i < length; i++) {
			list1[i] = tempNode1.getInfo();
			tempNode1 = tempNode1.getLink();

			list2[i] = tempNode2.getInfo();
			tempNode2 = tempNode2.getLink();
		}

		Arrays.sort(list1);
		Arrays.sort(list2);

		for (int i = 0; i < length; i++) {
			if (list1[i] != list2[i]) {
				return false;
			}
		}

		return true;
	}
}
