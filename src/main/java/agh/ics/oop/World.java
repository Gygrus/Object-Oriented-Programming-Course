package agh.ics.oop;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        System.out.println("Start");
        String[] tab = { "f", "f", "r", "l" };
        run(tab);
        System.out.println("Stop");
    }
    public static void run(String[] args){
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case "f":
                    out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    out.println("Zwierzak skręca w lewo");
                    break;

            }
        }
    }
}
