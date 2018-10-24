package newSort;


/**
 * 堆排序
 */

public class HeapSort {

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	public static int[] sort(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			createMaxdHeap(arr, arr.length - 1 - i);
			swap(arr, 0, arr.length - 1 - i);
			printArray(arr);
		}
		return arr;
	}

	private static void createMaxdHeap(int[] arr, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			// 保存当前正在判断的节点
			int k = i;
			// 若当前节点的子节点存在
			while (2 * k + 1 <= lastIndex) {
				// biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点
				int biggerIndex = 2 * k + 1;
				// 若右子节点存在，否则此时biggerIndex应该等于 lastIndex
				if (biggerIndex < lastIndex && arr[biggerIndex] < arr[biggerIndex + 1]) {
						// 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值
						biggerIndex++;
				}
				if (arr[k] < arr[biggerIndex]) {
					// 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k
					swap(arr, k, biggerIndex);
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	private static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

}