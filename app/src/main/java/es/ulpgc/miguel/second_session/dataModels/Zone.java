package es.ulpgc.miguel.second_session.dataModels;

public class Zone {
  private String name;
  private int songUri;
  private double x0, y0, x1, y1;

  public Zone(String name, int songUri, double x0, double y0, double x1, double y1) {
    this.name = name;
    this.songUri = songUri;
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
  }

  //--------------------------------------------
  //-----------GETTERS AND SETTERS--------------
  //--------------------------------------------

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSongUri() {
    return songUri;
  }

  public void setSongUri(int songUri) {
    this.songUri = songUri;
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
