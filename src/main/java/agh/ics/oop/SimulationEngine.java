package agh.ics.oop;

class SimulationEngine implements IEngine {
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] tabOfPositions;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] tabOfPositions){
        this.directions = directions;
        this.map = map;
        this.tabOfPositions = tabOfPositions;
        for (Vector2d pos: tabOfPositions){
            this.map.place(new Animal(this.map, pos));
        }
    }

    public Vector2d[] getTabOfPositions() {
        return this.tabOfPositions;
    }

    public void run(){
        RectangularMap map2 = (RectangularMap) this.map;
        int i = 0;
        for (MoveDirection dir: this.directions) {
            map2.getAnimals().get(i%(map2.getAnimals().size())).move(dir);
            this.tabOfPositions[i%(map2.getAnimals().size())] = map2.getAnimals().get(i%(map2.getAnimals().size())).getInitialPosition();
            i += 1;
//            System.out.println(map.toString());
//            System.out.println(map2.getAnimals().get(0).getInitialPosition());
//            System.out.println(map2.getAnimals().get(1).getInitialPosition());
        }
    }
}
