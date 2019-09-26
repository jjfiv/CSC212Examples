package edu.smith.cs.csc212.oop;

public class DogAge1 {
	private int dogYears;
	
	public int getHumanYears() {
		return this.dogYears / 7;
	}
	public void setHumanYears(int y) {
		this.dogYears = y * 7;
	}
	public int getDogYears() {
		return this.dogYears;
	}
	public void setDogYears(int y) {
		this.dogYears = y;
	}
}
