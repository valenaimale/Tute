package Modelo;

import java.util.ArrayList;

public class ReglaJuego {
    private static ReglaJuego instancia;
    private ArrayList<Jugador> jugadores;

    private ReglaJuego() {
    }
    public static ReglaJuego getInstance(){
        if (instancia==null){
            instancia = new ReglaJuego();
        }
        return instancia;
    }
    public void setJugadores(ArrayList<Jugador> jugadores){
        this.jugadores = jugadores;
    }
    public int determinar_tantos(ArrayList<Carta> bazasGanadasXJug){
        int suma=0;
        /*for(int i=0;i<bazasGanadasXJug.size();i++){
            suma=bazasGanadasXJug.get(i).getValor_en_juego()+suma;
        }*/
        for(Carta carta:bazasGanadasXJug){
            suma=carta.getValor_en_juego()+suma;
        }
        return suma;
    }

    public Boolean determinar_si_hay_ganador(){
        Boolean rta=false;
        int puntajeGanador=0;
        /*for(int i=0;i<jugadores.size();i++){
            if(jugadores.get(i).getPuntaje()>puntajeGanador && jugadores.get(i).getPuntaje()>101){
                rta=true;
            }
            else if(jugadores.get(i).getPuntaje()==puntajeGanador){
                rta=false;
            }
        }*/
        for(Jugador jugador:jugadores){
            if(jugador.getPuntaje()>puntajeGanador && jugador.getPuntaje()>101){
                rta=true;
            }
            else if(jugador.getPuntaje()==puntajeGanador){
                rta=false;
            }
        }
        return rta;
    }

    public Jugador determinar_quien_gano(){
        Jugador ganador=jugadores.get(0);
        /*for(int i=0;i<jugadores.size();i++){
            if(jugadores.get(i).getPuntaje()>ganador.getPuntaje()){
                ganador=jugadores.get(i);
            }
        }*/
        for(Jugador jugador:jugadores){
            if(jugador.getPuntaje()>ganador.getPuntaje()){
                ganador=jugador;
            }
        }
        return ganador;
    }

}
