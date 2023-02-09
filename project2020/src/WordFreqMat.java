import java.util.Map;


public class WordFreqMat {
    public String[][] wordfreqmat(Map<String, Double> hm,int senlen,String sen[],String mat[][]){
        int p=0;
        int wf[]=new int[hm.size()];
        for(int k=0;k<senlen;k++)
        {
            p++;
            String a[]=sen[k].split("[\\s+ -,]"); //hm,llen,l[k]
            for(int n=1;n<hm.size()+1;n++)
            {

                int ct=0;
                for(int m=0;m<a.length;m++)
                {
                    if(mat[0][n].equalsIgnoreCase(a[m]))
                        ct++;
                }
                mat[0+p][n]=Integer.toString(ct);
                //creating the array for the total number of times a word is present in every sentence.
                if(ct>0)
                    wf[n-1]++;
            }
        }
        return mat;
    }
    int[] wordfreqmatwf(String sen[],int senlen,String mat[][],Map<String,Double> hm){
        int p=0;
        int wf[]=new int[hm.size()];
        for(int k=0;k<senlen;k++)
        {
            p++;
            String a[]=sen[k].split("[\\s+ -,]"); //hm,llen,l[k]
            for(int n=1;n<hm.size()+1;n++)
            {

                int ct=0;
                for(int m=0;m<a.length;m++)
                {
                    if(mat[0][n].equalsIgnoreCase(a[m]))
                        ct++;
                }
                mat[0+p][n]=Integer.toString(ct);
                //creating the array for the total number of times a word is present in every sentence.
                if(ct>0)
                    wf[n-1]++;
            }
        }
        return wf;
    }

    void printwordfreqmat(int senlen,String matr[][],Map<String, Double> hm){
        int s1=1;
        for(int k=0;k<senlen+1;k++)
        {
            for(int n=0;n<hm.size()+1;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t");
                    s1++;
                }
                else
                    System.out.print(" "+matr[k][n]+"\t");
            }
           System.out.println("\t\t\t\t\t\t");
        }
   /*     double[][] cossim=new double[senlen][senlen];
         CosineSimilarity c1= new CosineSimilarity();
        for(int i=0;i<senlen;i++)
        {
        	 for(int j=0;j<senlen;j++)
        	 {
        		cossim[i][j]= c1.cosineSimilarity(matr[i],matr[j]);
        	 }
        }*/
    }

}