package agh.ics.oop;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        out.println("Start");
        String[] tab = args;
        Direction[] tab1 = string_to_enum(tab);
        run(tab1);
        out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection check = MapDirection.EAST;
        out.println(check.next());
        out.println(check.previous());
        out.println(check.toUnitVector());
        out.println(check.toString());
    }
    public static void run(Direction[] args){
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w lewo");
                    break;

            }
        }
    }
    public static Direction[] string_to_enum(String[] arg){
        Direction[] tab = new Direction[arg.length];
        for (int i = 0; i < arg.length; i++){
            switch(arg[i]){
                case "f":
                    tab[i] = Direction.FORWARD;
                    break;
                case "b":
                    tab[i] = Direction.BACKWARD;
                    break;
                case "r":
                    tab[i] = Direction.RIGHT;
                    break;
                case "l":
                    tab[i] = Direction.LEFT;
                    break;
            }
        }
        return tab;
    }
}
