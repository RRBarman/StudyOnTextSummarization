import java.util.ArrayList;

//import java.util.List;

/**
 * 
 */

/**
 * @author RAUNAK
 *
 */
//import java.util.*;
public class Ngramcalculation {

	/**
	 * 
	 */
	
		public  ArrayList<String> generateNgrams(int N, String sen)
		{
		 String[] tokens = sen.split("\\s+'");//splitting the sentence into tokens
		 ArrayList<String> ngramList= new ArrayList<String>();
		 String s="";
		 //N-grams generation
		 for(int k=0;k<(tokens.length-N+1);k++)
		 {
			// String s="";
			 int start = k;
			 int end = k+N;
			 for(int j=start;j<end;j++)
			 {
				 s=s+""+tokens[j];
			 }
			 //Adding N-gram to list
			 ngramList.add(s);
		 }
		// return ngramList;
		 
		 return ngramList;
		}
	}