package week3.day1.assignment1.org.system;

public class Desktop extends Computer{
	
	public void desktopSize() {
		System.out.println("18 x 16 inches");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Desktop d1 = new Desktop();
		d1.computerModel();
		d1.desktopSize();
	}

}
