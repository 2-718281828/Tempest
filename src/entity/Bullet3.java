package entity;

import maths.Vector3;
import renderer.Model;
import src.main.MainRenderer;

public class Bullet3 extends Entity {
    public src.entity.ID id = src.entity.ID.Bullet3;
    MainRenderer renderer;

    public Bullet3(Model model, Vector3 position, EntityHandler entityHandler, MainRenderer renderer){


        super(model, position, entityHandler);

        this.renderer = renderer;

        velocity = new Vector3(0,0,1.6);
        model.scale(1000);

        //model.updateVerticies();
        //model.rotate(2,Math.PI);
        //model.rotate(0,-Math.PI/2);

        model.updateVerticies();
    }
    int lifetime=0;
    public void logic() {
        lifetime++;
        updateHitbox();
        if (lifetime >= 60 * 0.1) {
            model.remove(renderer.triangles);
            entityHandler.entities.remove(this);


        }
    }
}
