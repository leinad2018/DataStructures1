package linkedListInClass;

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
		
		String[] list1 = new String[size()];
		String[] list2 = new String[other.size()];
		
		if(list1.length != list2.length){
			return false;
		}
		
		LLStringNode temp = log;
		LLStringNode temp2 = other.log;
		for(int i = 0; i < list1.length; i++){
			list1[i] = temp.getInfo();
			list2[i] = temp2.getInfo();
			temp = temp.getLink();
			temp2 = temp2.getLink();
		}
		
		MergeSort.mergesort(list1, 0, list1.length);
		MergeSort.mergesort(list2, 0, list2.length);
		
		for(int i = 0; i < list1.length; i++){
			System.out.println(list1[i] + " " + list2[i]);
			if(!(list1[i].equals(list2[i]))){
				return false;
			}
		}

		return true;
	}
}
