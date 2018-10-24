package GraphtTestCode;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runners.MethodSorters;
@FixMethodOrder(MethodSorters.JVM)
public class KruskalTest1 {
	@Rule
	 public TemporaryFolder tempFolder = new TemporaryFolder();
	
	 @Test
	    public void testRead() throws IOException{
		    Kruskal kru = new Kruskal(0);
	    	File tempFile = tempFolder.newFile("tempFile.txt");
	    	BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
	    	bw.write("my test");
	    	bw.close();
	    	String expected = "my test\n";
	        String result = kru.readFile(tempFile);
	      	assertEquals(expected, result);
	   } 
	 
	   @Test
	    public void testWrite() throws IOException{
		   Kruskal kru= new Kruskal(0);
	 	   File tempFile = tempFolder.newFile("tempFile.txt");
	 	   ArrayList<String> s= new ArrayList<String>();
	 	   s.add("A"); s.add("B");s.add("C");
	 	   kru.writeFile(tempFile, s);
	 	   BufferedReader br = new BufferedReader(new FileReader(tempFile));
	 	   String s1;
	 	   boolean a=false;
	 	   while((s1=br.readLine())!=null){
	 		  if(s1.contains("A"))
	 	          a=true;
	 	   }
	 	  assertEquals(true,a);
	 	  tempFile.delete();
	    }
	   
	  @Test
	  public void testFindShortPath() throws IOException {
            Kruskal kru= new Kruskal(9);
		    File testFileName=new File("./Graph/graphKruskal.txt");
		    File OutFileName=new File("./Graph/kruskalout.txt");
			String result=kru.readFile(testFileName);
		    ArrayList<String> s_edge= kru.findKruskal(result);
		    kru.writeFile(OutFileName, s_edge);  
	  }
	  
	  @Test
		 public void assertReaders() throws IOException {
			BufferedReader expected= new 
					BufferedReader(new FileReader("./Graph/expectedkruskalout.txt"));
			BufferedReader actual = new 
					BufferedReader(new FileReader("./Graph/kruskalout.txt"));
		    String line;
		    while ((line = expected.readLine()) != null) {
		      assertEquals(line, actual.readLine());
		    }

		    assertNull("Actual had more lines then the expected.", actual.readLine());
		    assertNull("Expected had more lines then the actual.", expected.readLine());
		}
	}

