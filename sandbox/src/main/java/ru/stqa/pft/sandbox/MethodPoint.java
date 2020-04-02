package ru.stqa.pft.sandbox;

public class MethodPoint {

    public double x;
    public double y;

  public MethodPoint (double x, double y) {
    this.x = x;
    this.y = y;
  }
    public static void main(String[] args) {

      MethodPoint p1 = new MethodPoint(2, 4);
      MethodPoint p2 = new MethodPoint(6, 10);

      System.out.println("Расстояние между двумя точками = " + p1.distance(p2));
    }

  public double distance(MethodPoint p2) {
     return Math.sqrt((this.x-p2.x)*(this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y));
    }

}


