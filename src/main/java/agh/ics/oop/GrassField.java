package agh.ics.oop;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

class GrassField extends AbstractWorldMap {
    private final int numOfBushes;
    private ArrayList<Grass> bushes = new ArrayList<Grass>();
    public GrassField(int n){
        this.numOfBushes = n;
        generateBushes();
    }

    private void generateBushes() {
        int i = 0;
        int curRandom_x, curRandom_y;
        Vector2d curVec;
        while (i < this.numOfBushes){
            curRandom_x = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(this.numOfBushes*10)+1);
            curRandom_y = ThreadLocalRandom.current().nextInt(0, (int) Math.sqrt(this.numOfBushes*10)+1);
            curVec = new Vector2d(curRandom_x, curRandom_y);
            if (!containsValueBush(this.bushes, curVec)){
                this.bushes.add(new Grass(curVec));
                i+=1;
            }
        }
    }
    @Override protected Vector2d lLeftGet() {
        Vector2d currentVec = this.animals.get(0).getInitialPosition();
        for (Animal animal : this.animals) currentVec = currentVec.lowerLeft(animal.getInitialPosition());

        for (Grass bush : this.bushes) currentVec = currentVec.lowerLeft(bush.getPostition());

        return currentVec;
    }

    @Override protected Vector2d uRightGet() {
        Vector2d currentVec = this.animals.get(0).getInitialPosition();
        for (Animal animal : this.animals) currentVec = currentVec.upperRight(animal.getInitialPosition());

        for (Grass bush : this.bushes) currentVec = currentVec.upperRight(bush.getPostition());

        return currentVec;
    }

    private boolean containsValueBush(final ArrayList<Grass> list, Vector2d vec){
        return list.stream().anyMatch(o -> o.getPostition().equals(vec));
    }

    @Override public boolean isOccupied(Vector2d position) {
        return super.isOccupied(position) || containsValueBush(this.bushes, position);
    }


    @Override public Object objectAt(Vector2d position) {
        Object obj = super.objectAt(position);
        if (obj == null) {
            for (Grass a : this.bushes) {
                if (a.getPostition().equals(position)) {
                    return a;
                }
            }
            return null;
        }
        return obj;
        }
    }
