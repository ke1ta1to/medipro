package net.keitaito.medipro;

public class Vector2 {
  private double x;
  private double y;

  public Vector2(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public Vector2 add(Vector2 other) {
    return new Vector2(x + other.x, y + other.y);
  }

  public Vector2 sub(Vector2 other) {
    return new Vector2(x - other.x, y - other.y);
  }

  public Vector2 mul(double scalar) {
    return new Vector2(x * scalar, y * scalar);
  }

  public Vector2 div(double scalar) {
    return new Vector2(x / scalar, y / scalar);
  }

  public Vector2 normalize() {
    double n = norm();
    return new Vector2(x / n, y / n);
  }

  public double norm() {
    return Math.sqrt(x * x + y * y);
  }

  public double norm2() {
    return x * x + y * y;
  }
}
