package project2020Cosinemodule;
public class IsfTab {
    double[] isftab(Double[] Sfeq, int senlen){
        double isf[]=new double[Sfeq.length];
        for(int k=0;k<isf.length;k++)
            isf[k]=Math.floor(Math.log(((double)(senlen))/((double)Sfeq[k]))*100)/100d;
        return isf;
    }
    void printisftab(double isf[]){
        System.out.print("\nisfvalue \t");
        for(int k=0;k<isf.length;k++)
            System.out.print(isf[k]+"\t");
        System.out.println("\n");
    }
}
