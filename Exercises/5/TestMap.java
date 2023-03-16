import java.util.*;

public class TestMap{
	public static void main(String[] args){
		Map<String,Integer> testMap = new HashMap<>();

		testMap.put("Kathy", 30);
		testMap.put("Bert", 145);
		testMap.put("Brandon", 153);

		System.out.println(testMap);
		System.out.println(testMap.get("Bert"));
	}
}