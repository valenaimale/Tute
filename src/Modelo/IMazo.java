package Modelo;

import java.util.ArrayList;

public interface IMazo {
    void setMazo(Carta carta);

    void mezclate();

    ArrayList<Carta> getMazo();
}
