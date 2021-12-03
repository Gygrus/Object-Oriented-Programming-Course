package agh.ics.oop;

import com.sun.source.tree.Tree;

import java.util.*;

import javafx.util.Pair;

public class MapBoundary implements IPositionChangeObserver {
    Comparator<Vector2d> comparatorX = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.getCordX() - o2.getCordX() == 0){
                if (o1.getCordY() - o2.getCordY() == 0){
                    return 1;
                } else {
                    return o1.getCordY() - o2.getCordY();
                }
            }
            return o1.getCordX() - o2.getCordX();
        }
    };

    Comparator<Vector2d> comparatorY = new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d o1, Vector2d o2) {
            if (o1.getCordY() - o2.getCordY() == 0){
                if (o1.getCordX() - o2.getCordX() == 0){
                    return 1;
                } else {
                    return o1.getCordX() - o2.getCordX();
                }
            }
            return o1.getCordY() - o2.getCordY();
        }

    };

    SortedSet<Vector2d> xAxisAnimals = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> yAxisAnimals = new TreeSet<>(comparatorY);
    SortedSet<Vector2d> xAxisBushes = new TreeSet<>(comparatorX);
    SortedSet<Vector2d> yAxisBushes = new TreeSet<>(comparatorY);

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.xAxisAnimals.remove(oldPosition);
        this.xAxisAnimals.add(newPosition);

        this.yAxisAnimals.remove(oldPosition);
        this.yAxisAnimals.add(newPosition);
    }

    protected void addBush(Vector2d position){
        this.xAxisBushes.add(position);
        this.yAxisBushes.add(position);
    }

    protected void addAnimal(Vector2d position){
        this.xAxisAnimals.add(position);
        this.yAxisAnimals.add(position);
    }

    protected Vector2d getLowerLeft(){
        return new Vector2d (Math.min(this.xAxisAnimals.first().getCordX(), this.xAxisBushes.first().getCordX()), Math.min(this.yAxisAnimals.first().getCordY(), this.yAxisBushes.first().getCordY()));
    }

    protected Vector2d getUpperRight(){
        return new Vector2d (Math.max(this.xAxisAnimals.last().getCordX(), this.xAxisBushes.last().getCordX()), Math.max(this.yAxisAnimals.last().getCordY(), this.yAxisBushes.last().getCordY()));
    }

}
