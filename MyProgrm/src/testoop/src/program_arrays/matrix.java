package testoop.src.program_arrays;

import java.util.Arrays;

/**
 *打印指定矩阵
 * @author wangz
 *
 */
    public class matrix {
    	public static void print(int[][] c){
    		//打印矩阵
    		for(int i=0;i<c.length;i++){
    			for(int j=0;j<c.length;j++){
    				System.out.print(c[i][j]+"\t");
    			}
    		}
    	System.out.println();
    	}
	
	/**
	 * 矩阵加法
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[][] add(int[][] a,int[][] b){
		int[][] c = new int[a.length][a.length];
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				c[i][j]=a[i][j]+b[i][j];
			}
		}
		return c;
	}
	
	public static void main(String[] args){
		int[][] a ={
				{1,2},
				{3,4}
		};
		
		int[][] b ={
				{5,6},
				{7,8}
		};
		
		int[][] c = add(a,b);
		
		print(c);
	}
}
