package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import util.Console;

import java.util.*;

    public class Player extends Entity {

        public ID id = ID.Player;
        public boolean[] keys = new boolean[4];
        public Player(Model model, Vector3 position, EntityHandler entityHandler, ArrayList<Double> tunelwx,ArrayList<Double> tunelwy,ArrayList<Double> angle, boolean isClosed){


            super(model, position, entityHandler);
            int i =0;
            isClosed1=isClosed;
            tunelwx1=tunelwx;
            tunelwy1=tunelwy;
            angle1=angle;
            velocity = new Vector3(0, 0, 0);
            position.x = tunelwx.get(0);
            position.y=tunelwy.get(0);
            model.move(position);

            model.scale(0.5);
            model.updateVerticies();
            //model.rotate(2,Math.PI);
            model.rotate(0,-Math.PI/2);
            model.rotate(2,(angle.get(0))+Math.PI/2);
            model.updateVerticies();
        }

        double t = 0;
        public boolean isClosed1;
        public ArrayList<Double> tunelwx1 = new ArrayList<Double>();
        public ArrayList<Double> tunelwy1 = new ArrayList<Double>();
        public ArrayList<Double> angle1 = new ArrayList<Double>();
        double theta = 0;
        double s = 0.01;
        int i =0;
        public void logic () {
            if (t%3==0){
            if(keys[2]) {

                if (isClosed1 == true && i == tunelwx1.size() - 1) {
                    i = 0;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx1.get(i);
                    position.y= tunelwy1.get(i);
                    position.z=0;
                    model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle1.get(i));
                    model.move(position);
                    model.updateVerticies();
                    Console.log("A");

                } else if (i != tunelwx1.size() - 1) {
                    i++;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx1.get(i);
                    position.y= tunelwy1.get(i);
                    position.z=0;
                    model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle1.get(i));
                    model.move(position);
                    model.updateVerticies();
                    Console.log("a");
                }
            }
            else if(keys[3]){
                if (isClosed1==true && i==0){
                    i=tunelwx1.size()-1;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx1.get(i);
                    position.y= tunelwy1.get(i);
                    position.z=0;
                    model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle1.get(i));
                    model.move(position);
                    model.updateVerticies();
                    Console.log("a");

                }
                else if (i!=0){
                    i--;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx1.get(i);
                    position.y= tunelwy1.get(i);
                    position.z=0;
                    model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle1.get(i));
                    model.move(position);
                    model.updateVerticies();
                    Console.log("a");
                }
            }}
            t++;

        }
    }

