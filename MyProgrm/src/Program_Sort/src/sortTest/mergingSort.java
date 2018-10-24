package Program_Sort.src.sortTest;

import java.util.Arrays; 

import javax.sound.midi.MidiEvent;

/**
 * 归并排序
 * 简介:将两个或两个以上有序表合并成一个新的有序表，把待排序序列分成若干个子序列，每个子序列式有序的。然后再把有序子序列合并为整体有序序列 
 * 时间复杂度为O(nlogn) 
 * 稳定排序方式
 
 * @author Wangzinan
 *
 */


public class mergingSort {  
	 public static void merge(int[] a, int low, int mid, int high) {
	        int[] temp = new int[high - low + 1];
	        int i = low;// 左指针
	        int j = mid + 1;// 右指针
	        int k = 0;
	        // 把较小的数先移到新数组中
	        while (i <= mid && j <= high) {
	            if (a[i] < a[j]) {
	                temp[k++] = a[i++];
	            } else {
	                temp[k++] = a[j++];
	            }
	        }
	        // 把左边剩余的数移入数组
	        while (i <= mid) {
	            temp[k++] = a[i++];
	        }
	        // 把右边剩余的数移入数组
	        while (j <= high) {
	            temp[k++] = a[j++];
	        }
	        // 把新数组中的数覆盖nums数组
	        for (int k2 = 0; k2 < temp.length; k2++) {
	            a[k2 + low] = temp[k2];
	        }
	    }

	    public static void mergeSort(int[] a, int low, int high) {
	        int mid = (low + high) / 2;
	        if (low < high) {
	            // 左边
	            mergeSort(a, low, mid );
	            // 右边
	            mergeSort(a, mid + 1, high);
	            // 左右归并
	            merge(a, low, mid, high);
	            System.out.println(Arrays.toString(a));
	        }

	    }

	    public static void main(String[] args) {
	        int a[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
	        mergeSort(a, 0, a.length - 1);
	        System.out.println("排序结果" + Arrays.toString(a));
	    }
   
} 
