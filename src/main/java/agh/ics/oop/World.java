package agh.ics.oop;
import static java.lang.System.out;
import java.util.ArrayList;
public class World {
    public static void main(String[] args){
        Animal zwierzak = new Animal();
        OptionsParser test = new OptionsParser();
        ArrayList<MoveDirection> tab_move = test.parse(args);
        for (MoveDirection i: tab_move) {
            zwierzak.move(i);
            out.println(zwierzak.toString());
        }
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
