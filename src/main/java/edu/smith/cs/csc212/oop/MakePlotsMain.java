package edu.smith.cs.csc212.oop;

public class MakePlotsMain {
  public static void main(String[] args) {
    // Create a new air conditioning unit.
    final AirConditioning ac = new AirConditioning(
        AirConditioning.friday[0], 1, 72, 70);

    // Assume our starting temperature is the first
    // temperature.
    int lastTemp = AirConditioning.friday[0];

    // Then we don't have to deal with friday[hour-1] or
    // friday[hour+1] going off the end.
    for (int hour = 0; hour < AirConditioning.friday.length; hour++) {
      int outside = AirConditioning.friday[hour];
      // Calculate the change in temperature.
      int changeOutside = outside - lastTemp;
      // update lastTemp so we get the right
      // "changeOutside"
      // the next time through the loop.
      lastTemp = outside;

      // The house is insulated, so it should move
      // "toward"
      // the outside temperature, but slowly.

      // We ask for the "sign" of that direction. If our
      // insulation were bad, we might use two times this
      // number.
      int changeInside = AirConditioning.sign(
          outside - ac.getTemperature());

      // Tell our AC system to do something (if it is on).
      // It also tracks the inside temperature for us!
      ac.simulate(changeInside);

      System.out.println(hour + "\t" + outside + "\t"
          + ac.getTemperature());
    }
  }
}