package solar.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 1000;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        SolarSystem ss = new SolarSystem(canvas);
        ss.run();

        VBox box = new VBox();

        box.getChildren().addAll(canvas);
        Scene scene = new Scene(box, WIDTH, HEIGHT);
        String nameProject = "Solar System Simulator";
        primaryStage.setTitle(nameProject);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
