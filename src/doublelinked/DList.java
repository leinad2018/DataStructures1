/**
 * 
 */
package doublelinked;

import support.*;

/**
 * @author Praveen Madiraju
 * 
 */
public class DList<T> {

	protected DLLNode<T> header;
	protected DLLNode<T> trailer;

	protected int size;

	/**
 * 
 */
	public DList() {
		header = null;
		trailer = null;
		size = 0;

	}

	/**
	 * @return the header
	 */
	public DLLNode<T> getHeader() {
		return header;
	}

	/**
	 * @return the trailer
	 */
	public DLLNode<T> getTrailer() {
		return trailer;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	// add element to the front of the list
	public void addToFront(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);

		if (header == null) {
			header = newNode;
		}
		if (trailer == null)
			trailer = newNode;
		else {
			newNode.setLink(header);
			header.setBack(newNode);
			header = newNode;
		}
		size++;

	}

	// add element to the end of the list
	public void addToLast(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);
		newNode.setLink(null);

		if (trailer == null) {
			trailer = newNode;
			header = newNode;
		} else {
			trailer.setLink(newNode);
			newNode.setBack(trailer);
			trailer = newNode;
		}

		size++;
	}

	public boolean isEmpty() {
		return header == null;
	}

	public void print() {
		DLLNode<T> v = header;
		while (v != null) {
			System.out.println(v.getInfo());
			v = (DLLNode) v.getLink();
		}

	}
	
	public void removeLast() throws Exception{
		if(isEmpty()){
			throw new Exception("Remove on empty list");
		}else if(size == 1){
			header = null;
			trailer = null;
		}else{
		trailer =(DLLNode) trailer.getBack();
		DLLNode<T> temp = (DLLNode) trailer.getLink();
		temp.setBack(null);
		trailer.setLink(null);
		}
	}
	
	public void remove(T element) throws Exception{
		if(isEmpty()){
			throw new Exception("Remove on empty list");
		}
		DLLNode<T> search = header;
		if(size == 1 && search.getInfo().equals(element)){
			removeLast();
			return;
		}
		if(search == header){
			header = (DLLNode<T>) header.getLink();
			header.getBack().setLink(null);
			header.setBack(null);
			return;
		}else if(search == trailer){
			removeLast();
			return;
		}
		while(search != null){
			if(search.getInfo().equals(element)){
				
			}
		}
	}
}
