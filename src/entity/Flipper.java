package src.entity;
import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;

import java.io.*;
import java.awt.*;
import renderer.*;
import util.Console;
import java.util.Random;

public class Flipper extends Entity {
    public ID id = ID.Flipper;
    double t = 0;
    Camera camera;

    public Flipper(Model model, Vector3 position, EntityHandler entityHandler, Camera camera, double angle) {
        super(model, position, entityHandler);
        velocity = new Vector3(0, 0, -0.2);
        //model.rotate(0,Math.PI/2);
        model.rotate(2,angle-Math.PI/2);
        //model.rotate(0,Math.PI/2);
        model.scale(0.5);
        model.updateVerticies();
        this.camera = camera;

    }


    public void logic() {
        if (position.z<8){
            velocity=new Vector3(0,0,0);
            Console.log("sex");
        }
        position.z+=velocity.z;
        model.move(velocity);
        //Console.log(position.z);
        model.updateVerticies();
    }
}