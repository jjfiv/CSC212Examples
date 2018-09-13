package edu.smith.cs.csc212.oop;

public class XYPoint {
  private double x;
  private double y;
  
  public XYPoint(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public double magnitude() {
    return Math.sqrt(x*x + y*y);
  }
  public double angle() {
    return Math.atan2(y, x);
  }
  public double degrees() {
    return Math.toDegrees(angle());
  }
  public double x() {
    return x;
  }
  public double y() {
    return y;
  }
  
  public static void main(String[] args) {
    XYPoint a = new XYPoint(3,4);
    System.out.println("R: " + a.magnitude() + ", x="
        + a.x() + " y=" + a.y());
  }
}
