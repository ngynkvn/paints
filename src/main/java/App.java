import helpers.ImageCreator;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import algorithms.Pair;
import java.util.*;
import java.awt.*;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25,25,25,25));
        grid.setVgap(10);
        grid.setHgap(10);

        Label algoName = new Label("Algorithm:");
        grid.add(algoName,0,0);

        TextField algoField = new TextField();
        algoField.setMaxWidth(300);
        grid.add(algoField,1,0);

        WritableImage image = new WritableImage(256,256);
        Button start = new Button();
        start.setText("Start");
        start.setOnAction(
                event -> {
                    BufferedImage img = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
                    ImageCreator imageCreator = new ImageCreator(algoField.getText());
                    imageCreator.createImage(img);
                    ArrayList<Pair<Point,Integer>> order = imageCreator.getOrder();
                    PixelWriter pw = image.getPixelWriter();
                    for(int i = 0; i < 10000; i++){
                        Pair<Point,Integer> p = order.get(i);
                        pw.setArgb(p.first().x,p.first().y,p.second());
                    }
                }
        );
        grid.add(start,2,0);

        ImageView iv = new ImageView(image);
        grid.add(iv,0,1,3,1);

        Button pause = new Button();
        pause.setText("Pause");
        grid.add(pause,0,2);

        Button next = new Button();
        next.setText("Next");
        grid.add(next,1,2);

        Button export = new Button();
        export.setText("Save");
        export.setAlignment(Pos.BASELINE_LEFT);
        grid.add(export,2,2,2,1);


        Scene scene = new Scene(grid);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Paints");
        primaryStage.setScene(scene);
        primaryStage.show();

    //    grid.setGridLinesVisible(true);
    }
}
