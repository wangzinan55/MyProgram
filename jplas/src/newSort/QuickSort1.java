package newSort;

public 
class QuickSort1 {
	private static int partition(int[] a, int low, int high) {

		int i = low - 1;
		int j = high;
		int pivot = a[high];

		while (true) {
			while (a[++i] < pivot);
			while (i < --j && pivot < a[j]);
			if (i >= j)
				break;
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}

		int temp = a[i];
		a[i] = a[high];
		a[high] = temp;
		return i;
	}
	
	private static void quickSort(int[] a, int low, int high) {
		bf.append(a[0]);
		for (int i2 = 1; i2 < a.length; i2++) {
			bf.append("\t" + a[i2]);
		}
		bf.append("\n");
		if (low >= high)
			return;

		int v = partition(a, low, high);

		quickSort(a, low, v - 1);
		quickSort(a, v + 1, high);
	}
	
	public static String sort(int[] a) {
		bf = new StringBuffer();
		quickSort(a, 0, a.length - 1);
		return bf.toString();
	}
	static StringBuffer bf;
}

