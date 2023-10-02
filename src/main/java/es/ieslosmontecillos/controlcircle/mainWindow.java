package es.ieslosmontecillos.controlcircle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class mainWindow extends Application {
    Circle circle = new Circle(50);


    @Override
    public void start(Stage primaryStage){

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setBottom(hBox);


        //Creacion de botones
        Button btnEnlarg = new Button("Enlarge");
        Button btnShr = new Button("Shrink");

        hBox.getChildren().add(btnEnlarg);
        hBox.getChildren().add(btnShr);

        //Creacion del circulo

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        borderPane.setCenter(circle);
        borderPane.setBottom(hBox);

        btnEnlarg.setOnAction(new EnlargeHandler());
        btnShr.setOnAction(new ShrinkHandler());


        Scene scene = new Scene(borderPane, 300, 200);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void enlarge(){
        if(circle.getRadius() <= 70)
            circle.setRadius(circle.getRadius() + 2);
    }

    public void shrink(){
        if(circle.getRadius() >= 20)
            circle.setRadius(circle.getRadius() - 2);
    }

    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            enlarge();
        }
    }

    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override // Override the handle method
        public void handle(ActionEvent e) {
            shrink();
        }

    }

    public static void main(String[] args) {
        launch();
    }


}