package Modelo;

import java.util.ArrayList;

public class ReglaMano  {//esta clase va a devolver un ArrayList con las cartas que puede tirar el jugador
    private static ReglaMano instancia;
    private String palo_triunfo;

    private ReglaMano() {
    }
    public static ReglaMano getInstance(){
        if (instancia==null){
            instancia = new ReglaMano();
        }
        return instancia;
    }

    public void setPalo_triunfo(String palo_triunfo) {
        this.palo_triunfo = palo_triunfo;
    }

    public ArrayList<Carta> determinarQueCartaSiYQueNo(ArrayList<Carta> cartas, ArrayList<Carta> cartasDelJugador) {
        ArrayList<Carta> cartasQuePuedeTirarElJug;
        if (cartas.isEmpty()) {
            cartasQuePuedeTirarElJug = cartasDelJugador;
        } else {
            String paloDeLaMano = cartas.get(0).getPalo();
            cartasQuePuedeTirarElJug = secundaryMethod(paloDeLaMano, cartasDelJugador, cartas);
        }
        return cartasQuePuedeTirarElJug;
    }

    private ArrayList<Carta> secundaryMethod(String paloDeLaMano, ArrayList<Carta> cartasDelJugador, ArrayList<Carta> cartas) {
        ArrayList<Carta> cartasQuePuedeTirarElJug = new ArrayList<>();
        if (palo_triunfo == paloDeLaMano) {
            for (Carta carta:cartasDelJugador) {
                if (carta.getPalo().equals(palo_triunfo)) {
                    if (carta.getOrden() < determinarCartaMasAltaDelPaloDelTriunfo(palo_triunfo, cartas)) {
                        cartasQuePuedeTirarElJug.add(carta);
                    }
                }
            }
            if (cartasQuePuedeTirarElJug.isEmpty()) {
                cartasQuePuedeTirarElJug = cartasDelJugador;
            }
        } else {
            if (determinarSiTieneDelMismoPalo(cartasDelJugador, paloDeLaMano) == true) {
                for (Carta carta1:cartasDelJugador) {
                    if (carta1.getPalo().equals(paloDeLaMano)) {
                        cartasQuePuedeTirarElJug.add(carta1);
                    }
                }
            } else if (determinarSiTieneElPaloDelTriunfo(cartasDelJugador, cartas) == true) {
                for (Carta carta2:cartasDelJugador) {
                    if (carta2.getPalo().equals(palo_triunfo)) {
                        if (carta2.getOrden() < determinarCartaMasAltaDelPaloDelTriunfo(palo_triunfo, cartas)) {
                            cartasQuePuedeTirarElJug.add(carta2);
                        }
                    }
                }
            } else {
                cartasQuePuedeTirarElJug = cartasDelJugador;
            }
        }
        return cartasQuePuedeTirarElJug;

    }


    public Boolean metodoParaValidarCartaCorrecta(Carta cartaTiradaPorJugador, ArrayList<Carta> cartasQuePuedeTirar) {
        Boolean rta = false;
        /*for (int i = 0; i < cartasQuePuedeTirar.size(); i++) {
            if (cartaTiradaPorJugador == cartasQuePuedeTirar.get(i)) {
                rta = true;
            }
        }*/
        for (Carta carta : cartasQuePuedeTirar) {
            if (cartaTiradaPorJugador == carta) {
                rta = true;
            }
        }
        return rta;
    }
    private Boolean determinarSiTieneDelMismoPalo (ArrayList < Carta > cartasDelJugador, String palo) {//este metodo devuelve true si tiene del palo de la mano
            for (Carta carta : cartasDelJugador) {
                if (carta.getPalo().equals(palo)) {
                    return true;
                }
            }
            return false;
    }

    private Boolean determinarSiTieneElPaloDelTriunfo(ArrayList < Carta > cartasDelJugador, ArrayList < Carta > cartas) {//este metodo devuelve true si tiene del palo del triunfo que ademas lo tiene que superar
            for (Carta carta : cartasDelJugador) {
                if (carta.getPalo().equals(palo_triunfo)) {
                    if (carta.getOrden() < determinarCartaMasAltaDelPaloDelTriunfo(palo_triunfo, cartas)) {
                        return true;
                    }
                }
            }
            return false;
    }

    private int determinarCartaMasAltaDelPaloDelTriunfo (String palo, ArrayList < Carta > cartas){
        int orden = 1000;
        for (Carta carta : cartas) {
            if (carta.getPalo().equals(palo)) {
                if (carta.getOrden() < orden) {
                    orden = carta.getOrden();
                }
            }
        }
            return orden;
    }


    public Boolean determinar_ganadorManoParcial(Carta cartaTirada, ArrayList<Carta> cartas){
        Boolean rta = false;
        Carta cartaGanadora = cartas.get(0);
        String paloDeLaMano = cartas.get(0).getPalo();

        for (Carta carta : cartas) {
            if (!cartaGanadora.getPalo().equals(palo_triunfo)) {
                if (carta.getOrden() < cartaGanadora.getOrden() && carta.getPalo().equals(cartaGanadora.getPalo())) {
                    cartaGanadora = carta;
                } else if (!cartaGanadora.getPalo().equals(carta.getPalo()) && carta.getPalo().equals(palo_triunfo)) {
                    cartaGanadora = carta;
                }
            } else {
                if (carta.getOrden() < cartaGanadora.getOrden() && carta.getPalo().equals(cartaGanadora.getPalo())) {
                    cartaGanadora = carta;
                }
            }
        }
        if (cartaGanadora == cartaTirada) {
            rta = true;
        }
        return rta;
    }
}