package it.unibo.javafx.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Controls Exercise!");
        final VBox mainPane = new VBox();
        final Counter counter = new Counter();

        final Label counterLabel = new Label("0");
        //counterLabel.setStyle("-fx-font-size: 24pt; -fx-padding: 10px;"); 

        final Button buttonIncrement = new Button("Incrementa");
        final Button buttonDecrement = new Button("Decrementa");

        counterLabel.textProperty().bind(counter.counterProperty().asString());

        // Listener per l'incremento
        buttonIncrement.setOnAction(e -> {
            counter.increment();
        });

        // Listener per il decremento
        buttonDecrement.setOnAction(e -> {
            counter.decrement();
        });

        // HBox per tenere i due pulsanti sulla stessa riga
        final HBox buttonBox = new HBox(10, buttonDecrement, buttonIncrement);
        buttonBox.setStyle("-fx-alignment: center;"); // Centra i pulsanti
        
        // Aggiungere gli elementi al pannello principale
        mainPane.getChildren().addAll(counterLabel, buttonBox);
        mainPane.setStyle("-fx-alignment: center; -fx-padding: 20px;");

        buttonIncrement.setMinWidth(100);
        buttonDecrement.setMinWidth(100);


        primaryStage.setScene(new Scene(mainPane));
        primaryStage.show();
    }

    public static class Main {
        public static void main(final String... args) {
            Application.launch(App.class, args);
        }
    }
}
