package agh.ics.oop;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        System.out.println("System wystartował");
        String[] tab = { "f", "b", "l", "r" };
        run(tab);
        System.out.println("System zakończył działanie");
    }
    public static void run(String[] args){
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case "f":
                    out.println("Do przodu");
                    break;
                case "b":
                    out.println("Do tyłu");
                    break;
                case "r":
                    out.println("W prawo");
                    break;
                case "l":
                    out.println("W lewo");
                    break;

            }
        }
    }
}
