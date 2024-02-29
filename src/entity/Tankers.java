package entity;

import maths.Vector3;
import renderer.Camera;
import renderer.LoadModel;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import java.awt.*;
import java.io.File;

import static main.MainLogic.enemyCount;
import static src.entity.Player.i;
import static src.main.Main.lives;
import static src.main.MainRenderer.*;

public class Tankers extends Entity {
    public src.entity.ID id = src.entity.ID.Flipper;
    double t = 0;
    public int h;
    public static boolean hasImmunity=false;
    Camera camera;
    MainRenderer renderer;
    public Tankers(Model model, Vector3 position, EntityHandler entityHandler, Camera camera, double angle, int s, MainRenderer mainrenderer) {
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

    int g=0;

    public void logic() {
        g++;
        if (position.z<13){
            velocity=new Vector3(0,0,0);
            t++;

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
                        enemyCount++;
                        String classPath = getClass().getResource("").getPath();
                        Flipper flipper = new Flipper(LoadModel.loadModel(new File(classPath + "/enemy2.model"), Color.white, camera.renderer, camera), new Vector3(tunelwx.get(h-1), tunelwy.get(h-1), 40), entityHandler, camera, angle_.get(h-1), h-1, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
                        Flipper flipper1 = new Flipper(LoadModel.loadModel(new File(classPath + "/enemy2.model"), Color.white, camera.renderer, camera), new Vector3(tunelwx.get(h+1), tunelwy.get(h+1), 40), entityHandler, camera, angle_.get(h+1), h+1, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
                        entityHandler.entities.add(flipper);
                        entityHandler.entities.add(flipper1);
                        flipper.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                        flipper1.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                        //Console.log(enemyCount);
                    }
                    else if(entityHandler.entities.get(i).getClass()== Bullet3.class) {

                        //entityHandler.entities.get(i).model.remove(((MainRenderer)camera.renderer).triangles);
                        //entityHandler.entities.remove(entityHandler.entities.get(i));
                        model.remove(((MainRenderer)camera.renderer).triangles);
                        entityHandler.entities.remove(this);
                        enemyCount--;
                        //Console.log(enemyCount);
                    }
                }
            }
        }

    }
}