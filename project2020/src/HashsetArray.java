import java.util.Map;
import java.util.Set;

public class HashsetArray {
    String[][] hashsetarray(int senlen,Map<String,Double> hm){
        String mat[][]=new String[senlen+1][hm.size()+1];
        mat[0][0]="sent/words";
        int c1=1;
        Set<String> keys = hm.keySet();
        for(String key: keys)
        {
            mat[0][c1]=key;
            System.out.println(" "+mat[0][c1]);
            c1++;
        }
        return mat;
    }
}
