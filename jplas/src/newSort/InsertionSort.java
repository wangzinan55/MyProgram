package newSort;

/*
 * �ƥ��ȥ��`�ɤ���դ������륽�`�Ȥ��ä����������Ф򥽩`�Ȥ��륯�饹�����ɤ��ʤ�����
 * �����������`�Ȥθ����ƥåפˤ��������Ф��ÓQ״�r��������Ф򷵤ꂎ�Ȥ������ꤳ�ळ�ȣ�
 */

/**
 * ���륽�`��
 */
class InsertionSort {
	/*
	 * ���륽�`�Ȥˤ�ä����Ф����Ф���
	 *
	 * @param a ���Ф�������
	 */
	public static String sort(int[] a) {
		StringBuffer bf = new StringBuffer();
		int n = a.length; // ���Ф�Ҫ����

		for (int i = 1; i < n; i++) {
			int j = i;
			while (j >= 1 && a[j - 1] > a[j]) {
				int temp = a[j];
				a[j] = a[j - 1];
				a[j - 1] = temp;
				j--;
			}
			bf.append(a[0]);
			for (int i2 = 1; i2 < n; i2++) {
				bf.append("\t"+a[i2]);
			}
			bf.append("\n");
		}
		return bf.toString();
	}
}
