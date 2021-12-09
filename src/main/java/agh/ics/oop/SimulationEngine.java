package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private List<Animal> animals = new ArrayList<>();
    private Vector2d[] tabOfPositions;


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] tabOfPositions){
        this.directions = directions;
        this.map = map;
        this.tabOfPositions = tabOfPositions;
        for (Vector2d pos: tabOfPositions){
            Animal ToPut = new Animal(this.map, pos);
            if (this.map.place(ToPut)) {
                this.animals.add(ToPut);
                }
            }
        }


    public Vector2d[] getTabOfPositions() {
        return this.tabOfPositions;
    }

    public List<Animal> getAnimals() { return this.animals;}

    public void run(){
        int i = 0;
        for (MoveDirection dir: this.directions) {
            this.animals.get(i%(this.animals.size())).move(dir);
//            this.tabOfPositions[i%(map2.getAnimals().size())] = map2.getAnimals().get(i%(map2.getAnimals().size())).getInitialPosition();
            i += 1;
            System.out.println(map.toString());
//            System.out.println(map2.getAnimals().get(0).getInitialPosition());
//            System.out.println(map2.getAnimals().get(1).getInitialPosition());
        }
    }
}
