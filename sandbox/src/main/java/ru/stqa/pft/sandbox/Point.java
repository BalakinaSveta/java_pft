package ru.stqa.pft.sandbox;

public class Point {

  public double x1;
  public double x2;
  public double y1;
  public double y2;

  public static void main(String[] args) {

  Point p1 = new Point();
  Point p2 = new Point();

  p1.x1 = 2;
  p2.x2 = 6;
  p1.y1 = 4;
  p2.y2 = 10;

    System.out.println("Расстояние между двумя точками = " + distance(p1, p2));
  }

    public static double distance(Point p1, Point p2){
    double dis = Math.sqrt((p2.x2-p1.x1)*(p2.x2-p1.x1)+(p2.y2-p1.y1)*(p2.y2-p1.y1));
    return dis;
    }
}
