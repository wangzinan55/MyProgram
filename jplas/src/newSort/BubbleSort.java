package newSort;

/*
 * �ƥ��ȥ��`�ɤ���դ����Х֥륽�`�Ȥ��ä����������Ф򥽩`�Ȥ��륯�饹�����ɤ��ʤ�����
 * �����������`�Ȥθ����ƥåפˤ��������Ф��ÓQ״�r��������Ф򷵤ꂎ�Ȥ������ꤳ�ळ�ȣ�
 */

/**
 * �Х֥륽�`�� ð������
 */


class BubbleSort {
	/*
	 * �Х֥륽�`�Ȥˤ�ä����Ф����Ф���
	 *
	 * @param a ���Ф�������
	 */
	String sort(int[] a) {
		StepsRecord recorder = new StepsRecord();
		int n = a.length; // ���Ф�Ҫ����

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
	 * �᥽�å��ڤǤ�int�����ФΉ仯��ӛ�h���륯�饹��
	 * ���Ф�Ҫ�ؤ�����\t���Ф�ǣ��쥳�`�ɤ����Ф�ϸ���\n�Ǥ����ʤ���
	 * @author N.Ish
	 *
	 */
	class StepsRecord{
		StringBuffer bf = new StringBuffer();
		/**
		 * ���Υ᥽�åɤ����뤵�줿���֤������Ȥ��ƶɤ�������Ф������ФȤ����A���
		 * @param a �쥳�`�Ɍ����int������
		 */
		void record(int[] a){
			bf.append(a[0]);
			for (int i = 1; i < a.length; i++) {
				bf.append("\t"+a[i]);
			}
			bf.append("\n");
		}
		/**
		 * ӛ�h���������Ф򷵤���
		 */
		@Override
		public String toString(){
			return bf.toString();
		}
	}
}