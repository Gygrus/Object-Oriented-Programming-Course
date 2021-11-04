package agh.ics.oop;
import java.util.ArrayList;
import java.util.HashMap;


class RectangularMap implements IWorldMap {
    private int width, height;
    private IWorldMap map;
    private ArrayList<Animal> animals = new ArrayList<Animal>();

    public RectangularMap (int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return new MapVisualizer(this).draw(new Vector2d(0,0), new Vector2d(this.width, this.height));

    }
    public ArrayList<Animal> getAnimals(){
        return this.animals;
    }

    public boolean containsValue(final ArrayList<Animal> list, Vector2d vec){
        return list.stream().anyMatch(o -> o.getInitialPosition().equals(vec));
    }

    public boolean canMoveTo (Vector2d position) {
        return position.follows(new Vector2d(0, 0)) && position.precedes(new Vector2d(this.width, this.height))&& !isOccupied(position);
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
