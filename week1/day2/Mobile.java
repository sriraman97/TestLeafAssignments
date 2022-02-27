package week1.day2;

public class Mobile {
	
	public void makeCall() {
		System.out.println("Calling....");
	}
	
	public void sendMsg() {
		System.out.println("Msg sent....");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mobile demoMobile = new Mobile();
		demoMobile.makeCall();
		demoMobile.sendMsg();
	}

}
