package Modelo;

import java.util.ArrayList;

public interface IJugador {
    ArrayList<Carta> getMazo_jugador();

    void recibir_carta(Carta carta1);

    Carta tirar_carta(int i);

    String getNombre();

    int getPuntaje();

    void incrementar_puntaje(int puntaje);

    ArrayList<Carta> getBazasGanadas();

    void setBazasGanadas(ArrayList<Carta> bazasGanadas1);
}
