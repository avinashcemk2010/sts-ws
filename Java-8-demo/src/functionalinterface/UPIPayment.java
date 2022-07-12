package functionalinterface;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@FunctionalInterface
//public interface UPIPayment extends TestInterface{
	
public interface UPIPayment {
	
	public String doPayment(String source, String dest);
	
	default double getScratchCard() {
		return new Random().nextDouble();
	}
	
	static String datePattern(String patterns) {
		SimpleDateFormat dateformat = new SimpleDateFormat(patterns);
		return dateformat.format(new Date());
	}
}
