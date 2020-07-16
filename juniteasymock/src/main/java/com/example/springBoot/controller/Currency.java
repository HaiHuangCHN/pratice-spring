package com.example.springBoot.controller;

import java.io.IOException;

public class Currency {

	private String units;
	private long amount;
	private int cents;

	public Currency(double amount, String units) {
		this.units = units;// USD
		setAmount(amount);// 3.75
	}

	private void setAmount(double amount) {
		this.amount = new Double(amount).longValue();// 3.75 =>  3
		this.cents = (int) ((amount * 100.0) % 100);// 3.75 => 75
	}

	public Currency toEuros(ExchangeRate converter) {
		if ("EUR".equals(units))
			return this;
		else {
			double input = amount + cents / 100.0;// 3 + 0.75
			double rate;
			try {
				rate = converter.getRate(units, "EUR");// 1.5
				double output = input * rate; // 
				return new Currency(output, "EUR");// 
			} catch (IOException ex) {
				System.out.println("There is an exception");
				return null;
			}
		}
	}

	public boolean equals(Object o) {
		if (o instanceof Currency) {
			Currency other = (Currency) o;
			return this.units.equals(other.units) && this.amount == other.amount && this.cents == other.cents;
		}
		return false;
	}

	public String toString() {
		return amount + "." + Math.abs(cents) + " " + units;
	}

}
