/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicmvc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class BasicMVC extends Application {

    Circle gamePiece = new Circle(50, Color.YELLOW);
    Circle gameToken = new Circle(50, 50, 50, Color.BLUE);
    Rectangle buttonShape = new Rectangle(100, 100);
    Model gameData = new Model(6, 4);
    GridPane test1 = new GridPane();
    Integer boardSize = 6;

    @Override
    public void start(Stage primaryStage) {

        //Generate Grid
        for (int i = 0; i < 8; i++) {
            ColumnConstraints column = new ColumnConstraints(100);
            test1.getColumnConstraints().add(column);

        }

        for (int i = 0; i < 8; i++) {
            RowConstraints row = new RowConstraints(50);
            test1.getRowConstraints().add(row);
        }

        buttonShape.setFill(Color.BLUE);
            System.out.println("Player " + gameData.getPlayerTurn() + "'s" + " Turn.");

        for (int i = 0; i < gameData.getBoardSize(); i++) {
            Button testButton = new Button("Button " + String.valueOf(i));
            testButton.setShape(gamePiece);
            testButton.setMinSize(100, 100);
            testButton.setMaxSize(100, 100);
            testButton.setId(String.valueOf(i));

            testButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    //
                    System.out.println("youclicked button " + testButton.getId());

                    gameData.dropGamePiece(Integer.parseInt(testButton.getId()));
                    gameData.printGameArray();
                    Integer checkForWin = gameData.checkForWin();
                    System.out.println("Player " + gameData.getPlayerTurn() + "'s" + " Turn.");
                    //get which column token was dropped into.
                            //update game model with player column selection
                            //
                            //create game token and add it to the scene
                            Pane pane = new Pane();
                    pane.getChildren().add(gameToken);
                    test1.add(pane, 0, 4);

//To change body of generated methods, choose Tools | Templates.
                }
            });

            test1.add(testButton, i, 0);

        }

        Scene scene = new Scene(test1, 900, 900);

        primaryStage.setTitle("ConnectFour");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
