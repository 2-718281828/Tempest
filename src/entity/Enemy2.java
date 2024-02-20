package src.entity;

import entity.Entity;
import entity.EntityHandler;
import maths.Vector3;
import renderer.Model;


    public class Enemy2 extends Entity {
        public ID id = ID.Enemy2;
        public boolean[] keys = new boolean[4];
        public Enemy2(Model model, Vector3 position, EntityHandler entityHandler){
            super(model, position, entityHandler);
            velocity = new Vector3(0, 0, 0);
            model.move(position);
            model.updateVerticies();
            model.rotate(2,Math.PI);
            model.rotate(1,-Math.PI/2);
        }
        double t = 0;
        double theta = 0;
        double s = 0.01;
        public void logic () {

//            if(){
//
//            }
            velocity.x = 0;
            velocity.y = 0;
            if(keys[2]){
                theta += 0.1;
                model.rotate(2,-0.1);
            }
            else if(keys[3]){
                theta -= 0.1;
                model.rotate(2,0.1);
            }

            if(keys[0]){ //w gore
                velocity.y =  s * Math.cos(theta);
                velocity.x =  s * Math.sin(theta);
            }
            else if(keys[1]){
                velocity.y = -s * Math.cos(theta)/2;
                velocity.x = -s * Math.sin(theta)/2;
            }
            model.updateVerticies();
            position.add(velocity);
            model.move(velocity);

//            model.updateVerticies();
//            position.add(velocity);
//            model.move(velocity);
//            double fgh = Math.sin(t)/5;
//            double ggh = Math.cos(t)/5;
//            velocity.x =(Math.sin(t))/2;
//            velocity.z=Math.cos(t)*fgh/2;
//            velocity.y=fgh*ggh*100;
//            model.rotate(0,fgh);
//            model.rotate(1,fgh/ggh);
//            model.rotate(2,ggh);
//            position.add(velocity);
//            model.move(velocity);
//            model.updateVerticies();
            t =t+0.01;

        }
    }

