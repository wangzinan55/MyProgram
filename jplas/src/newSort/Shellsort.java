package newSort;

public class Shellsort {
	
    public static String sort(int [] arrays){
    	
    	String result="";
    	int i, j,temp;   //ÐûÑÔ

    	for (int gap =arrays.length / 2; gap > 0; gap /= 2){	
    		for (i = gap; i < arrays.length; i++) {	   
    			temp = arrays[i];      
    			for (j = i - gap; j >= 0 && arrays[j] > temp; j -= gap) { 
    			}
    			arrays[j + gap] = temp;
    			
    			for(int k=0; k<arrays.length-1; k++){
    				result+=arrays[k]+"\t";   
    			}
    			result+=arrays[arrays.length-1]+"\n";
    		}

    	}
        return result;
        
    }
    
    
    public static void main(String[] args) {
        
        int[] a={12,11,4,3,1};
        
        System.out.println(Shellsort.sort(a));

    }
}