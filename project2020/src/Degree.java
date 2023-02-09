import java.util.Collections;
import java.util.Map;
public class Degree {
	public Degree(Map<Integer, Double> degmap) {
		Map.Entry<Integer, Double> firstentry = degmap.entrySet().iterator().next();
		Double maximumvalue = firstentry.getValue();
		Double minimumvalue = Collections.min(degmap.values());
				for(Map.Entry<Integer, Double> map1 : degmap.entrySet())
				{
					Double value1 = map1.getValue();
					if(value1>=maximumvalue)
						maximumvalue = map1.getValue();
					//else
						//minimumvalue = value1;
				}
				System.out.println("\n\t maximum degree : "+maximumvalue);
				System.out.println("\t minimum degree : "+minimumvalue);				
	}
}