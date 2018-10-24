package newSort;

/*
 * ������ �������ɸ����ӣ�����ɨ�������ļ�¼R[0],R[1]��R[n-1]
 * �ѹؼ��ֵ���k�ĵļ�¼��װ�뵽��k�����������
 * Ȼ��������ν����ǿյ�������β���������ռ�
 */
public class BinSort {
	
	public static int[] sort(int[] arr,int range){
		//��������
		int[] boxs = new int[range];
		//�������е����ŵ�ָ����������
		for(int i = 0; i < arr.length; i++){
			boxs[arr[i]]++;
		}
		//��������

		int[] result = new int[arr.length];
		//������±�
		int index = 0;
		//�������ӣ�������ֵ�Ľ���ȡ��ƴ�ӣ������һ���������ж������������ƴ����ͬ��ֵ

		for(int i = 0; i < boxs.length; i++){
			for(int j = 0; j < boxs[i]; j++){
				result[index] = i;
				index++;
			}
		}
		printArray(result);
		return result;
	}

	private static void printArray(int[] array){
		
		System.out.print("{");
		for(int i = 0; i < array.length; i++){
			
			System.out.print(array[i]);
			if(i < array.length - 1){
				
				System.out.print(",");
			}
		}
		System.out.print("}");
	}
}
