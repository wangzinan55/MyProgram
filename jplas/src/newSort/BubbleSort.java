package newSort;

/*
 * テストコードを参照し，バブルソートを用いて整数配列をソートするクラスを作成しなさい．
 * ただし，ソートの各ステップにおいて配列の置換状況を表す文字列を返り値として作りこむこと．
 */

/**
 * バブルソート 冒泡排序
 */


class BubbleSort {
	/*
	 * バブルソートによって配列を整列する
	 *
	 * @param a 整列する配列
	 */
	String sort(int[] a) {
		StepsRecord recorder = new StepsRecord();
		int n = a.length; // 配列の要素数

		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
			recorder.record(a);
		}
		return recorder.toString();
	}

	/**
	 * メソッド内でのint型配列の変化を記録するクラス．
	 * 配列の要素がタブ\t区切りで，レコードの区切りは改行\nでおこなう．
	 * @author N.Ish
	 *
	 */
	class StepsRecord{
		StringBuffer bf = new StringBuffer();
		/**
		 * このメソッドが挿入された部分で引数として渡される配列を文字列として貯める
		 * @param a レコード対象のint型配列
		 */
		void record(int[] a){
			bf.append(a[0]);
			for (int i = 1; i < a.length; i++) {
				bf.append("\t"+a[i]);
			}
			bf.append("\n");
		}
		/**
		 * 記録した文字列を返す．
		 */
		@Override
		public String toString(){
			return bf.toString();
		}
	}
}