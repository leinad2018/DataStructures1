package linkedListInClass;

public class TestClass {

	public static void main(String[] args) {
		LinkedStringLog log1 = new LinkedStringLog("bob");
		LinkedStringLog log2 = new LinkedStringLog("fred");
		
		log1.insert("a");
		log1.insert("v");
		log1.insert("b");
		log2.insert("v");
		log2.insert("b");
		log2.insert("a");
		System.out.println(log1.equals(log2));
	}

}
