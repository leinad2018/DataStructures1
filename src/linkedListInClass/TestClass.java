package linkedListInClass;

public class TestClass {
	public static void main(String[] args){
		LinkedStringLog log1 = new LinkedStringLog("bob");
		LinkedStringLog log2 = new LinkedStringLog("fred");
		
		log1.insert("hello");
		log1.insert("hi");
		log1.insert("hi");
		log2.insert("hi");
		log2.insert("hello");
		log2.insert("hello");
		
		System.out.println(log1.equals(log2));
	}

}
