package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap {
    protected ArrayList<Animal> animals = new ArrayList<Animal>();
    protected MapVisualizer visualizer = new MapVisualizer(this);

    protected boolean containsValue(final ArrayList<Animal> list, Vector2d vec){
        return list.stream().anyMatch(o -> o.isAt(vec));
    }

    public String toString() {return visualizer.draw(lLeftGet(), uRightGet());}

    protected abstract Vector2d lLeftGet();

    protected abstract Vector2d uRightGet();


    public boolean canMoveTo (Vector2d position) {
        return !isOccupied(position);
    }

    public boolean place(Animal animal) {
        if (canMoveTo(animal.getInitialPosition())){
            this.animals.add(animal);
            return true;
        } else {
            return false;
        }
    }

    public boolean isOccupied(Vector2d position) {
        return containsValue(this.animals, position);
    }

    public Object objectAt(Vector2d position) {
        for (Animal a: this.animals) {
            if (a.getInitialPosition().equals(position)){
                return a;
            }
        }
        return null;
    }
}
