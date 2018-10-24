package GraphtTestCode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class DijkstraTest1 {
	@Rule
	   public TemporaryFolder tempFolder = new TemporaryFolder();
   
	 @Test
	    public void testRead() throws IOException{
	    	File tempFile = tempFolder.newFile("tempFile.txt");
	    	BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
	    	bw.write("my test");
	    	bw.close();
	    	String expected = "my test\n";
	        Dijkstra dij= new Dijkstra();
	        String result = dij.readFile(tempFile);
	        assertEquals(expected, result);
	    }
	    
	    @Test
	  	public void testFindShortPath() throws IOException {
	    	Dijkstra dij= new Dijkstra();
	    	Dijkstra dij1= new Dijkstra();
	  	    File testFileName=new File("./Graph/graphDijkstra.txt");
	  	    File OutFileName=new File("./Graph/dijkstraout.txt");
	  	    String result=dij.readFile(testFileName);
	  	    String[] path=dij.findShortPath(result);
	  	    dij.writeFile(OutFileName, path); 
	  	  
	  	   //to check for different codes
	 	   String result1 = dij1.readFile(testFileName);
	 	   String[]path1 = dij1.findShortPath(result1);
	 	   //System.out.println(Arrays.toString(path1));
	 	   //dij.writeFile(OutFileName, path1);
	    } 
	   
	    @Test
		 public void assertReaders() throws IOException {
			BufferedReader expected= new 
					BufferedReader(new FileReader("./Graph/expecteddijkstraout.txt"));
			BufferedReader actual = new 
					BufferedReader(new FileReader("./Graph/dijkstraout.txt"));
		    String line;
		    while ((line = expected.readLine()) != null) {
		      assertEquals(line, actual.readLine());
		    }
		    assertNull("Actual had more lines than the expected.", actual.readLine());
		    assertNull("Expected had more lines than the actual.", expected.readLine());
		 }
	    
	    @Test
	    public void testWrite() throws IOException{
	 	   File tempFile = tempFolder.newFile("tempFile.txt");
	 	   String[] s= new String[]{"a","b","c"};
	 	   Dijkstra dij= new Dijkstra();
	 	   dij.writeFile(tempFile, s);
	 	   BufferedReader br = new BufferedReader(new FileReader(tempFile));
	 	   String s1;
	 	   boolean a=false;
	 	   while((s1=br.readLine())!=null ){
	 		    if(s1.contains("a"))
	 		    	a=true;
	 	  }
	 	  assertEquals(true,a);
	 	  tempFile.delete();
	    } 

}
