package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import java.util.*;

import static src.main.MainLogic.enemyCount;
import static src.main.MainRenderer.*;

public class Player extends Entity {

        public ID id = ID.Player;
        public double defaultAngle;
        public static boolean[] keys = new boolean[4];
        MainRenderer renderer;
        public Player(Model model, Vector3 position, EntityHandler entityHandler, MainRenderer renderer){


            super(model, position, entityHandler);
            this.renderer = renderer;
            velocity = new Vector3(0, 0, 0);
            position.x = tunelwx.get(0);
            position.y=tunelwy.get(0);
            model.move(position);

            model.scale(0.5);
            model.updateVerticies();
            //model.rotate(2,Math.PI);
            model.rotate(0,-Math.PI/2);
            model.rotate(2,(angle_.get(0))+Math.PI/2);

            model.updateVerticies();
        }

        double t = 0;


        public static int i =0;
        public void logic () {
            if (t%3==0){
                //niech ten komentarz będzie przestrogą dla przyszlych programistów: Ilość spędzonych godzin na probie zrobienia dzialajacego obrtacania: 2 DZIAŁA DZIALA DZIALA DZIAL DZIALA DZIALA DZIAL DZIALA DZIALA DZIAL DZIALA DZIALA DIALA
            if(keys[2]) {

                if (isClosed1  && i == tunelwx.size() - 1) {
                    model.rotate(2,(2*Math.PI)-angle_.get(i));
                    i = 0;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx.get(i);
                    position.y= tunelwy.get(i);
                    position.z=0;
                    //model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle_.get(i));
                    model.move(position);
                    model.updateVerticies();
                    //Console.log("A");

                } else if (i != tunelwx.size() - 1) {
                    model.rotate(2,(2*Math.PI)-angle_.get(i));
                    i++;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx.get(i);
                    position.y= tunelwy.get(i);
                    position.z=0;



                    model.rotate(2,angle_.get(i));
                    model.move(position);
                    model.updateVerticies();
                    //Console.log("a");
                }
            }
            else if(keys[3]){
                if (isClosed1 && i==0){
                    model.rotate(2,(2*Math.PI)-angle_.get(i));
                    i=tunelwx.size()-1;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx.get(i);
                    position.y= tunelwy.get(i);
                    position.z=0;
                    //model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle_.get(i));
                    model.move(position);
                    model.updateVerticies();
                    //Console.log("a");

                }
                else if (i!=0){
                    model.rotate(2,(2*Math.PI)-angle_.get(i));
                    i--;
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx.get(i);
                    position.y= tunelwy.get(i);
                    position.z=0;
                    //model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle_.get(i));
                    model.move(position);
                    model.updateVerticies();
                    //Console.log("a");
                }

            }}
            t++;

            if(enemyCount==0){
                i=0;
                Console.log("JMGMD");
                entityHandler.entities.remove(this);
                model.remove(MainRenderer.triangles);


            }
        }
    }

