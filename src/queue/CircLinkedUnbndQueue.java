package queue;

import support.LLNode;

public class CircLinkedUnbndQueue<T> implements UnboundedQueueInterface<T> {

	protected LLNode<T> rear;

	public CircLinkedUnbndQueue() {

	}

	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		LLNode<T> tempNode = rear.getLink();
		if(tempNode == rear){
			rear = null;
			return tempNode.getInfo();
		}
		rear.setLink(rear.getLink().getLink());
		tempNode.setLink(null);
		return tempNode.getInfo();
	}

	public void enqueue(T element) {
		if(isEmpty()){
			rear = new LLNode<T>(element);
			rear.setLink(rear);
		}else{
			LLNode<T> newNode = new LLNode<T>(element);
			newNode.setLink(rear.getLink());
			rear.setLink(newNode);
			rear = rear.getLink();
		}
	}

	public boolean isEmpty() {
		return rear == null;
	}
}
