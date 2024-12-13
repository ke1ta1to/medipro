package models.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

  public Player() {
    super(20, 20);
  }

  public void draw(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(x, y, width, height);
  }

  public void printLocation() {
    System.out.println("x: " + x + " y: " + y);
  }

}
