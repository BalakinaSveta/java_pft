package ru.stqa.pft.sandbox;

public class MethodPoint {

    public double x1;
    public double x2;
    public double y1;
    public double y2;

  public MethodPoint (double x1, double x2, double y1, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
    public static void main(String[] args) {

      MethodPoint dis = new MethodPoint(2, 6, 4, 10);

      System.out.println("Расстояние между двумя точками = " + dis.distance());
    }

    public double distance() {
     return Math.sqrt((this.x2-this.x1)*(this.x2-this.x1)+(this.y2-this.y1)*(this.y2-this.y1));
    }

}


