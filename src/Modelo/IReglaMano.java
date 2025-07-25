package Modelo;

import java.util.ArrayList;

public interface IReglaMano {
    ArrayList<Carta> determinarQueCartaSiYQueNo(ArrayList<Carta> cartas, ArrayList<Carta> cartasDelJugador);

    Boolean metodoParaValidarCartaCorrecta(Carta cartaTiradaPorJugador, ArrayList<Carta> cartasQuePuedeTirar);

    Boolean determinar_ganadorManoParcial(Carta cartaTirada, ArrayList<Carta> cartas);
}
