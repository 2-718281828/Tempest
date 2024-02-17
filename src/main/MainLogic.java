package main;

import engine.*;
import renderer.*;

public class MainLogic implements Logic {

    public Camera camera; // ten obiekt jest publiczny dla całej klasy i innych klas mających dostęp do tej klasy

    public MainLogic(Camera camera) {
        this.camera = camera; // this.camera odnosi się do kamery publicznej dla całej klasy, a camera jest dostępna tylko dla tego konstruktora, dlatego chcemy "upublicznić" kamerę, żeby móc z niej korzystać w innych funkcjach
    }

    public void update() {
        camera.update(); // aktualizacja kamery
    }

}