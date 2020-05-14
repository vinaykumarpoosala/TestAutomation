import java.util.HashMap;
import java.util.Iterator;

public class Count {

	public static void main(String[] args)
	{
		String s = "Deekshith";
		HashMap<Character , Integer> hm = new HashMap<Character, Integer>();
		for(int i =0 ;i<s.length();i++)
		{
			char k = s.charAt(i);
			if(hm.containsKey(k))
			{
				hm.put(k, hm.get(k)+1);
			}
			else
				hm.put(k,1);
		}
		Iterator<Character> itr = hm.keySet().iterator();
		while(itr.hasNext())
		{
			Character c = itr.next();
			int count ;
			if((count=hm.get(c))>1)
			{
				System.out.println(c+" "+count);
			}
		}
		System.out.println(hm);
	}

}
