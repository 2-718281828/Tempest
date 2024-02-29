package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import static src.entity.Player.i;
import static main.MainLogic.enemyCount;
import static src.main.MainRenderer.*;

public class Rectangle2 extends Entity {
            public src.entity.ID id = src.entity.ID.Rectangle2;
            int oi=0; //obecnie i
            public double lastAngle=angle_.get(oi);
            MainRenderer renderer;
           // public static double iloscrectangli1;

            public Rectangle2(Model model, Vector3 position, EntityHandler entityHandler, double angle, MainRenderer renderer){
                super(model, position, entityHandler);
                this.renderer = renderer;
                velocity = new Vector3(0, 0, 0);
                model.move(velocity);
                //iloscrectangli=N;
                //Vector3 axis = new Vector3(position.x,position.y+1/(N*Math.tan(Math.PI/N)),position.z);
                model.rotate(2,(angle)-Math.PI/2);


                //position.x=position.x+(Math.cos(angle)/(2*Math.tan(Math.PI/(N))));
                //position.y=position.y+(Math.sin(angle)/(2*Math.tan(Math.PI/(N))));


                //model.rotate(2,Math.PI/2);
                model.updateVerticies();
                //ruslan zrobil 3 JEBANE TUNELE W 2 DNI, SZYMON W 20 MINUT ZTOBIL 2 TUNELE KURWA JAK
            }
            double t = 0;

        public void logic (){
                t++;
                Console.log("ilosc");
                Console.log(enemyCount);
                if(enemyCount==0 || oi>tunelwx.size()-1){
                    Console.log("SEX");
                    entityHandler.entities.remove(this);
                    model.remove(MainRenderer.triangles);
                }
                if(oi!=i && enemyCount!=0 && oi<=tunelwx.size()-1){
                    lastAngle=angle_.get(oi);
                    model.rotate(2,(2*Math.PI)-lastAngle);
                    position.x*=-1;
                    position.y*=-1;
                    position.z=0;
                    model.move(position);
                    position.x= tunelwx.get(i)+0.002*Math.sin(angle_.get(i));
                    position.y= tunelwy.get(i)+0.02*Math.cos(angle_.get(i));
                    position.z=0;
                    //model.rotate(2,(2*Math.PI)-rotation);
                    model.rotate(2,angle_.get(i));
                    model.move(position);
                    model.updateVerticies();

                    oi=i;
                }


                //Console.log("A");}
}
                }