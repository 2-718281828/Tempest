package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import static src.main.MainRenderer.isNewTunel;

public class Rectangle extends Entity {
            public ID id = ID.Rectangle;
            MainRenderer renderer;

            public Rectangle(Model model, Vector3 position, EntityHandler entityHandler, double angle, double N, MainRenderer renderer){
                super(model, position, entityHandler);
                this.renderer = renderer;
                velocity = new Vector3(0, 0, 0);
                model.move(position);
                //Vector3 axis = new Vector3(position.x,position.y+1/(N*Math.tan(Math.PI/N)),position.z);
                model.rotate(2,(angle+Math.PI/2));
                position.x=position.x+(Math.cos(angle)/(2*Math.tan(Math.PI/(N))));
                position.y=position.y+(Math.sin(angle)/(2*Math.tan(Math.PI/(N))));

                model.move(position);
                //model.rotate(0,Math.PI/2);
                model.updateVerticies();
                //model.scale(2,0.5);
            }
            double t = 0;

        public void logic () {
                /*/velocity.x =((Math.sin(t))/5)*(-1);
                 position.add(velocity);
                model.move(velocity);/*/
                t++;
                if(t%1500==0){
                    isNewTunel =true;
                }
                if (isNewTunel){
                    model.remove(renderer.triangles);
                    entityHandler.entities.remove(this);
                }
                //position.x(2222);
                //t-=0.0000002137;
            //while(t>2) {
            /*int sex=0;
            sex+=0.01;
            if(t>0.1){

                    double d = 0.89;
                    d+=sex/10;
                    model.scale(2, d);
                    model.updateVerticies();
                    Console.log("sex");
                    t = 0;


            }*/
        }
}