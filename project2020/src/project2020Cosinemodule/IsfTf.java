package project2020Cosinemodule;
import java.util.Map;
import java.util.Set;

public class IsfTf {
    String[][] isftftab(int senlen,Map<String,Double> hm,double isf[],String mat[][]){
        String isftf[][]=new String[senlen+1][hm.size()+1];
        Set<String> kys = hm.keySet();
        int c1=1;
        for(String key: kys)
        {
            isftf[0][c1]=/*Double.parseDouble*/key;
            c1++;
        }
        isftf[0][0]="st/wd\t";
        for(int k=1;k<senlen+1;k++)
        {
            for(int n=1;n<hm.size()+1;n++)
            {
               // isftf[k][n]=((Math.floor((isf[n-1])*((mat[k][n]))*100)/100));
            	 isftf[k][n]=Double.toString((Math.floor((isf[n-1])*(Double.parseDouble(mat[k][n]))*100)/100d));
            }
        }
        return isftf;
    }
    void printisftf(int senlen, Map<String,Double> hm,String isftf[][]){
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
        }
    }

	/*void tfisf(int senlen,Map<String,Integer>hm ,String mat[][])
	{
		for(int i=0;i<senlen+1;i++)
		{
			for(int j=0;j<hm.size()+1;j++)
			{
				double tfisf=wf.
			}
		}
	}*/
  /* void cosineSimilarity(int senlen,)
    double[][] cossim=new double[senlen][senlen];
    CosineSimilarity c1= new CosineSimilarity();
   for(int i=0;i<senlen;i++)
   {
   	 for(int j=0;j<senlen;j++)
   	 {
   		cossim[i][j]= c1.cosineSimilarity(matr[i],matr[j]);
   	 }
   }*/
}