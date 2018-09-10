package edu.smith.cs.csc212;

/**
 * This random number generator was designed to explain how in general they work.
 * 
 * DO NOT USE THIS IN REAL CODE!
 * Use something like {@link java.util.Random} instead, or {@link java.util.SecureRandom} if you're using any human data.
 * 
 * @author jfoley
 */
public class ToyRandom {
	private int currentValue;
	private int multiplier;
	private int shift;
	private int modulus;
	
	/**
	 * Init a random number generator from the current time (unlikely any will be the same ever again).
	 */
	public ToyRandom() {
		// Send our details to the next constructor.
		this((int) System.currentTimeMillis());
	}
	/**
	 * Create a RNG with a particular seed.
	 * @param seed The number to "start" from.
	 */
	public ToyRandom(int seed) {
		// Send our details to the next constructor.
		this(seed, 1713, 0, 1319);
	}
	/**
	 * This constructor makes a ToyRandom with all of its parameters eplicitly.
	 * @param seed - X_0 in Wikipedia.
	 * @param multiplier - a in Wikipedia.
	 * @param shift - c in Wikipedia.
	 * @param modulus - m in Wikipedia.
	 */
	public ToyRandom(int seed, int multiplier, int shift, int modulus) {
		this.currentValue = seed;
		this.multiplier = multiplier;
		this.shift = shift;
		this.modulus = modulus;
	}
	/**
	 * Construct the next internal value as an integer.
	 * @return a number up to modulus for usage.
	 */
	public int nextInt() {
		int next = ((this.currentValue * this.multiplier) + this.shift) % this.modulus;
		return next;
	}
	/**
	 * Return a smaller number than modulus.
	 * @param k - a number to bound our random numbers.
	 * @return the random number in [0,k).
	 */
	public int nextInt(int k) {
		int biggerRandomValue = nextInt();
		return biggerRandomValue % k;
	}

	/**
	 * Double-check my math for the slides.
	 * @param args ignored command line arguments.
	 */
	public static void main(String[] args) {
		for (int i=0; i<10; i++) {
			System.out.println("ToyRandom("+i+") = " + new ToyRandom(i).nextInt());
		}
	}
	
}
