package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private IWorldMap map;
    private Vector2d initialPosition;


    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.initialPosition = initialPosition;
    }

    public Vector2d getInitialPosition() {
        return this.initialPosition;
    }

    public MapDirection getOrientation() {
        return this.orientation;
    }

    public String toString(){
        return switch (this.orientation) {
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.initialPosition.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                if (this.map.canMoveTo(this.initialPosition.add(this.orientation.toUnitVector()))) {
                    this.initialPosition = this.initialPosition.add(this.orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (this.map.canMoveTo(this.initialPosition.subtract(this.orientation.toUnitVector()))) {
                    this.initialPosition = this.initialPosition.subtract(this.orientation.toUnitVector());
                }
            }
        }
    }

}
