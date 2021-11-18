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
        Vector2d newPositionA, newPositionB;
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
            newPositionA = this.initialPosition.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPositionA)) {
                    this.initialPosition = newPositionA;
                }
            }
            case BACKWARD -> {
                newPositionB = this.initialPosition.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(newPositionB)) {
                    this.initialPosition = newPositionB;
                }
            }
        }
    }

}
