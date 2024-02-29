package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import static main.MainLogic.enemyCount;
import static src.main.MainRenderer.isNewTunel;

public class Rectangle extends Entity {
            public src.entity.ID id = src.entity.ID.Rectangle;
            MainRenderer renderer;
            public static double iloscrectangli;

            public Rectangle(Model model, Vector3 position, EntityHandler entityHandler, double angle, double N, MainRenderer renderer){
                super(model, position, entityHandler);
                this.renderer = renderer;
                velocity = new Vector3(0, 0, 0);
                model.move(velocity);
                iloscrectangli=N;
                //Vector3 axis = new Vector3(position.x,position.y+1/(N*Math.tan(Math.PI/N)),position.z);
                model.rotate(2,(angle));


                //position.x=position.x+(Math.cos(angle)/(2*Math.tan(Math.PI/(N))));
                //position.y=position.y+(Math.sin(angle)/(2*Math.tan(Math.PI/(N))));

                //model.move(position); NIENAWIDZE CHEMI ORGANICZNEJ NIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJNIENAWIDZE CHEMI ORGANICZNEJ

                model.rotate(2,Math.PI/2);
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

                /*if(t>240){

                    if(t%100==0){
                        model.scale(2,-0.7);}
                    if(t>3000){
                    enemyCount=0;}
                }*/
                if(enemyCount==0){
                    iloscrectangli--;
                    entityHandler.entities.remove(this);
                    model.remove(MainRenderer.triangles);

                    Console.log(iloscrectangli);
                    //if(t%10==0){
                    //model.scale(2,0.7);
                    //model.move(new Vector3(0,0,-position.z*.7));

                    //t=0;
                }

                if(iloscrectangli==0){

                    isNewTunel =true;
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