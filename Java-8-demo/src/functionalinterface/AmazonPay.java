package functionalinterface;

public class AmazonPay implements UPIPayment{

	@Override
	public String doPayment(String source, String dest) {
		return UPIPayment.datePattern("yyyy-MM-dd").toString();
	}

}
