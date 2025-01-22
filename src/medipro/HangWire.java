package medipro;

public class HangWire {
  private Vector2 start;

  private Vector2 direction;
  private Vector2 launched;
  private double progress;
  private boolean isHanged = false;

  public HangWire(Vector2 start, Vector2 direction) {
    this.start = start;
    this.direction = direction;
    this.launched = start;
  }

  public Vector2 getStart() {
    return start;
  }

  public void setStart(Vector2 start) {
    this.start = start;
  }

  public Vector2 getDirection() {
    return direction;
  }

  public double getProgress() {
    return progress;
  }

  public void setProgress(double progress) {
    this.progress = progress;
  }

  public Vector2 getEnd(double progress) {
    return launched.add(direction.mul(progress));
  }

  public Vector2 getEnd() {
    return getEnd(progress);
  }

  public Vector2 getLaunched() {
    return launched;
  }

  public boolean isHanged() {
    return isHanged;
  }

  public void setHanged(boolean isHanging) {
    this.isHanged = isHanging;
  }
}
