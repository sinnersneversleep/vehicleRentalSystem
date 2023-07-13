package com.main.java.mmt.models;

public class Payment {
	public boolean isSuccessFul;

	public boolean acceptPayment(double cost) {
		// todo create payment flow;
		this.isSuccessFul = paymentFlow();
		return this.isSuccessFul;
	}

	public boolean paymentFlow() {
		return true; // create a payment flow;
	}

}
