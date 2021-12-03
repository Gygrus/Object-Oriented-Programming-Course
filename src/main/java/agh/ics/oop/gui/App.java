package agh.ics.oop.gui;

//import agh.ics.oop.GrassField;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import static java.lang.System.out;

import static java.lang.System.console;
import static java.lang.System.out;


public class App extends Application {
    public void start(Stage primaryStage){
        Label label1 = new Label("Zwierzak");
        Label label2 = new Label("Zwierzak");
        Label label3 = new Label("Zwierzak");
        Label label4 = new Label("Zwierzak");
        Label label5 = new Label("Zwierzak");
        Label label6 = new Label("Zwierzak");
        GridPane gridpane = new GridPane();
        gridpane.setGridLinesVisible(true);
//        gridpane.add(label1, 0, 0, 1, 1);
//        gridpane.add(label2, 1, 0, 1, 1);
//        gridpane.add(label3, 2, 0, 1, 1);
//        gridpane.add(label4, 0, 1, 1, 1);
//        gridpane.add(label5, 1, 1, 1, 1);
//        gridpane.add(label6, 2, 1, 1, 1);


        GrassField map = new GrassField(5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        map.place(new Animal(map,new Vector2d(2, 2)));
        map.place(new Animal(map,new Vector2d(3, 4)));
        Vector2d lowerLeft = map.lLeftGet();
        Vector2d upperRight = map.uRightGet();

        int width = upperRight.getCordX() - lowerLeft.getCordX() + 2;
        int height = upperRight.getCordY() - lowerLeft.getCordY() + 2;
        for (int i = 0; i < width; i++){
            ColumnConstraints colConst = new ColumnConstraints(20);
            gridpane.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < height; i++){
            RowConstraints rowConst = new RowConstraints(20);
            gridpane.getRowConstraints().add(rowConst);
        }
        Label first = new Label("y/x");
        gridpane.add(first, 0, 0);
        gridpane.setHalignment(first, HPos.CENTER);

        for (int i = 0; i < height-1; i++){
            Label label = new Label(String.valueOf(upperRight.getCordY()-i));
            gridpane.add(label, 0, i+1);
            gridpane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < width-1; i++){
            Label label = new Label(String.valueOf(lowerLeft.getCordX()+i));
            gridpane.add(label, i+1, 0);
            gridpane.setHalignment(label, HPos.CENTER);
        }

        for (Animal animal : map.getAnimals().values()){
            Label label = new Label(animal.toString());
            gridpane.add(label, animal.getPosition().getCordX() - lowerLeft.getCordX() + 1, upperRight.getCordY()-(animal.getPosition().getCordY())+1);
            gridpane.setHalignment(label, HPos.CENTER);
        }

        for (Grass bush : map.getBushes().values()){
            Label label = new Label(bush.toString());
            gridpane.add(label, bush.getPosition().getCordX() - lowerLeft.getCordX() + 1, upperRight.getCordY()-(bush.getPosition().getCordY())+1);
            gridpane.setHalignment(label, HPos.CENTER);
        }

        Scene scene = new Scene(gridpane, 400, 400);
        gridpane.setConstraints(first, 0, 0);
        System.out.println(width);
        System.out.println(height);
        System.out.println(upperRight.toString());
        System.out.println(lowerLeft.toString());
        primaryStage.setScene(scene);
        getParameters().getRaw();
        primaryStage.show();
    }
}
