package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d positioned = new Vector2d(2, 2);

    public String toString(){
        return this.positioned + "-" + this.orientation;
    }

    public boolean isAt(Vector2d position) {
        return this.positioned.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d newvec1 = this.positioned.add(this.orientation.toUnitVector());
                if (newvec1.precedes(new Vector2d(4, 4)) && newvec1.follows(new Vector2d(0, 0))) {
                    this.positioned = newvec1;
                }
            }
            case BACKWARD -> {
                Vector2d newvec2 = this.positioned.subtract(this.orientation.toUnitVector());
                if (newvec2.precedes(new Vector2d(4, 4)) && newvec2.follows(new Vector2d(0, 0))) {
                    this.positioned = newvec2;
                }
            }
        }
    }
}
