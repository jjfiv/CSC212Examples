package edu.smith.cs.csc212.oop;

public class OneCard {
	/**  Who owns this card? */
	String owner;
	/** How much money is stored here? */
	double balance;
	
	public OneCard(String person, double money) {
		this.owner = person;
		this.balance = money;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public boolean canAfford(double amount) {
		return this.balance > amount;
	}
	
	public void spend(double amount) {
		if (!this.canAfford(amount)) {
			throw new RuntimeException("Can't afford "+amount);
		}
		this.balance -= amount;
	}
	
	public static void main(String[] args) {
		OneCard me = new OneCard("Myself", 5.00);
		OneCard myRichFriend = new OneCard("Friend", 50.00);
		myRichFriend.deposit(20.00);
		System.out.println("I'm broke: " + me.canAfford(60.00));
		System.out.println("Friend rich: "+myRichFriend.canAfford(60.00));
		myRichFriend.spend(13.87);
		System.out.println("$60 is a lot: "+myRichFriend.canAfford(60.00));
	}
}
