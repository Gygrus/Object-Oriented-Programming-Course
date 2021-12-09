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
    private IWorldMap map;
    private GridPane gridpane = new GridPane();

    @Override
    public void init() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
//        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(20);
//        this.map = new RectangularMap(10, 10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, this.map, positions);
        engine.run();
    }

    private void createGridPane() {
        AbstractWorldMap newMap = (AbstractWorldMap) this.map;
        this.gridpane.setGridLinesVisible(true);
        Vector2d lowerLeft = newMap.lLeftGet();
        Vector2d upperRight = newMap.uRightGet();

        int width = upperRight.getCordX() - lowerLeft.getCordX() + 2;
        int height = upperRight.getCordY() - lowerLeft.getCordY() + 2;
        for (int i = 0; i < width; i++){
            ColumnConstraints colConst = new ColumnConstraints(20);
            this.gridpane.getColumnConstraints().add(colConst);
        }

        for (int i = 0; i < height; i++){
            RowConstraints rowConst = new RowConstraints(20);
            this.gridpane.getRowConstraints().add(rowConst);
        }

        Label first = new Label("y/x");
        this.gridpane.add(first, 0, 0);
        this.gridpane.setHalignment(first, HPos.CENTER);

        for (int i = 0; i < height-1; i++){
            Label label = new Label(String.valueOf(upperRight.getCordY()-i));
            this.gridpane.add(label, 0, i+1);
            this.gridpane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < width-1; i++){
            Label label = new Label(String.valueOf(lowerLeft.getCordX()+i));
            this.gridpane.add(label, i+1, 0);
            this.gridpane.setHalignment(label, HPos.CENTER);
        }

        for (Animal animal : newMap.getAnimals().values()){
            Label label = new Label(animal.toString());
            this.gridpane.add(label, animal.getPosition().getCordX() - lowerLeft.getCordX() + 1, upperRight.getCordY()-(animal.getPosition().getCordY())+1);
            this.gridpane.setHalignment(label, HPos.CENTER);
        }

        for (Grass bush : newMap.getBushes().values()){
            Label label = new Label(bush.toString());
            this.gridpane.add(label, bush.getPosition().getCordX() - lowerLeft.getCordX() + 1, upperRight.getCordY()-(bush.getPosition().getCordY())+1);
            this.gridpane.setHalignment(label, HPos.CENTER);
        }
    }

    public void start(Stage primaryStage){
        createGridPane();
        Scene scene = new Scene(this.gridpane, 400, 400);
        primaryStage.setScene(scene);
        getParameters().getRaw();
        primaryStage.show();
    }
}
