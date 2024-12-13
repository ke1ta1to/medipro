package models.entities;

public abstract class Entity {

  int x;
  int y;
  int width;
  int height;

  boolean right = false;
  boolean left = false;

  public Entity(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public boolean isRight() {
    return right;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  public boolean isLeft() {
    return left;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public void move() {
    if (isLeft()) {
      x -= 1;
    }
    if (isRight()) {
      x += 1;
    }
  }

}
