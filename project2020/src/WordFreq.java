import java.util.HashMap;
import java.util.Map;
public class WordFreq {
    Map<String, Double> wordfreq(String w[]){
        Map<String, Double> hm = new HashMap<String, Double>();
        
        for (int k=0; k<w.length ; k++)
        {
            if(hm.containsKey(w[k]))
            {
                double cont = hm.get(w[k]);
                hm.put(w[k], cont + 1.0);
            }
            else
            {
                hm.put(w[k], 1.0);
            }
        }
        System.out.println("word frequency"+hm);
        return hm;
    }
}
