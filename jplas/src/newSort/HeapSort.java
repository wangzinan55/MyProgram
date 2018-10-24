package newSort;


/**
 * ������
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
			// ���浱ǰ�����жϵĽڵ�
			int k = i;
			// ����ǰ�ڵ���ӽڵ����
			while (2 * k + 1 <= lastIndex) {
				// biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�
				int biggerIndex = 2 * k + 1;
				// �����ӽڵ���ڣ������ʱbiggerIndexӦ�õ��� lastIndex
				if (biggerIndex < lastIndex && arr[biggerIndex] < arr[biggerIndex + 1]) {
						// �����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ
						biggerIndex++;
				}
				if (arr[k] < arr[biggerIndex]) {
					// ����ǰ�ڵ�ֵ���ӽڵ����ֵС���򽻻�2�ߵ�ֵ��������biggerIndexֵ��ֵ��k
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