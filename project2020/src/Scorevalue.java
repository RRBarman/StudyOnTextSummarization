import java.util.HashMap;
import java.util.Map;

public class Scorevalue {

	public Scorevalue(Map<Integer,Double> Degmap , Double maximumvalue,Double minimumvalue) {
		// TODO Auto-generated constructor stub
		Double score=0.0;
		Map<Integer,Double> scoremap = new HashMap<>();
		for(int i=0;i<Degmap.size();i++)
		{
			//for(Map.Entry<Integer, Double> scoremap : Degmap.entrySet())
		//{
			score = Degmap.get(i)/(maximumvalue-minimumvalue);//score computation
			
		//}
		
		System.out.println("\n Score of s"+i+" is : "+score);   				
		scoremap.put(i, score);
		
}
		System.out.println("\n Scoremap---->\n\n "+scoremap);
		System.out.println();
		

	}

}
