package com.teleport.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PairCount {
	
	public static void main(String[] args) {
		
		List<String> test1 = new ArrayList<>();
		test1.add("1");
		test1.add("1.000");
		test1.add("1.0201");
		test1.add("12");
		test1.add("12.000");
		test1.add("1.0001");
		test1.add("13.6");
		test1.add("13.000");
		test1.add("4.0001");
		
		PairCount pc = new PairCount();
		System.out.println(pc.paircount(test1));
		
	}
	
	public int paircount(List<String> weights) {
		
		List<String> ls = weights.stream()
				.map((val) -> Double.parseDouble(val))
				.map((val)->String.format("%.3f %n", val))
				.collect(Collectors.toList());
		
		Map<String, Long> map = ls.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//System.out.println(map);
		
		int paircount = 0;
		for (String key : map.keySet()) {
			paircount += map.get(key)/2;
		}
		
		//System.out.println(paircount);
		
		return paircount;
	}
}


