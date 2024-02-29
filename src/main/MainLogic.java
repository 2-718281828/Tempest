package main;
import src.entity.Bullet1;
import entity.Flipper;
import src.entity.Rectangle;
import src.entity.Player;
import engine.*;
import entity.*;
import maths.Vector3;
import renderer.*;
import util.Console;
import java.awt.*;
import java.io.File;
import java.util.Random;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static java.awt.Color.pink;
import static src.entity.ID.Rectangle;
import static src.entity.Player.i;
import static src.main.MainRenderer.*;
//import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

public class MainLogic implements Logic {
    public EntityHandler entityHandler;
    public Camera camera;
    public static double enemyCount;
    String classPath = getClass().getResource("").getPath();
    //public Triangles triangles;
    Random random = new Random();
    // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy
    //public EntityHandler entityHandler;

    public MainLogic(Camera camera, EntityHandler entityHandler) {
        this.camera = camera;
        this.entityHandler = entityHandler;

        for (int i = 0; i < entityHandler.entities.size(); i++) {
            entityHandler.entities.get(i).model.init(((src.main.MainRenderer) camera.renderer).triangles);
        }
        double N = 14;
        //boolean isClosed1=true;
        for (double i = 0; i < N; i++) {
            tunelwx.add(Math.cos(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
            tunelwy.add(Math.sin(2 * Math.PI * (i / N)) / (2 * Math.tan(Math.PI / (N))));
            angle_.add(2 * Math.PI * (i / N));
        }


    }

    public double t = 0;
    public int timeFlippers = 69;
    public int timeTankers = 90;
    public int ifl = 0; //ilosc flippers
    public int it = 0;
    public int is = 0; //ilsoc spikers
    public int ifu = 0; //ilsoc fuseballs
    public int level = 0;
    public int oifl = 0;
    public int oit = 0;
    public int ois = 0;
    public int oifu = 0;
    public int M;
    public int superZapper=0;
    static double d135 = 3 * (Math.PI / 4);
    static double d90 = Math.PI / 2;
    static double d45 = Math.PI / 4;
    static double d0 = 0.0;

    public void update() {
        if (whichTunel == 16) {
            whichTunel = 0; //16 tuneli
        }
        t++;
        if (t % 2 == 0) {
            if (Player.keys[0]) {
                Bullet1 bullet1 = new Bullet1(LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.red, camera.renderer, camera), new Vector3(tunelwx.get(i), tunelwy.get(i), 7.8), entityHandler, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
                entityHandler.entities.add(bullet1);
                bullet1.model.init(((src.main.MainRenderer) camera.renderer).triangles);
            }
        }
        if (Player.keys[1] &&superZapper!=0) {
            superZapper--;
            Bullet3 bullet3 = new Bullet3(LoadModel.loadModel(new File(classPath + "/monkey.model"), Color.black, camera.renderer, camera), new Vector3(tunelwx.get(i), tunelwy.get(i), 7.8), entityHandler, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
            entityHandler.entities.add(bullet3);
            bullet3.model.init(((src.main.MainRenderer) camera.renderer).triangles);
        }
        camera.update();
        ((src.main.MainRenderer) camera.renderer).entityHandler.logic();
        if (isNewTunel) {
            superZapper++;

            tunelwx.clear();
            tunelwy.clear();
            angle_.clear();
            level++;
            //enemyCount=1;

            if (whichTunel == 0) {
                double N = 14;
                M = (int) N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add(Math.cos(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))));
                    tunelwy.add(Math.sin(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))));
                    angle_.add(2 * Math.PI * (d / N));

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(Math.cos(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))), Math.sin(2 * Math.PI * (d / N)) / (2 * Math.tan(Math.PI / (N))), 30), entityHandler, 2 * Math.PI * (d / N), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    //Console.log("SEX");
                    //Console.log(angle_); sam juz nie rozumiem jak to działa ale działą czyli jest git,szkoda ze jako jedyny pisze (subiektywnie) najtrudniejsza gre 2 dni przed dedlinem >_< (23:38 27.02.2024)
                }


                isClosed1 = true;
                //enemyCount++;
                //whichTunel++;
            } else if (whichTunel == 1) {
                double N = 10;
                M = (int) N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add(-5 + 1 * d);
                    tunelwy.add(-2.0);
                    angle_.add(Math.PI / 2);

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3(-5 + 1 * d, -2, 30), entityHandler, Math.PI / 2, N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);

                }

                isClosed1 = false;


            } else if (whichTunel == 2) {
                double N = 14;
                M = (int) N;
                //boolean isClosed1=true;
                for (double d = 0; d < N; d++) {
                    tunelwx.add((-7 / Math.sqrt(2) + d / Math.sqrt(2))/*1/Math.sin(Math.PI/4)*/);
                    tunelwy.add(-2.0 + 1 / Math.cos(Math.PI / 4));
                    angle_.add(Math.PI * Math.pow((-1), d) / 4);

                    Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                            new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                            new Vector3((((-7 / Math.sqrt(2) + d / Math.sqrt(2)))), -2.0 + 1 / Math.cos(Math.PI / 4), 30), entityHandler, Math.PI * Math.pow((-1), d) / 4, N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler
                    entityHandler.entities.add(rectangle);
                    rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                }
                isClosed1 = false;
            } else if (whichTunel == 3) //Trzeci tunel
            {
                double N = 16;
                M = (int) N;
                //1
                tunelwx.add(0.5);
                tunelwy.add(1.0);
                angle_.add(Math.PI / 2.0);
                //2
                tunelwx.add(1.0);
                tunelwy.add(0.5);
                angle_.add(0.0);
                //3
                tunelwx.add(1.5);
                tunelwy.add(0.0);
                angle_.add(Math.PI / 2.0);
                //4
                tunelwx.add(2.0);
                tunelwy.add(-0.5);
                angle_.add(0.0);
                //5
                tunelwx.add(2.0);
                tunelwy.add(-1.5);
                angle_.add(0.0);
                //6
                tunelwx.add(1.5);
                tunelwy.add(-2.0);
                angle_.add(Math.PI / 2.0);
                //7
                tunelwx.add(1.0);
                tunelwy.add(-2.5);
                angle_.add(0.0);
                //8
                tunelwx.add(0.5);
                tunelwy.add(-3.0);
                angle_.add(Math.PI / 2.0);
                //9
                tunelwx.add(-0.5);
                tunelwy.add(-3.0);
                angle_.add(Math.PI / 2.0);
                //10
                tunelwx.add(-1.0);
                tunelwy.add(-2.5);
                angle_.add(0.0);
                //11
                tunelwx.add(-1.5);
                tunelwy.add(-2.0);
                angle_.add(Math.PI / 2.0);
                //12
                tunelwx.add(-2.0);
                tunelwy.add(-1.5);
                angle_.add(0.0);
                //13
                tunelwx.add(-2.0);
                tunelwy.add(-0.5);
                angle_.add(0.0);
                //14
                tunelwx.add(-1.5);
                tunelwy.add(0.0);
                angle_.add(Math.PI / 2.0);
                //15
                tunelwx.add(-1.0);
                tunelwy.add(0.5);
                angle_.add(0.0);
                //16
                tunelwx.add(-0.5);
                tunelwy.add(1.0);
                angle_.add(Math.PI / 2.0);

                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = true;
                }
            } else if (whichTunel == 4) //Czwarty tunel
            {
                double N = 20;
                M = (int) N;
                double[] x = {0.0, 0.5, 1.0, 1.5, 2.0, 2.5, 2.0, 1.5, 1.0, 0.5, 0.0, -0.5, -1, -1.5, -2.0, -2.5, -2, -1.5, -1, -0.5};
                double[] y = {0.5, 1.0, 1.5, 1.0, 0.5, 0.0, -0.5, -1.0, -1.5, -1.0, -0.5, -1.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 1.0};
                double[] angle = {d90, d0, d90, d0, d90, d0, d90, d0, d90, d0, d90, d0, d90, d0, d90, d0, d90, d0, d90, d0};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = true;
                }
            } else if (whichTunel == 5) //Piąty tunel
            {
                double N = 18;
                M = (int) N;
                double[] x = {0.5, 1.5, 2.5, 3.5, 4.0, 3.5, 2.5, 1.5, 0.5, -0.5, -1.5, -2.5, -3.5, -4.0, -3.5, -2.5, -1.5, -0.5};
                double[] y = {1.0, 1.5, 1.5, 1.0, 0.0, -1.0, -1.5, -1.5, -1.0, -1.0, -1.5, -1.5, -1.0, -0.0, 1.0, 1.5, 1.5, 1.0};
                double[] angle = {d135, d90, d90, d45, d0, d135, d90, d90, d45, d135, d90, d90, d45, d0, d135, d90, d90, d45};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = true;
                }
            } else if (whichTunel == 6) //Szósty tunel
            {
                double N = 18;
                M = (int) N;
                double[] x = {0.5, 1.5, 2.5, 3.5, 4.0, 3.5, 2.5, 1.5, 0.5, -0.5, -1.5, -2.5, -3.5, -4.0, -3.5, -2.5, -1.5, -0.5};
                double[] y = {1.5, 1.5, 1.5, 1.0, 0.0, -1.0, -1.5, -1.5, -1.5, -1.5, -1.5, -1.5, -1.0, 0.0, 1.0, 1.5, 1.5, 1.5};
                double[] angle = {d90, d90, d90, d45, d0, d135, d90, d90, d90, d90, d90, d90, d45, d0, d135, d90, d90, d90};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = true;
                }
            } else if (whichTunel == 7) {
                double N = 6;
                M = (int) N;
                double[] x = { -1.775, -1.065,-0.355, 0.355, 1.065, 1.775};
                double[] y = {0.71, -0.0, -0.71, -0.71, -0.0, 0.71};
                double[] angle = {d45, d45, d45,d135, d135, d135};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = false;
                }
            } else if (whichTunel == 8) {
                double N = 6;
                M = (int) N;
                double[] x = {-1.775, -1.065,-0.355, 0.355, 1.065, 1.775};
                double[] y = {-0.71, -0.0, 0.71, 0.71, -0.0, -0.71};
                double[] angle = {d135, d135, d135,d45, d45, d45};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = false;
                }


            } else if (whichTunel == 9) {
                double N = 6;
                M = (int) N;
                double[] x = {0.355, 0.71, 1.065, -0.355, -0.71, -1.065};
                double[] y = {-0.71, -0.0, 0.71, -0.71, -0.0, 0.71};
                double[] angle = {d45, d45, d45, d45, d45, d45,};
                for (int l = 0; l < N; l++) {
                    tunelwx.add(x[l]);
                    tunelwy.add(y[l]);
                    angle_.add(angle[l]);
                }
                for (double d = 0; d < N; d++) {

                    for (int q = 0; q < N; q++) {
                        Rectangle rectangle = (new Rectangle(LoadModel.loadModel(
                                new File(classPath + "/tunel2.model"), new Color(26, 53, 183), camera.renderer, camera),
                                new Vector3(tunelwx.get(q), tunelwy.get(q), 30), entityHandler, angle_.get(q), N, ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

                        entityHandler.entities.add(rectangle);
                        rectangle.model.init(((src.main.MainRenderer) camera.renderer).triangles);
                    }
                    isClosed1 = false;
                }




            }
            enemyCount = (int) Math.round(16 * Math.exp(level / 69));

            whichTunel++;
            Player player = new Player(LoadModel.loadModel(new File(classPath + "/enemy2.model"), new Color(255, 213, 0), camera.renderer, camera), new Vector3(0, 0, 4), entityHandler, ((src.main.MainRenderer) camera.renderer), camera);


            entityHandler.entities.add(player);
            src.entity.Rectangle2 rectangle2 = (new src.entity.Rectangle2(LoadModel.loadModel(
                    new File(classPath + "/tunel2.model"), new Color(255, 213, 0), camera.renderer, camera),
                    new Vector3(tunelwx.get(0)+0.02*Math.sin(angle_.get(0)), tunelwy.get(0)+0.02*Math.cos(angle_.get(0)), 30), entityHandler, angle_.get(0), ((src.main.MainRenderer) camera.renderer)));//model, położenie, entityHandler

            entityHandler.entities.add(rectangle2);
            rectangle2.model.init(((src.main.MainRenderer) camera.renderer).triangles);
            src.main.KeyHandler keyHandler1 = new src.main.KeyHandler(player);
            camera.renderer.addKeyListener(keyHandler1);

            //triangles = new Triangles();
            player.model.init(src.main.MainRenderer.triangles);
            isNewTunel = false;
            if (level <= 2) {
                ifl = (int) enemyCount;
            } else if (level ==4) {
                Console.log("sex");
                ifl = (int) Math.round(0.8 * enemyCount);
                it = (int) enemyCount - ifl;
            } else if (level >4 && level<7) {
                ifl = (int) Math.round(0.67 * enemyCount);
                it = (int) Math.round(0.25 * enemyCount);
                is = (int) enemyCount - ifl - it;

            } else if (level > 7) {
                ifl = (int) Math.round(1.0 / 2 * enemyCount);
                it = (int) Math.round(1.0 / 6 * enemyCount);
                is = (int) Math.round(1.0 / 6.0 * enemyCount);
                ifu = (int) enemyCount - ifl - it - is;
            }
            oifl = 0;
            oit = 0;
            ois = 0;
            oifu = 0;

        }
        timeFlippers--;
        timeTankers--;
        if (oifl < ifl && timeFlippers == 0) {
            timeFlippers = 69 - random.nextInt(30);
            oifl++;
            int s = random.nextInt(M);
            Flipper flipper = new Flipper(LoadModel.loadModel(new File(classPath + "/enemy1.model"), Color.white, camera.renderer, camera), new Vector3(tunelwx.get(s), tunelwy.get(s), 40), entityHandler, camera, angle_.get(s), s, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
            entityHandler.entities.add(flipper);
            flipper.model.init(((src.main.MainRenderer) camera.renderer).triangles);
        }
        if (oit < it && timeTankers == 0) {
            timeTankers = 90 - random.nextInt(30);
            oit++;
            int s = random.nextInt(M);
            Tankers tanker = new Tankers(LoadModel.loadModel(new File(classPath + "/enemy1.model"), new Color(199, 38, 238, 255), camera.renderer, camera), new Vector3(tunelwx.get(s), tunelwy.get(s), 40), entityHandler, camera, angle_.get(s), s, ((src.main.MainRenderer) camera.renderer));//model, położenie, entityHandler
            entityHandler.entities.add(tanker);
            tanker.model.init(((src.main.MainRenderer) camera.renderer).triangles);
        }
    }
}