package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2,3,5,4,2,9,56,33,45,60);
		
		//Predicate<Integer> p = a -> a>4;
		list.stream().filter(a -> a>4).sorted().forEach(Test::printElement);
		
		Test test = new Test();
		list.stream().filter(a -> a>4).sorted().forEach(test::nonstatucprintElement);
		
		List<User> users = Stream.of(
				new User("avinash", "123", Arrays.asList("abc@gmail.com", "bcd@yahoo.com")) ,
				new User("avinash1", "1231", Arrays.asList("abc1@gmail.com", "bcd1@yahoo.com"))
				).collect(Collectors.toList());
		
		List<String> phonenumbers = users.stream().map(User::getPhone).collect(Collectors.toList());
		phonenumbers.forEach(System.out::println);
		
		//we get list of list, so we can use flat map
		List<List<String>> emailid = users.stream().map(User::getEmail).collect(Collectors.toList());
		emailid.forEach(System.out::println);
		
		//flat map takes a function which takes a parameter and get email from it and converts it to stream
		List<String> lists = users.stream().flatMap(u->u.getEmail().stream()).collect(Collectors.toList());
		System.out.println(lists);

	}
	
	public static void printElement(int i) {
		System.out.println(i);
	}
	
	public void nonstatucprintElement(int i) {
		System.out.println(i);
	}

}
