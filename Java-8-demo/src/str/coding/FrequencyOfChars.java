package str.coding;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfChars {

	public static void main(String[] args) {

		String str = "Hello dude what do you want";

		Map<String, Long> val = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(
						Function.identity(), 
						Collectors.counting()
						)
						);
		
		System.out.println(val);
		
		System.out.println(Arrays.stream(str.split("")).count());
		System.out.println(Arrays.stream(str.split("")).distinct().collect(Collectors.toList()));
		System.out.println(Arrays.stream(str.split("")).filter(a->a.equals("d")).collect(Collectors.toList()));
		System.out.println(Arrays.stream(str.split("")).limit(10).collect(Collectors.toList()));
		System.out.println(Arrays.stream(str.split("")).filter(a->a.equals("d")).map(a->a.toUpperCase()).collect(Collectors.toList()));
		System.out.println(Arrays.stream(str.split("")).sorted().collect(Collectors.toList()));
		

	}

}
