package newSort;

/*
 * 箱排序 设置若干个箱子，依次扫描待排序的记录R[0],R[1]…R[n-1]
 * 把关键字等于k的的记录都装入到第k个箱子里分配
 * 然后按序号依次将各非空的箱子首尾连接起来收集
 */
public class BinSort {
	
	public static int[] sort(int[] arr,int range){
		//设置箱子
		int[] boxs = new int[range];
		//将数组中的数放到指定的箱子中
		for(int i = 0; i < arr.length; i++){
			boxs[arr[i]]++;
		}
		//定义结果集

		int[] result = new int[arr.length];
		//结果集下标
		int index = 0;
		//遍历箱子，将存有值的进行取出拼接，如果有一个箱子中有多个数，结果多次拼接相同数值

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
