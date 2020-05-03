package com.atm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.atm.ATM;

public class ATMTest {
	ATM a = null;

	@Before
	public void beforeEach() {
		a = new ATM();
	}

	

	@Test
	public void testTransactions() {
		assertEquals(a.deposit("10s: -1"), "Incorrect deposit amount");
		assertEquals(a.deposit("5s: 0"), "Deposit amount cannot be zero");
		assertEquals(a.deposit("10s: 8, 5s: 20"), "Balance: 20s=0, 10s=8, 5s=20, 1s=0, Total=180");
		assertEquals(a.deposit("20s: 3, 5s: 18, 1s: 4"), "Balance: 20s=3, 10s=8, 5s=38, 1s=4, Total=334");
		String[] wr1 = a.withdraw(75);
		assertEquals(wr1[0], "Dispensed: 20s=3, 10s=1, 5s=1, 1s=0");
		assertEquals(wr1[1], "Balance: 20s=0, 10s=7, 5s=37, 1s=4, Total=259");
		/*
		 * String[] wr2 = a.withdraw(122); assertEquals(wr2[0],
		 * "Dispensed: 10s=7, 5s=10, 1s=2"); assertEquals(wr2[1],
		 * "Balance: 20s=0, 10s=0, 5s=27, 1s=2, Total=137");
		 */
		String[] wr3 = a.withdraw(300);
		assertEquals(wr3[0], "Incorrect or insufficient funds");
		String[] wr4 = a.withdraw(0);
		assertEquals(wr4[0], "Incorrect or insufficient funds");
		String[] wr5 = a.withdraw(-25);
		assertEquals(wr5[0], "Incorrect or insufficient funds");

	}
	
	

}
