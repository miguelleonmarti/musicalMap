package es.ulpgc.miguel.second_session.Map;

public class Zones {
  private String name;
  private double x0, y0, x1, y1;

  public Zones(String name, double x0, double y0, double x1, double y1) {
    this.name = name;
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getX0() {
    return x0;
  }

  public void setX0(double x0) {
    this.x0 = x0;
  }

  public double getY0() {
    return y0;
  }

  public void setY0(double y0) {
    this.y0 = y0;
  }

  public double getX1() {
    return x1;
  }

  public void setX1(double x1) {
    this.x1 = x1;
  }

  public double getY1() {
    return y1;
  }

  public void setY1(double y1) {
    this.y1 = y1;
  }
}
