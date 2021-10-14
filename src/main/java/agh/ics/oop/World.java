package agh.ics.oop;

public class World {
    public static void main(String[] args){
        System.out.println("System wystartował");
        String[] tab = { "a", "b", "d", "awd" };
        run(tab);
        System.out.println("System zakończył działanie");
    }
    public static void run(String[] args){
        System.out.println("Zwierzak idzie do przodu");
        for(int i = 0; i < args.length; i++){
            switch(args[i]){
                case "f":
            }
        }
    }
}
