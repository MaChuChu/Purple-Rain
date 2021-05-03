/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purple.rain;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ranjeth
 */
public class RainDrop {

    double x, y, z, speedY, length, width;
    Rectangle shape;

    public RainDrop() {
        x = Math.random() * PurpleRain.screenW;
        y = -100 + (Math.random() * -200);
        z = Math.random() * 20;

        //length = 15 + (Math.random() * 25);
        length = map(z, 0, 20, 15, 25);
        
        width = map(z, 0, 20, 2, 6);

        //speedY = 4 + (Math.random() * 10);
        speedY = map(z,0,20,4,10);

        shape = new Rectangle(this.x, this.y, width, length);
        shape.setFill(Color.DARKSLATEBLUE);
        PurpleRain.root.getChildren().add(shape);
    }

    public void update() {
        y += speedY;
        
        double grav = map(z, 0, 20, 0 ,0.2);
        speedY += grav;

        if (y > PurpleRain.screenH) {
            y = Math.random() * -200;
            //speedY = 4 + (Math.random() * 10);
            speedY = map(z,0,20,4,10);
        }

        shape.setY(y);
    }

    static public final double map(double value, double istart, double istop, double ostart, double ostop) {
        return ostart + (ostop - ostart) * ((value - istart) / (istop - istart));
    }

}
