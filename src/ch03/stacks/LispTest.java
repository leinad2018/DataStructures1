package ch03.stacks;

public class LispTest {

	public static void main(String[] args) {
		LispEvaluator ev = new LispEvaluator();
		try {
			System.out.println("Test Case 1: " + ev.evaluate("(+ (- 8 2 3) (- 9 1 (/ (+ 1 2 3 4) (+))))"));
		} catch (Exception e) {
			System.out.println("Test Case 1: Divide by Zero");
		}
		System.out.println("Test Case 2: " + ev.evaluate("(- (* (- 11 3 0) (+ 9 7 (/ (*) 2) 10)))"));
		System.out.println("Test Case 3: " + ev.evaluate("(/ (+ 24 (- (- 12) 12)) (*) (+ (+) 1))"));
		System.out.println("Test Case 4: " + ev.evaluate("(* (+ (*) (*) (*)) (+ (* (+ (*) (*) (*) (*)) (+ (*) (*) (*) (*) (*))) (*) (*) (*)))"));
		System.out.println("Test Case 5: " + ev.evaluate("(* 5.2 3 (/ 2 3 2.5) 7 (- 5.3 1.2 -3.3) (/ (+ 2.3 1.0 (+) (*) (- 5.3))))"));
	}
}
