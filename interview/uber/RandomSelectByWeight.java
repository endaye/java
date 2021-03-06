package interview.uber;
import java.util.*;
/*
 * Given you a tuple list [("hello", 2.34), ("world", 4.68)...]
 * Random select words by their weights.
 */
public class RandomSelectByWeight {
	class Tuple {
		String word;
		int weight;
		public Tuple(String word, int weight) {
			this.word = word;
			this.weight = weight;
		}
	}
	
	TreeMap<Integer, String> map;
	int maxValue;
	Random rand;
	
	public void init(Tuple[] tuples) {
		map = new TreeMap<Integer, String>();
		maxValue = 0;
		rand = new Random();
		for (Tuple t: tuples) {
			map.put(maxValue, t.word);
			maxValue += t.weight;
		}
	}
	
	public String nextRandomString() {
		int key = rand.nextInt(maxValue);
		if (!map.containsKey(key))
			key = map.lowerKey(key);
		return map.get(key);
	}
	
	public static void main(String[] args) {
		RandomSelectByWeight rs = new RandomSelectByWeight();
		Tuple[] ts = new Tuple[3];
		ts[0] = rs.new Tuple("One", 1);
		ts[1] = rs.new Tuple("Two", 2);
		ts[2] = rs.new Tuple("Three", 3);
		rs.init(ts);
		for (int i = 0; i < 12; i++) {
			System.out.println(rs.nextRandomString());
		}
	}

}
