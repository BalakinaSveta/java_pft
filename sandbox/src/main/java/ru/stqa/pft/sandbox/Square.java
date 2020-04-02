package ru.stqa.pft.sandbox;

public class Square {
  public double l;
  public Square (double l){
    this.l = l;
  }

  public static void main(String[] args) {
    Square s = new Square(5);

    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());
  }

    public double area (){
      return this.l * this.l;
    }
  }

