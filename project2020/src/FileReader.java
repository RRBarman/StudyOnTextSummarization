import java.io.*;
//import java.util.ArrayList;
//import java.lang.*;
public class FileReader {
    String readfile()throws Exception{
        File file = new File("F:\\Passage1\\Paragraphtext2.txt");
      //  @SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        String st="",s="";
        while ((st = br.readLine()) != null)
            s=s+st;
        br.close();
       /* ArrayList<String> ng = new ArrayList<String>();
		 Ngramcalculation ng1 = new Ngramcalculation();
		// for(int i=0;i<senlen;i++)
		 ng.addAll(ng1.generateNgrams(senlen, s));
		 System.out.println("Ngram calculation : "+"\n"+ng);**/
        return s;
        
    }
}