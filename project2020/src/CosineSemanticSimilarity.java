//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.computergodzilla.tfidf;

/**
 * Cosine similarity calculator class
 * @author  Raunak Roy Barman
 */
//import java.util.HashMap;
public class CosineSemanticSimilarity {

    /**
     * Method to calculate cosine similarity between two documents.
     * @param docVector1 : document vector 1 (a)
     * @param docVector2 : document vector 2 (b)
     * @return
     */
   /* public double cosineSimilarity(double[] docVector1, double[] docVector2) {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double cosineSimilarity = 0.0;
     System.out.println("\n docVector1");
        for (int i = 0; i < docVector1.length; i++)
        System.out.printf("\t"+docVector1[i]+" ");
    	System.out.println("\n");
    	System.out.println("\n docVector2");
    	for (int i = 0; i < docVector1.length; i++)
    	System.out.printf("\t"+docVector2[i]+" ");
        System.out.println("\n docVector1");
        System.out.println("\n docVector1=len"+docVector1.length);
        System.out.println("\n docVector2");
        System.out.println("\n docVector1=len"+docVector2.length);
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {

            dotProduct += docVector1[i] * docVector2[i];  //a.b
            docVector1[i]=docVector1[i]*docVector1[i];
            docVector2[i]=docVector2[i]*docVector2[i];
            magnitude1 += docVector1[i];  //(a^2)
            magnitude2 += docVector2[i]; //(b^2) 


        }*/

        //magnitude1 = Math.sqrt(magnitude1);//sqrt(a^2)
        //magnitude2 = Math.sqrt(magnitude2);//sqrt(b^2)
       // for (int i = 0; i < docVector1.length; i++)
        	//docVector1[i]=0.0;
        /*docVector1=null;
        docVector2=null;
        if (magnitude1 != 0.0 && magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }*/

    public double cosineSimilarity1(double[] docVector1, double[] multD_w)
    {
        double dotProduct = 0.0;
        double magnitude1 = 0.0;
        double magnitude2 = 0.0;
        double mg1=0.0;
        double mg2=0.0;
        double cosineSimilarity = 0.0 ;
        for (int i = 0; i < docVector1.length; i++) //docVector1 and docVector2 must be of same length
        {

            dotProduct += (docVector1[i] * multD_w[i]);  //a.b
            // docVector1[i]=docVector1[i]*docVector1[i];
            //  docVector2[i]=docVector2[i]*docVector2[i];
            magnitude1 += Math.pow(docVector1[i], 2);  //(a^2)
            magnitude2 += Math.pow(multD_w[i], 2); //(b^2)


        }

        mg1 = Math.sqrt(magnitude1);//sqrt(a^2)
        mg2 = Math.sqrt(magnitude2);//sqrt(b^2)

        if (magnitude1 != 0.0 && magnitude2 != 0.0) {
            cosineSimilarity = dotProduct / (mg1 * mg2);
        } else {
            return 0.0;
        }
        return cosineSimilarity;
    }
    
    /*  System.out.println("\n docVector1");
    for (int i = 0; i < docVector1.length; i++)
    System.out.printf("\t"+docVector1[i]+" ");
	System.out.println("\n");
	System.out.println("\n docVector2");
	for (int i = 0; i < docVector1.length; i++)
	System.out.printf("\t"+docVector2[i]+" ");
    System.out.println("\n docVector1");
    System.out.println("\n docVector1=len"+docVector1.length);
    System.out.println("\n docVector2");
    System.out.println("\n docVector2=len"+docVector2.length);*/
  /*  void degreefinding()
    {
    	
    }*/
  /* void degree()
    {
    	Map<String,Double>deg = new HashMap<>();
    	
    }*/
    
 /*  public class Searcher
    {
    	public String title;
    	public double score;
    	public Searcher(String title,double score)
    	{
    		this.title = title;
    		this.score = score;
    	}
    };
    private List<String> terms;
    final Map<String,Double>SimilarityMap = new HashMap<>();
    private List<Searcher> Scorevalue(final Map<String,Double>SimilarityMap)
    {
    	List<Searcher> results = 
    }*/
}
