package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;
import util.Console;

import static src.main.MainRenderer.*;

public class Bullet1 extends Entity {
    public ID id = ID.Bullet1;
    MainRenderer renderer;

    public Bullet1(Model model, Vector3 position, EntityHandler entityHandler, MainRenderer renderer){


        super(model, position, entityHandler);
        int i =0;
        this.renderer = renderer;
        velocity = new Vector3(0,0,2);
        model.scale(2,0.3);
        model.scale(Math.PI/10);
        //model.updateVerticies();
        //model.rotate(2,Math.PI);
        //model.rotate(0,-Math.PI/2);
        model.rotate(2,Math.PI/2);
        model.updateVerticies();
    }
    int lifetime=0;
    public void logic() {
        lifetime++;
        updateHitbox();
        if (lifetime >= 60 * 0.4) {
            model.remove(renderer.triangles);
            entityHandler.entities.remove(this);

        }
        position.add(velocity);
        model.move(velocity);
        model.updateVerticies();
        //Console.log("sex");
        //Console.log(velocity);

    }
}
