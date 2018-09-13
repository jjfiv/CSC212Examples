package edu.smith.cs.csc212.oop;

public class RTPoint {
  private double r;
  private double theta;
  
  public RTPoint(double x, double y) {
    r = Math.sqrt(x*x + y*y);
    theta = Math.atan2(y, x);
  }
  public double magnitude() {
    return r;
  }
  public double angle() {
    return theta;
  }
  public double degrees() {
    return Math.toDegrees(theta);
  }
  // This may mean writing boring methods.
  public double x() {
    return r * Math.cos(theta);
  }
  public double y() {
    return r * Math.sin(theta);
  }
  
  public static void main(String[] args) {
    RTPoint a = new RTPoint(3,4);
    System.out.println("R: " + a.magnitude() + ", x="
        + a.x() + " y=" + a.y());
  }
}
