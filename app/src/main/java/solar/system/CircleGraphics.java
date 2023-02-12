package solar.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CircleGraphics extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(250, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(75, 75, 100, 100);
        VBox box = new VBox();
        box.getChildren().addAll(canvas);
        Scene scene = new Scene(box, 250, 250);
        primaryStage.setTitle("title");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
