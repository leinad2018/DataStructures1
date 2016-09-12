package linkedListInClass;

public class MergeSort {

	private static void merge(String[] data, int first, int n1, int n2) {
		String[] temp = new String[n1 + n2];
		int copied = 0;
		int copied1 = 0;
		int copied2 = 0;

		while ((copied1 < n1) && (copied2 < n2)) {
			if (data[first + copied].compareTo(data[first + n1 + copied2]) < 0)
				temp[copied++] = data[first + (copied1++)];
			else
				temp[copied++] = data[first + n1 + (copied2++)];
		}

		while (copied1 < n1)
			temp[copied++] = data[first + (copied1++)];

		for (int i = 0; i < copied; i++)
			data[first + i] = temp[i];

	}

	public static void mergesort(String[] data, int first, int n) {
		int n1 = 0;
		int n2 = 0;

		if (n > 1) {
			n1 = n / 2;
			n2 = n - n1;

			mergesort(data, first, n1);
			mergesort(data, first + n1, n2);
		}

		merge(data, first, n1, n2);
		
	}
}
