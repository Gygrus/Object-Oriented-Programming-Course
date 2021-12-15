package agh.ics.oop;

import java.io.FileInputStream;

public abstract class MapObject {
    protected Vector2d position;

    public Vector2d getPosition(){
        return this.position;
    }

    abstract public String getInputStream();

    public String getLabel() { return this.position.toString(); }
}
