package functionalinterface;

import java.util.function.Function;

public class TestClass {

	public static void main(String[] args) {
		
		UPIPayment pay = (source, dest) -> source + dest;
		System.out.println(pay.doPayment("abc", "def"));
		
		Function<String, String> func = a -> a.toUpperCase();
		System.out.println(func.apply("abchdAS"));

	}

}
