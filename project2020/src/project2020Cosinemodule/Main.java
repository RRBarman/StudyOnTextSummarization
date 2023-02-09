package project2020Cosinemodule;
//import java.lang.*;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	static double cnt;
	public static Map<String,Double> Sentencecount = new HashMap<>();  
	public static  Map<String,Double> Sentfreqn = new HashMap<>();  
	public static Map<String,Double> tfisf = new HashMap<>();  
	 public static List<String> SentList = new ArrayList<String>();
	 public static List<String> SentListmodified = new ArrayList<String>();
    public static void main(String[] args) throws Exception {
        FileReader fp = new FileReader();
        String s = fp.readfile();
        System.out.println(s);
        Split sp = new Split();
        String sen[] = sp.SenSplit(s);
        int senlen = sen.length;
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
        System.out.println(wordlen);
        WordFreq wfq = new WordFreq();
        Map<String, Double> hm =   wfq.wordfreq(word);
        Set<String> keys = hm.keySet();
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(senlen);
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
        System.out.println("sentence frequency"+Sentfreqn);
        for (Entry<String, Double> entry : Sentfreqn.entrySet()) {
		  //  System.out.println("key="+entry.getKey() + " value = " + entry.getValue());
		    Sentfreqn.put(entry.getKey(), Math.log(SentListmodified.size()/entry.getValue()));
		    double k=(Sentfreqn.get(entry.getKey()));
		    double m=		(hm.get(entry.getKey()));
		    System.out.println("k = "+k+" freqn= "+hm.get(entry.getKey()));
		    
		    tfisf.put(entry.getKey(),k*m);
		    
        }
        System.out.println("tfisf-->"+tfisf);
        System.out.println("sentence frequency"+Sentfreqn);
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
        for(int i=0;i<SentListmodified.size();i++)
        {
        	 docmat[i][i]=0.0;
        	//System.out.println(" "+wordpos.pos);
        	for(String wrd: SentListmodified.get(i).split("\\s+"))
        	{
        		System.out.println("Sentencemodifiedsize = "+SentListmodified.get(i));
        		
        		//System.out.println(""+wrd);
        		//System.out.println(""+wordpos.pos.size());
        		System.out.println(" "+wrd);
            	System.out.println(" "+wordpos.pos.get(wrd));
        		System.out.println(" "+tfisf.get(wrd));
        		docmat[i][wordpos.pos.get(wrd)] = tfisf.get(wrd);
        	
        	
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
        System.out.println("\t\t\t Sentence/word---> tfisf value table:  \t\t\n");
        int s1=1;
        for(int k=0;k<docmat.length;k++)
        {
            for(int n=0;n<docmat[k].length;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t\t");
                    s1++;
                }
                else
                    System.out.print(docmat[k][n]+"\t");
            }
            System.out.println();
        }
     //   System.out.println(" "+docmat);
        
    //  CosineSemanticSimilarity cs = new CosineSemanticSimilarity();
      //  int x = hm.size();
        Map<Integer,Double> Degmap= new HashMap<>();
     //   double ddegm[] =new double [Degmap.size()];
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
                System.out.print(cosintab[b][j]+"	");
            }
            System.out.println();
        }
        System.out.println("\n\n Degree of each sentence :---> ");
        for(int i=0;i<senlen;i++)
        {
        	for(int c=0;c<senlen;c++)
        	{
        if(cosintab[i][c]>0.5)
        { degcount++;
        	//System.out.println("the degree of s["+i+"]"+" & s["+c+"] = "+ degcount);
        	}
        
        
     //  Degmap.put(cosintab.toString(i), degcount);
        	}
        	
        	System.out.println("\n the degree of s["+i+"]"+" = "+ degcount);
        
        	Degmap.put( i, degcount);
        	
        	/*for(int h = 0;h<senlen;h++)
               ddegm[h] = (degcount);*/
        	
        	degcount = 0;
        	
        }
        System.out.println(" \n Degree map :-->");
        System.out.println(" "+Degmap);
        
        
       
         
        
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
    }
    	//double max = Degmap.Collections.max();
    	// List< 
    
}

