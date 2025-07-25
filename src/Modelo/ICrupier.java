package Modelo;

import java.util.ArrayList;

public interface ICrupier {
    void repartir(ArrayList<Jugador> jugadores);

    String Palo_triunfo(ArrayList<Jugador> jugadores);

    Boolean determinar_si_hay_cartas(ArrayList<Jugador> jugadores);
}
