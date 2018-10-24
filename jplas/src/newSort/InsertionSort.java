package newSort;

/*
 * テストコードを参照し，挿入ソートを用いて整数配列をソートするクラスを作成しなさい．
 * ただし，ソートの各ステップにおいて配列の置換状況を表す文字列を返り値として作りこむこと．
 */

/**
 * 挿入ソート
 */
class InsertionSort {
	/*
	 * 挿入ソートによって配列を整列する
	 *
	 * @param a 整列する配列
	 */
	public static String sort(int[] a) {
		StringBuffer bf = new StringBuffer();
		int n = a.length; // 配列の要素数

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
