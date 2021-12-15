package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private MoveDirection[] directions;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();
    private Vector2d[] tabOfPositions;
    private App guiObserver;


    public SimulationEngine(IWorldMap map, Vector2d[] tabOfPositions){
        this.map = map;
        this.tabOfPositions = tabOfPositions;
        for (Vector2d pos: tabOfPositions){
            Animal ToPut = new Animal(this.map, pos);
            if (this.map.place(ToPut)) {
                this.animals.add(ToPut);
                }
            }
        }

    public void addGuiObserver(App observer){
        this.guiObserver = observer;
    }

    public void setDirections(MoveDirection[] directions) {this.directions = directions;}

    public void guiUpdate() {
        this.guiObserver.guiUpdate();
    }


    public void run(){
        int i = 0;
        for (MoveDirection dir: this.directions) {
            this.animals.get(i%(this.animals.size())).move(dir);
            guiUpdate();
            i += 1;
            System.out.println(map.toString());
        }
    }
}
