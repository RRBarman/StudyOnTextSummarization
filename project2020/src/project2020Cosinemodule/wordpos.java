package project2020Cosinemodule;
import java.util.HashMap;
import java.util.Map;
public class wordpos {
	public static Map<String, Integer> pos = new HashMap<String, Integer>();
    Map<String,Integer> wordPos(String w[])
    {//static Map<String, Integer> pos = new HashMap<String, Integer>();
      // static Map<String, Integer> pos = new HashMap<String, Integer>();
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
    }
}
