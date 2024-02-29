package entity;
import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;

import java.io.*;
import java.awt.*;
import renderer.*;
import src.main.MainRenderer;
import util.Console;
import java.util.Random;

import static src.entity.Player.i;
import static src.main.Main.lives;
import static src.main.MainRenderer.*;
import static main.MainLogic.enemyCount;
public class Flipper extends Entity {
    public src.entity.ID id = src.entity.ID.Flipper;
    double t = 0;
    public int h;
    Camera camera;
    MainRenderer renderer;
    public Flipper(Model model, Vector3 position, EntityHandler entityHandler, Camera camera, double angle,int s, MainRenderer mainrenderer) {
        super(model, position, entityHandler);
        h = s;
        this.renderer=renderer;
        if(isClosed1){
        velocity = new Vector3(0, 0, -0.22);}
        if(!isClosed1){
        velocity = new Vector3(0, 0, -0.4);}
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
            t++;
            if(t%120==0){
                if(isClosed1==false){
                    model.move(new Vector3(-position.x,-position.y,0));
  //                  position.x*=-1;
//position.y*=-1;
                    position.z=0;

                    //model.move(position);
                    if(h>i && h!=0) {
                        model.rotate(2,2*Math.PI-angle_.get(h));
                        h--;


                        model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                        model.rotate(2,angle_.get(h));

                    }
                    else if(h>i && h==0) {
                        model.rotate(2,2*Math.PI-angle_.get(h));
                        h++;


                        model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                        model.rotate(2,angle_.get(h));

                    }
                    else if(h<i && h!=tunelwx.size()-1) {
                        model.rotate(2,2*Math.PI-angle_.get(h));
                        h++;

                        model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                        model.rotate(2,angle_.get(h));

                    }
                    else if(h<i && h==tunelwx.size()-1) {
                        model.rotate(2,2*Math.PI-angle_.get(h));
                        h--;

                        model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                        model.rotate(2,angle_.get(h));

                    }

                    position.x=tunelwx.get(h);
                    position.y=tunelwy.get(h);
                    model.updateVerticies();
                }
                    else if(isClosed1==true){
                        model.move(new Vector3(-position.x,-position.y,0));
                        //                  position.x*=-1;
//position.y*=-1;
                        position.z=0;

                        //model.move(position);
                        if(Math.abs(h-i)>Math.abs(i-h)) {
                            model.rotate(2,2*Math.PI-angle_.get(h));
                            if(h==0){
                                h=tunelwx.size()-1;
                            }
                            else{
                                h--;
                            }




                            model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                            model.rotate(2,angle_.get(h));

                        }
                        else if(Math.abs(h-i)<=Math.abs(i-h)) {
                            model.rotate(2,2*Math.PI-angle_.get(h));
                            if(h==0){
                                h=tunelwx.size()-1;
                            }
                            else{
                                h--;
                            }
                           // model.rotate(2,2*Math.PI-angle_.get(h));



                            model.move(new Vector3(tunelwx.get(h),tunelwy.get(h),0));
                            model.rotate(2,angle_.get(h));

                        }


                    position.x=tunelwx.get(h);
                    position.y=tunelwy.get(h);
                    model.updateVerticies();
                    }


            }

        }
        model.updateVerticies();
        position.z+=velocity.z;
        model.move(velocity);
        //Console.log(position.z);
        model.updateVerticies();
        updateHitbox();

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            if (entityHandler.entities.get(i) != this) {
                if (collision(entityHandler.entities.get(i).hitbox)) {
                    if(entityHandler.entities.get(i).getClass()== src.entity.Bullet1.class) {
                        entityHandler.entities.get(i).model.remove(((MainRenderer)camera.renderer).triangles);
                        entityHandler.entities.remove(entityHandler.entities.get(i));
                        model.remove(((MainRenderer)camera.renderer).triangles);
                        entityHandler.entities.remove(this);
                        enemyCount--;
                        Console.log(enemyCount);
                    }
                    else if(entityHandler.entities.get(i).getClass()== src.entity.Player.class) {
                        lives--;
                        Console.log(lives);
                        //entityHandler.entities.get(i).model.remove(((MainRenderer)camera.renderer).triangles);
                        //entityHandler.entities.remove(entityHandler.entities.get(i));
                        model.remove(((MainRenderer)camera.renderer).triangles);
                        entityHandler.entities.remove(this);
                        enemyCount--;
                        Console.log(enemyCount);
                    }
                }
            }
        }

    }
}