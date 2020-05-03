package com.atm;

public class ATM {
	
    
	int d20s;
    int d10s;
    int d5s;
    int d1s;
    int wd20s;
    int wd10s;
    int wd5s;
    int wd1s;
    int total;
    
   
	
	public String deposit(String input) {
		String d = null;
		int count = 0;
		String result=null;
		String[] noOfPairs = input.split(",");
		for (int i = 0; i < noOfPairs.length; i++) {
			String pair = noOfPairs[i].trim();
			String[] denomAndCount = pair.split(":");
			d = denomAndCount[0];
			count = Integer.parseInt(denomAndCount[1].trim());
			String negRes=isNegative(count);
			String zeroRes=isZeroBalance(count);
			if (negRes.isEmpty() && zeroRes.isEmpty()) {
				if (d.equals("20s")) {
					d20s = d20s + count;
				}
				if (d.equals("10s")) {
					d10s = d10s + count;
				}
				if (d.equals("5s")) {
					d5s = d5s + count;
				}
				if (d.equals("1s")) {
					d1s = d1s + count;
				}
				calcAvailBal();
				result = this.toString();
			}else {
				result =negRes+zeroRes;
			}
	}
		System.out.println(result);
		return result;
	}
	
	public void calcAvailBal() {
		total= d20s*20+d10s*10+d5s*5+d1s;		
	}
	
	public String[] withdraw(int amount) {
		String[] result = new String[2];
		 String inSuffRes= isInsufficientFund(amount);
		if (inSuffRes.isEmpty()) {
			wd20s = amount / 20;
			amount = amount % 20;
			wd10s = amount / 10;
			amount = amount % 10;
			wd5s = amount / 5;
			amount = amount % 5;
			wd1s = amount / 1;
            
			d20s = d20s - wd20s;
			d10s = d10s - wd10s;
			d5s = d5s - wd5s;
			d1s = d1s - wd1s;

			result[0] = "Dispensed: 20s=" + wd20s + ", 10s=" + wd10s + ", 5s=" + wd5s + ", 1s=" + wd1s;
			calcAvailBal();
			result[1] = this.toString();
			System.out.println(result[1]);
		}else {
			result[0]=inSuffRes;
		}
		System.out.println(result[0]);
		return result;
	}

	public String isNegative(int amount) {
		if (amount < 0) {
			
			return "Incorrect deposit amount";
		} else {
			return "";
		}
	}

	public String isZeroBalance(int amount) {
		if (amount == 0) {
		
			return "Deposit amount cannot be zero";
		} else {
			return "";
		}
	}

	public String isInsufficientFund(int wdAmt) {

		if (wdAmt <= 0 || wdAmt > total) {
			
			return "Incorrect or insufficient funds";
		} else {
			return "";
		}

	}
	

    @Override
	public String toString() {
		return "Balance: 20s=" + d20s + ", 10s=" + d10s + ", 5s=" + d5s
				+ ", 1s=" + d1s + ", Total=" + total ;
	}

}
