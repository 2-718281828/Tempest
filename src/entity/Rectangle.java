package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import static src.main.MainLogic.enemyCount;
import static src.main.MainRenderer.isNewTunel;

public class Rectangle extends Entity {
            public ID id = ID.Rectangle;
            MainRenderer renderer;

            public Rectangle(Model model, Vector3 position, EntityHandler entityHandler, double angle, double N, MainRenderer renderer){
                super(model, position, entityHandler);
                this.renderer = renderer;
                velocity = new Vector3(0, 0, 0);
                model.move(velocity);
                //Vector3 axis = new Vector3(position.x,position.y+1/(N*Math.tan(Math.PI/N)),position.z);
                model.rotate(2,(angle+Math.PI/2));

                //position.x=position.x+(Math.cos(angle)/(2*Math.tan(Math.PI/(N))));
                //position.y=position.y+(Math.sin(angle)/(2*Math.tan(Math.PI/(N))));

                //model.move(position); NIENAWIDZE CHEMI ORGANICZNEJ NIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJ

                //model.rotate(0,Math.PI/2);
                model.updateVerticies();
                //model.scale(2,0.5);s mam jutro sprawdzan z historii i terazniejszosci na ktory sie nie przygotowalem :c moze 2 bedzie
                //You are listening to: AndrekM's code
            }
            double t = 0;

        public void logic () {
                /*/velocity.x =((Math.sin(t))/5)*(-1);
                 position.add(velocity);
                model.move(velocity);/*/
                t++;
                if(t>240){

                    if(t%10==0){
                        model.scale(2,0.7);}
                    if(t%300==0){
                    enemyCount--;}
                }
                if(enemyCount==0 && t>120){
                    isNewTunel =true;
                    model.remove(renderer.triangles);
                    entityHandler.entities.remove(this);
                    //if(t%10==0){
                    //model.scale(2,0.7);
                    //model.move(new Vector3(0,0,-position.z*.7));

                    //t=0;
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