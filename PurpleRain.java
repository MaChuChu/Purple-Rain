/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purple.rain;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Ranjeth
 */
public class PurpleRain extends Application {
    
    public static int screenW = 1000, screenH = 600;
    public static Group root;
    
    RainDrop temp[] = new RainDrop[100];
    
    @Override
    public void start(Stage primaryStage) {
               
        root = new Group();
               
        Scene scene = new Scene(root, screenW, screenH);
        scene.setFill(Color.BLACK);
        
        draw();
        
        animation();
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void draw(){
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new RainDrop();
        }
    }
    
    public void animation(){
        new AnimationTimer() {
            @Override
            public void handle(long now) {

                for (RainDrop drop : temp) {
                    drop.update();
                }
            }


         }.start();
    }
}
