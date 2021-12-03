package agh.ics.oop;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashMap;

class GrassField extends AbstractWorldMap {
    private final int numOfBushes;
    private HashMap<Vector2d, Grass> bushes = new HashMap<Vector2d, Grass>();
    private MapBoundary boundaryData = new MapBoundary();

    public GrassField(int n) {
        this.numOfBushes = n;
        generateBushes();
    }

    private void generateBushes() {
        int i = 0;
        int curRandom_x, curRandom_y;
        Vector2d curVec;
        while (i < this.numOfBushes) {
            curRandom_x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(this.numOfBushes * 10) + 1);
            curRandom_y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(this.numOfBushes * 10) + 1);
            curVec = new Vector2d(curRandom_x, curRandom_y);
            if (!this.bushes.containsKey(curVec)) {
                this.bushes.put(curVec, new Grass(curVec));
                this.boundaryData.addBush(curVec);
                i += 1;
            }
        }
    }

    @Override
    protected Vector2d lLeftGet() {
//        Vector2d currentVec = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        for (Vector2d position : this.animals.keySet()) currentVec = currentVec.lowerLeft(position);
//
//        for (Vector2d position : this.bushes.keySet()) currentVec = currentVec.lowerLeft(position);

        return this.boundaryData.getLowerLeft();
    }

    @Override
    protected Vector2d uRightGet() {
//        Vector2d currentVec = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
//        for (Vector2d position : this.animals.keySet()) currentVec = currentVec.upperRight(position);
//
//        for (Vector2d position : this.bushes.keySet()) currentVec = currentVec.upperRight(position);

        return this.boundaryData.getUpperRight();
    }

//    private boolean containsValueBush(final ArrayList<Grass> list, Vector2d vec){
//        return list.stream().anyMatch(o -> o.getPostition().equals(vec));
//    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || this.bushes.containsKey(position);
    }


    @Override
    public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj != null) {
            return obj;
        }
        return this.bushes.get(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (super.place(animal)){
            this.boundaryData.addAnimal(animal.getPosition());
            animal.addObserver(this.boundaryData);
            return true;
        }
        return false;
    }
}
