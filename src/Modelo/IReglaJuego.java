package Modelo;

import java.util.ArrayList;

public interface IReglaJuego {
    int determinar_tantos(ArrayList<Carta> bazasGanadasXJug);

    Boolean determinar_si_hay_ganador();

    Jugador determinar_quien_gano();
}
