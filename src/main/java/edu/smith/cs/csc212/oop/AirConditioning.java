package edu.smith.cs.csc212.oop;

public class AirConditioning {
  /**
   * The air conditioning also maintains the indoor
   * temperature of the house.
   */
  int temperature;
  /**
   * What temperature we should turn on at (e.g., 72F).
   */
  int turnOnAt;
  /**
   * What temperature we should turn off at (e.g., 70F), so
   * that it doesn't just flicker on and off, which wastes
   * power this is usually spaced out a little from the
   * turnOnAt temperature.
   */
  int turnOffAt;
  /**
   * The power of the AC unit -- how many degrees it can
   * change in an hour.
   */
  int power;
  /**
   * Is the AC unit currently on? This is not a simple if
   * statement on temperature, since it may be either ON or
   * OFF between turnOnAt and turnOffAt.
   */
  boolean running;

  /**
   * Just for fun, we track the power usage of our AC in
   * terms of the number of hours it was on.
   */
  int hoursRunning = 0;
  /**
   * Just for fun, we track the maximum indoor temperature
   * here.
   */
  int maxTemperature = 0;

  /**
   * A new air conditioning model needs a few parameters.
   * 
   * @param temperature - the house temperature to start at.
   * @param power       - how good the AC is.
   * @param turnOnAt    - when to turn on.
   * @param turnOffAt   - when to turn off.
   */
  public AirConditioning(int temperature, int power,
      int turnOnAt, int turnOffAt) {
    if (turnOnAt <= turnOffAt) {
      throw new IllegalArgumentException(
          "Your AirConditioning will never turn on, since on="
              + turnOnAt + " is colder than off="
              + turnOffAt);
    }
    this.temperature = temperature;
    this.power = power;
    this.turnOffAt = turnOffAt;
    this.turnOnAt = turnOnAt;
    this.running = false;
  }

  /**
   * We run a step of the simulation.
   * 
   * @param changeInTemperature this is the amount to change
   *                            the indoor temperature by
   *                            (the AC may fight this).
   */
  public void simulate(int changeInTemperature) {
    this.temperature += changeInTemperature;

    // If it is on, we might fight the temperature change.
    if (running) {
      // This hour, it ran.
      this.hoursRunning += 1;

      // Temperature should go down since we're on.
      this.temperature -= power;

      // Should we turn off now?
      if (this.temperature < turnOffAt) {
        this.running = false;
      }
    } else {
      // AC not on, should we turn on now?
      if (this.temperature >= turnOnAt) {
        this.running = true;
      }
    }

    // Is this the hottest temperature we've seen?
    if (temperature > maxTemperature) {
      maxTemperature = temperature;
    }
  }

  /**
   * It is traditional in Java to create methods to let
   * people know which variables are for their use.
   * 
   * @return the indoor temperature.
   */
  public int getTemperature() {
    return temperature;
  }

  /**
   * It is traditional in Java to create methods to let
   * people know which variables are for their use.
   * 
   * @return the current state of the AC.
   */
  public boolean isRunning() {
    return running;
  }

  // Hourly friday forecast for Northampton on 2018-09-14
  // These temperatures are in Fahrenheit (we're not all
  // going to die).
  // https://www.wunderground.com/hourly/us/ma/northampton/date/2018-09-14?cm_ven=localwx_hour
  public static int[] friday = new int[] { 67, 66, 66, 65,
      65, 65, 64, 63, 65, 68, 71, 73, 75, 77, 79, 79, 79,
      79, 78, 76, 73, 70, 67, 66 };

  /**
   * It's always nice to put F in C for people who are more
   * familiar.
   * 
   * @param degreesF Fahrenheit reading.
   * @return the equivalent celsius reading.
   */
  public static int toCelsius(int degreesF) {
    return (int) ((degreesF - 32.0) * 5.0 / 9.0);
  }

  /**
   * Print a nicer version of the hour than just 0..23
   * 
   * @param hour as a number.
   * @return a string representing that hour.
   */
  public static String formatHour(int hour) {
    if (hour == 0) {
      return "Midnight";
    } else if (hour <= 12) {
      // I put some extra spaces in here so all outputs
      // would be the same width and it would look more like
      // a table.
      return hour + ":00AM  ";
    } else {
      int pm = hour - 12;
      return pm + ":00PM  ";
    }
  }

  /**
   * Return the "sign" of a number. This lets us move our
   * indoor temperature towards an outdoor temperature at a
   * speed of our choosing.
   * 
   * @param number - any integer.
   * @return 0, -1, or 1, depending on the sign.
   */
  public static int sign(int number) {
    if (number == 0) {
      return 0;
    } else if (number < 0) {
      return -1;
    } else {
      return 1;
    }
  }

  public static void main(String[] args) {
    // Create a new air conditioning unit.
    final AirConditioning ac = new AirConditioning(
        friday[0], 1, 72, 70);

    // Print settings about our simulation.
    System.out.println("AC turns on at: " + ac.turnOnAt);
    System.out.println("AC turns off at: " + ac.turnOffAt);
    System.out.println(
        "AC manages " + ac.power + " degrees per hour.");
    System.out.println();

    System.out.println("=== Start Simulation ===");

    // Assume our starting temperature is the first
    // temperature.
    int lastTemp = friday[0];

    // Then we don't have to deal with friday[hour-1] or
    // friday[hour+1] going off the end.
    for (int hour = 0; hour < friday.length; hour++) {
      int outside = friday[hour];
      System.out.println("Hour: " + formatHour(hour)
          + " F: " + outside + " C: " + toCelsius(outside));

      // Calculate the change in temperature.
      int changeOutside = outside - lastTemp;
      // update lastTemp so we get the right "changeOutside"
      // the next time through the loop.
      lastTemp = outside;

      // The house is insulated, so it should move "toward"
      // the outside temperature, but slowly.

      // We ask for the "sign" of that direction. If our
      // insulation were bad, we might use two times this
      // number.
      int changeInside = sign(
          outside - ac.getTemperature());

      // Tell our AC system to do something (if it is on).
      // It also tracks the inside temperature for us!
      ac.simulate(changeInside);

      // Print out what the AC is responding to here.
      System.out.println("  Change in temperature outside: "
          + changeOutside);
      System.out.println("  Change in temperature inside: "
          + changeInside);

      // Show the state of the AC system.
      System.out.println("  Inside: " + ac.getTemperature()
          + " isRunning: " + ac.isRunning());
      System.out.println();
    }

    System.out.println("=== End Simulation ===");
    System.out.println(
        "The AC ran for " + ac.hoursRunning + " hours.");
    System.out
        .println("The indoor temperature maxed out at: "
            + ac.maxTemperature);

  }
}
