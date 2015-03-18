import java.util.Comparator;
import java.util.HashMap;


public class ValueComparator implements Comparator<String> {
	
	HashMap<String, Integer> hashmap;
	
	public ValueComparator(HashMap<String, Integer> hashmap) {
		this.hashmap = hashmap;
	}

	public int compare(String f, String s) {
		if (hashmap.get(f) >= hashmap.get(s)) {
            return -1;
        } else {
            return 1;
        }
	}
	
}
