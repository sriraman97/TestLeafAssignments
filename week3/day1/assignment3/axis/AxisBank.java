package week3.day1.assignment3.axis;

import week3.day1.assignment3.bankInfo.BankInfo;

public class AxisBank extends BankInfo{

	public void deposit() {
		System.out.println("Thanks for depositing in Axis Bank. Your updated balance is Rs.XYZ");
	}
	public static void main(String[] args) {
		
		AxisBank axis = new AxisBank();
		
		axis.savings();
		axis.fixed();
		axis.deposit();
	}

}
