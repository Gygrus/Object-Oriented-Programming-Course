package agh.ics.oop;

public class Grass {
    Vector2d position;
    public Grass(Vector2d position){
        this.position = position;
    }

    public Vector2d getPostition() {
        return this.position;
    }

    public String toString(){return "*";}
}
