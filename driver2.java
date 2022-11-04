import java.util.HashMap;
import java.util.Random;

public class driver2 {

	static final int numKeys = 80;
	
	
	public static void main(String[] args) {
		
		MyHashMap<Integer, String> hMap1 = new MyHashMap<>();
		HashMap<Integer, String> realHMap = new HashMap<>();
		
		Random ran = new Random();
		
		
		int rand1;
		int rand2;
		boolean youFuckedUp = false;
		
		
		for(int i = 0; i < 10000; i++) {
			System.out.println(checkEqual(hMap1, realHMap));
			String str1;
			String str2;
			rand1 = ran.nextInt(4);
			rand2 = ran.nextInt(numKeys);
			if(rand1 == 0 || rand1 == 3) {
				// add
				hMap1.put(rand2, "node " + i);
				realHMap.put(rand2, "node " + i);				
			}
			else if(rand1 == 1){
				// remove
				str1 = hMap1.remove(rand2);
				str2 = realHMap.remove(rand2);
				if((str1 == null) && (str2 != null) || (str1 != null) && (str2 == null)) {
					youFuckedUp = true;
				}
				else if((str1 == null) && (str2 == null))
				{
					continue;
				}
				else {
					if(!(str1.equals(str2))) {
						youFuckedUp = true;
					}
				}				
			}
			else if(rand1 == 2) {
				// get
				str1 = hMap1.get(rand2);
				str2 = realHMap.get(rand2);
				if((str1 == null) && (str2 != null) || (str1 != null) && (str2 == null)) {
					youFuckedUp = true;
				}
				else if((str1 == null) && (str2 == null))
				{
					continue;
				}
				else {
					if(!(str1.equals(str2))) {
						youFuckedUp = true;
					}
				}		
			}
			
			
			
		}
		System.out.println(hMap1.keySet());
		System.out.println(realHMap.keySet());
		System.out.println(youFuckedUp);
		System.out.println(hMap1.size());
		System.out.println(realHMap.size());
		hMap1.printTable();
		hMap1.clear();
		realHMap.clear();
		System.out.println(checkEqual(hMap1, realHMap));
		hMap1.printTable();
		System.out.println(hMap1.keySet());
	}
	public static <K ,V> boolean checkEqual(MyHashMap<K,V> testMap, HashMap<K,V> realMap) {
		
		if(!(testMap.isEmpty() == realMap.isEmpty())) {
			System.out.println("empty error");
			return false;
			//checks empty function
		}
		
		if(!testMap.keySet().equals(realMap.keySet())) {
			System.out.println("keyset error");
			return false;
			//checks to see if all the keys are the same
		}
		Integer iClass;
		for(int i = 0; i < 80; i ++) {
			iClass = i;
			if(!(testMap.containsKey((K) iClass) == realMap.containsKey((K) iClass))){
				System.out.println("contains error");
				return false;
				//checks all possible keys and sees if the key is in the map
			}
		}
		
		
		for(K key:testMap.keySet()) {
			if(!testMap.get(key).equals(realMap.get(key))) {
				System.out.println("get error");
				return false;
			}
			
		}
		if(testMap.size() != realMap.size()) {
			System.out.println("size error");
			return false;
		}
		


		
		
		
		return true;
		
	}
}
