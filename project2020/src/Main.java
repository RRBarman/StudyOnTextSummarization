/**
 * Main class
 * @author  Raunak Roy Barman
 */
//import java.lang.*;
//import java.io.Reader;
//import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Collections;
//import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;
*/

public class Main {
	static double cnt;
	public static Map<String,Double> Sentencecount = new HashMap<>();  
	public static  Map<String,Double> Sentfreqn = new HashMap<>();  
	public static Map<String,Double> tfisf = new HashMap<>();  
	 public static List<String> SentList = new ArrayList<String>();
	 public static List<String> SentListmodified = new ArrayList<String>();
	 public static Map<String,Integer> Sent_Print = new HashMap<>(); 
	 public static Map<String,Double> SentenceRank2 = new HashMap<>();
    public static void main(String[] args) throws Exception {
        FileReader fp = new FileReader();
        String s = fp.readfile();
        System.out.println(s);
        
        Split sp = new Split();
        String sen[] = sp.SenSplit(s);
        //System.out.println(sen);
        int senlen = sen.length;
      //  ArrayList<String> ng = new ArrayList<String>();
		 //Ngramcalculation ng1 = new Ngramcalculation();
		 //for(int i=0;i<senlen;i++)
		// ng.addAll(ng1.generateNgrams(senlen, s));
		 
		/*	 ng.addAll(ng1.generateNgrams(senlen, s));
			 System.out.println("Ngram calculation : ");
			 //for(int i=0;i<senlen;i++)
		 System.out.println("\n"+ng);*/
      
        Stopword stp1 = new Stopword();
        Stemmer stemmer = new Stemmer();
        
        for(String m : sen)
        	
        {
            System.out.println(m);
            SentList.add(m);
            SentListmodified.add(stemmer.foo(stp1.remove(m.toLowerCase())));
        }
        
        
                String word1[] = sp.WordSplit(s);
        //Stopword stp1 = new Stopword();
        String str = stp1.stp(word1);
        System.out.println(str);
     //   Stemmer stemmer = new Stemmer();
        str = stemmer.foo(str);
        String word[] =sp.WordSplit(str.toLowerCase());
       int wordlen = word.length;
        for(String m : word)
            System.out.println(m);
        System.out.println("Number of words : \n"+wordlen);
        WordFreq wfq = new WordFreq();
        Map<String, Double> hm =   wfq.wordfreq(word);
        Set<String> keys = hm.keySet();
        System.out.println(hm);
        System.out.println("\nSize of wordfrequency map : "+hm.size());
        System.out.println("\nTotal number of sentences : "+senlen);
        for(String uniqword:keys)
        {
       // System.out.println("keys="+uniqword);
        for(int i=0;i<SentListmodified.size();i++)
        {
        	String st=SentListmodified.get(i).toString().toLowerCase();
        	//System.out.println(st);
        	if(st.contains(uniqword))
        	{
        		Sentfreqn.put(uniqword,++cnt);
        	}
        }
        cnt=0;
        }
        System.out.println("sentence frequency map : \n\t"+Sentfreqn);
       // double [] datatfsisf =new  double[Sentfreqn.size()];
        for (Entry<String, Double> entry : Sentfreqn.entrySet()) {
		  //  System.out.println("key="+entry.getKey() + " value = " + entry.getValue());
		    Sentfreqn.put(entry.getKey(), Math.log(SentListmodified.size()/entry.getValue()));// isf values are been put into Sentfreqn map.
		    double k=(Sentfreqn.get(entry.getKey()));
		    double m=		(hm.get(entry.getKey()));
		    System.out.println("\n word = "+(entry.getKey()));
		    System.out.println("isf value  = "+k+" tf value= "+hm.get(entry.getKey()));
		    
		    tfisf.put(entry.getKey(),k*m);
		 //  for(int l=0;l<tfisf.size();l++)
		   // datatfsisf[l] = k*m;
        }
        //System.out.println(" "+datatfsisf);
        System.out.println("\n tfisf map -->"+tfisf);
        System.out.println("\n inverse sentence frequency map : "+Sentfreqn);
      //  Double Sfeq[] = new Double [Sentfreqn.size()];
      
        HashsetArray ha = new HashsetArray();
        String mat[][]=ha.hashsetarray(senlen,hm);
        WordFreqMat wfqm = new WordFreqMat();
        String matr [][]=wfqm.wordfreqmat(hm,senlen,sen,mat);
        wfqm.printwordfreqmat(senlen,matr,hm);
        int wf[] = wfqm.wordfreqmatwf(sen,senlen,mat,hm);
        WordFreqTab wft = new WordFreqTab();
        wft.wordfreqtab(wf);
       // for(int i=0; i<Sentfreqn.size();i++) 
     /*   {
        	 Sfeq[i] = Sentfreqn.get(i);
        	 System.out.println(""+Sfeq[i]);
        }*/
       // IsfTab isft = new IsfTab();
       // Collection<Double> sentcount= Sentfreqn.values();
       // Set<String> keys1 = hm.keySet();
      //  Map<String,Double> sentlist = new HashMap<>();
        
      /* for(int i=0;i<tfisf.size();i++)
       {
    	   
       
        Double ISFTF[][] = tfisf.put(, i);
       }*/
        //double isf[] = isft.isftab(Sfeq,senlen);
       // isft.printisftab(isf);
       // double  isftf[][]=new double[senlen+1][hm.size()+1];
        //Map<String, Integer> pos = new HashMap<String, Integer>();
     /*   Map<String,Integer> wordPos(String w[])
        {
            Map<String, Integer> pos = new HashMap<String, Integer>();
            int i=0;
            for (int k=0; k<w.length ; k++)
            {
            	
                if(pos.containsKey(w[k]))
                {
                	continue;
                }
                else
                {
                    pos.put(w[k],i++);
                }
            }
            return pos;
        }*/
        
       // Set<String> kys = tfisf.keySet();
       // Set<String> kys = hm.keySet();
        /*int c1=1;
        for(String key: kys)*/
      /*  {
       *  isftf[0][c1]=Double.parseDoublekey;*/
          //  c1++;
        //}
        /*isftf[0][0]="st/wd\t";
      for(Entry<String, Double> entry : Sentfreqn.entrySet())
      {
        for(int i=1;i<senlen+1;i++)
        {
            for(int n=1;n<tfisf.size()+1;n++)
            {
               // isftf[k][n]=((Math.floor((isf[n-1])*((mat[k][n]))*100)/100));
            	 double k=(Sentfreqn.get(entry.getKey()));
     		    double m=		(hm.get(entry.getKey()));
            	 isftf[i][n]=Double.toString(tfisf.getOrDefault(kys,k*m));
            }
        }
        
        System.out.println(" "+isftf);
        int s1=1;
        for(int k=0;k<senlen+1;k++)
        {
            for(int n=0;n<hm.size()+1;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t\t");
                    s1++;
                }
                else
                    System.out.print(isftf[k][n]+"\t");
            }
            System.out.println();
        }*/
       /* IsfTf ist = new IsfTf();
        String isftf[][] = ist.isftftab(senlen,hm,ISFTF,matr);*/
        //ist.printisftf(senlen,hm,isftf);
       wordpos wps = new wordpos();
       wps.wordPos(word);
        double docmat[][]= new double[SentListmodified.size()][wordpos.pos.size()];
        
        System.out.println("wordpositions in SentListmodified : "+wordpos.pos);
        for(int i=0;i<SentListmodified.size();i++)
        {
        	 docmat[i][i]=0.0;
        	
        	 
        	for(String wrd: SentListmodified.get(i).split("\\s+"))
        	{
        		System.out.println("\n Sentencemodifiedsize = "+SentListmodified.get(i));
        		
        		//System.out.println(""+wrd);
        		//System.out.println(""+wordpos.pos.size());
        		System.out.println(" word : "+wrd);
            	System.out.println(" word pos : "+wordpos.pos.get(wrd));
        		System.out.println(" tfisf of the word "+wrd+" :"+tfisf.get(wrd));
        		docmat[i][wordpos.pos.get(wrd)] = tfisf.get(wrd);
        		System.out.println();
        	}
        	
        }
       // docmat[0][0]=Double.parseDouble("sent/freq");
      /*  Set<String> kyes = hm.keySet();
        int c1=1;
        for(String key: kyes)
        {
            isftf[0][c1]=Double.parseDouble(key);
            c1++;
        }
        docmat[0][0]="st/wd\t";*/
        System.out.println("\t\t\t Sentence/sentence---> tfisf value table:  \t\t\n");
        int s1=0;
        for(int k=0;k<docmat.length;k++)
        {
        	
            for(int n=0;n<docmat[k].length;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t\t");
                   s1++; 
                }
            /*    else if(n!=0 && k!=0)
                {
                	System.out.print("sent"+s1+"\t\t");
                	s1++;
                }*/
                
                else
                    System.out.print(docmat[k][n]+"\t");
               
            }
            
           
            System.out.println();
        }
        s1=0;
     //   System.out.println(" "+docmat);
        
    //  CosineSemanticSimilarity cs = new CosineSemanticSimilarity();
      //  int x = hm.size();
        Map<Integer,Double> Degmap= new HashMap<>();
     //  double ddegm[] =new double [Degmap.size()];
        double degcount=0.0;
        System.out.println("\n\t\t\t Cosine similarity table :\t\t\n");
        double[][] cosintab = new double[senlen][senlen];
       // double[] nums1 = new double[x];
       // double[] nums2 = new double[x];
        for(int a=0;a<senlen;a++){
            for(int j=0;j<senlen;j++){
                cosintab[a][j]= new CosineSemanticSimilarity().cosineSimilarity1(docmat[a],docmat[j]);
            }
        }
        System.out.println();
        for(int b=0;b<senlen;b++){
            for(int j=0;j<senlen;j++){
            	/*if(b==0 && j!=0)
            	{
            		System.out.println("sent"+s1+" ");
        
            		s1++;
            	}*/
            	//else
                System.out.print(cosintab[b][j]+"	");
            }
            System.out.println();
        }
        System.out.println("\n\n Degree of each sentence :---> ");
        System.out.println();
      
        for(int i=0;i<senlen;i++)
        {
        	for(int c=0;c<senlen;c++)
        	{
        if(cosintab[i][c]>0.5)
        { degcount++;
        	//System.out.println("the degree of s["+i+"]"+" & s["+c+"] = "+ degcount);
        	}
        
        
     // Degmap.put(cosintab.toString(i), degcount);
        	}
        	
        	System.out.println(" the degree of s["+i+"]"+" = "+ degcount);
        	
        	System.out.println();
        	Degmap.put( i, degcount);
        	
        	/*for(int h = 0;h<senlen;h++)
               ddegm[h] = (degcount);*/
        	
        	degcount = 0;
        	
        }
        System.out.println(" \n Degree map :-->");
        System.out.println(" \t"+Degmap);
    
       // public double std_dev(double m)
    	//{
    		double sum=0.0;
    		double mean=0.0;
    		List<Double> temp = new ArrayList<Double>();
    	   // double [] temp= new double[wordtfidf.size()];
    		
    		 for(String sn: keys )
    		 {
    			 if(tfisf.containsKey(sn)&& sn!=null)
    				{
    					temp.add(Math.pow((tfisf.get(sn)-mean),2));  
    					
    			           
    				}
    		 }
    		 for(int i=0;i<temp.size();i++)
    		 {
    			sum+=temp.get(i); 
    		 }
    		 mean=sum/temp.size();
    		 double deviation=Math.sqrt(mean);  
    	      System.out.println("\t Deviation : "+ deviation);  
    	    //  System.out.println("/t temp : "+temp.size());
    		System.out.println("\t Mean : "+mean); 
    		double mean1=mean/2;
    		double centroid = (deviation+mean1)/2;
    		System.out.println("\t Centroid is :"+centroid);
    	//	Map<Integer,Double> cc = new HashMap<>();
    		
    		//System.out.println(tfisf);
    		
    //	Double [] csw = new Double[tfisf.size()] ;
    	
    	//for(int h = 0;h< tfisf.size();h++)
    		/*csw[h] = tfisf.values().toArray();
    			
    			
    				for(int i =0; i<tfisf.size();i++)
    				cc.put(i,csw[i]);
    				System.out.println(cc);*/
    		/*	for(int y=0;y<tfisf.size();y++)
    			{
    				if(tfisf.get())
    				cc.put(arg0, arg1)
    			}*/
    		Degree dg = new Degree(Degmap);
    		System.out.println(dg);
    		Map.Entry<Integer, Double> firstentry = Degmap.entrySet().iterator().next();
    		Double maximumvalue = firstentry.getValue();
    		Double minimumvalue = Collections.min(Degmap.values());
    		
    				for(Map.Entry<Integer, Double> map1 : Degmap.entrySet())
    				{
    					Double value1 = map1.getValue();
    					if(value1>=maximumvalue)
    						maximumvalue = map1.getValue();
    					//else
    						//minimumvalue = value1;
    				}
    				//System.out.println("maximum degree : "+maximumvalue);
    				//System.out.println("minimum degree : "+minimumvalue);
    				//Double score=0.0;
    		//		Scorevalue sc = new Scorevalue(Degmap, score, score);
    			//	System.out.println(sc);
    		
    				  Scorevalue sc = new Scorevalue( Degmap,maximumvalue,minimumvalue);
    				  System.out.println(sc);
    		
    				double d=0.85; // degree constant factor
    			Double pr[] = new Double[Degmap.size()];
    				 for(int i=0;i<Degmap.size();i++)
    					 
    				//for(String wrd: SentListmodified.get(i).split("\\s+"))
    				{
    					 //System.out.println("Degmap :"+Degmap);
    					// System.out.println(Degmap.get(i));
    					pr[i]=(((1-d)/Degmap.size())+d*((Degmap.get(i)*Degmap.get(i)))/Degmap.size());// Ranking computation
    				}
    				 
    				 /* Degree based ranking*/
    				 System.out.println("\n Ranking of the sentences :\n");
    				 for(int j=0;j<pr.length;j++)
    				 System.out.println("\n Rank of s["+j+"] : "+pr[j]);
    				 double prsum=0.0;
    				 
    				 for(int k = 0;k < pr.length;k++)
    				 {
    					 prsum+=pr[k];
    					
    				 }
    				 System.out.println("Sum of Ranking of Senetences  : "+prsum);
    				 double pravg=0.0;
    				 pravg = prsum/pr.length;
    				 System.out.println("Average of Ranking of Sentences : "+pravg);
    				 Map<Integer,Double> Rankmap = new HashMap<>();
    				 for(int i=0;i<pr.length;i++)
    				 {
    					 Rankmap.put(i, pr[i]);
    				 }
    				 System.out.println("Rank Map :    \n\t"+Rankmap);
    				 System.out.println("Rankwise important sentences according to degree of sentences to be taken in summary :");
    				//System.out.println(" ");
    				 //double prr[];
    				/* for(int g = 0 ; g<Rankmap.size();g++)
    				 {
    					 
    					 if(pr[g]>pr[g]) {
    					System.out.println(" "+SentListmodified.get(g+1));
    					 }
    					 else
    						 System.out.println(" "+SentListmodified.get(g));
    				 }*/
    				 for(int g =0 ; g<Rankmap.size();g++)
    				 {
    					 
    					 //for(int h=1;h<Rankmap.size();h++)
    					 //{ 
    						 if(pr[g]>=pravg)
    					   {
    						  System.out.println(" \t\t"+SentListmodified.get(g));
    						  
    						  
    					   }
    						 
    					 }
    				System.out.println("the list containing the sentences:"+ SentListmodified);
    				 
    				 /* Position based ranking*/
    				 for(int i =0;i<SentListmodified.size();i++)
    				 {
    					 String pos = SentListmodified.get(i).toString();
    					 Sent_Print.put(pos, i);
    					 Double position_factor  = 0.0;
    					 position_factor=(1+9*Math.log10(i+1)); //position based score calculation
    					 position_factor = 1/position_factor;
    					 SentenceRank2.put(SentListmodified.get(i).toString(),position_factor );
    				 }
    				 System.out.println("Position based summary : \n");
    				 for(Entry<String,Double>entry : SentenceRank2.entrySet())
    				 {
					  System.out.println("Position Based :->"+" "+"Sentence number :- "+Sent_Print.get(entry.getKey())+" "+entry.getKey()+" \t"+"Score :"+entry.getValue());	
					  
    				 }
    				 System.out.println("Size of the position based map:"+Sent_Print.size());
    				 System.out.println("Positionwise important sentences are : ");
    				 for(Entry<String,Double>entry : SentenceRank2.entrySet())
    				 {
    					
    					 if(Sent_Print.get(entry.getKey())<SentenceRank2.size()/2)
    					 {
    						 
    						 System.out.println(entry.getKey()+"\t\t sentence num:"+Sent_Print.get(entry.getKey()));
    					 }
    				 }
    				 
    				/*  System.out.println("Overall score :");
    				  System.out.println(" The overall score of sentences : ");
    				  for(int i=0;i < SentListmodified.size();i++)
    				  {
    					  
    				  }*/
    					//if()
    					 //ng =
    					 //double ng;
    					 //ng = 0;
    					 //System.out.println(ng);
    					 //else
    						// System.out.println(" \t "+SentListmodified.get(h));
    					 //else if(pr[g]==pr[h])
    					 		//System.out.println(" \t "+SentListmodified.get(h));
    					/* else
    					 {
    						 System.out.println(" \t "+SentListmodified.get(h));
    					 		//break;
    					 }*/
    				//}
    				 
    				
    				// System.out.println(Rankmap);
    		
    				 //System.out.println(s);
    			//	 Main m = new Main();
    				// m.Sentence_calcM(s);
    				 
    		}
   
}
   /* static String title="";
    public void Sentence_calcM(String line)
	{
		Stopword sp=new Stopword();
		//Special spl=new Special();
		//Stemmer st=new Stemmer();
		SentList.clear();
		SentList.clear();
		Reader reader = new StringReader(line);
		  DocumentPreprocessor dp1 = new DocumentPreprocessor(reader);
		  

		  for (List<HasWord> sentence : dp1) {
		     String sentenceString = Sentence.listToString(sentence);
		     SentList.add(sentenceString.toString());
		  }
	      int cnt1=0;
		  for (String sentence : SentList) {
			  SentList.add(sentence);
			  sentence=sp.remove(sentence);
			  StanfordLemmatizer sl=new StanfordLemmatizer();
			//	sentence=sp.remove(sl.lemmatize_string(sentence));// lemmatizing
				//System.out.println(cnt1+"-----New--- "+sentence);
			//sentence=st.stemString((sp.remove((sentence.toLowerCase()))));
			
			  //sentence=(spl.remove(sp.remove((sentence.toLowerCase()))));
			//  sentence=spl.remove(st.stemString(sp.remove(sentence.toLowerCase())));
				sentence=remove_symbol(sentence);
			  SentListmodified.add(sentence);
		     System.out.println(cnt1+"-----New--- "+sentence);
		     if(cnt1==0)
		    	 title=sentence;
		   
		     cnt1++;
		  }
 // System.out.println(cnt1+"-----New--- "+sentList_modified);

    
//}
    public String remove_symbol(String line)
	{
		  line=line.replace(" .''",".''");
		  line=line.replace("-LSB-","");
		  line=line.replace("-RSB-","");
		  line=line.replace("-LCB-","");
		  line=line.replace("-RCB-","");
		  line=line.replace("-LRB-","");
		  line=line.replace("-RRB-","");
		   line=line.replace(" .",".");
		   line=line.replace(" ,",",");
		   line=line.replace(" ?","?");
		   line=line.replace("-- ","");
		   line=line.replace(" ;",";");
		   line=line.replace("_ ","");
		   line=line.replace("`` ","");
		   line=line.replace(" 's","'s");
		   line=line.replace(" ''","''");
		   line=line.replace(" '","'");
		  // System.out.println("replaced---->"+line);
		return line;*/
	
//     }

    //	public double return_muwordtfidf()
    //{
    	// double mu=0.0;
    	// double avg=0.0;
    	/* for (String sentence : sentList_modified) {
    			for(String ----- Message truncated -----
        
       
         
        
        /*	double degmat[][] = new double[Degmap.size()][Degmap.size()];
        for(int n=0;n<Degmap.size();n++)
        {
        	for(int q=0;q<Degmap.size();q++)
        	{
        		
        		degmat[n][q] = Degmap.get(q);
        	}
        }
        System.out.println(" "+degmat);
        */
    	 //double centroid ;
    	 //for(int i=0;i<)
    
    	//double max = Degmap.Collections.max();
    	// List< 
    	
    

