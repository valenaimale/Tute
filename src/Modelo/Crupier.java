package Modelo;

import java.util.ArrayList;

public class Crupier  {
    private Mazo mazo1;

    public Crupier(Mazo mazo1) {
        this.mazo1 = mazo1;
    }

    public void repartir(ArrayList<Jugador> jugadores){
        mazo1.mezclate();
        int i=0;
        while(!mazo1.getMazo().isEmpty()){
            Jugador jugador=jugadores.get(i%jugadores.size());//% es modulo, hace que se repitan ciclicamente los indices de los jugadores
            Carta carta1=mazo1.getMazo().remove(0);
            jugador.recibir_carta(carta1);
            i++;
        }
    }

    public String Palo_triunfo(ArrayList<Jugador> jugadores) {
        int i= jugadores.size();
        Jugador jugador= jugadores.get(i-1);
        int n=jugador.getMazo_jugador().size();
        Carta carta_triunfo=jugador.getMazo_jugador().get(n-1);
        return carta_triunfo.getPalo();
    }

    public Boolean determinar_si_hay_cartas(ArrayList<Jugador> jugadores){
        Boolean hay_cartas=true;
        /*for(int i=0; i< jugadores.size();i++){
            if(jugadores.get(i).getMazo_jugador().isEmpty()){
                hay_cartas=false;
            }
        }*/
        for(Jugador jugador:jugadores){
            if(jugador.getMazo_jugador().isEmpty()){
                hay_cartas=false;
            }
        }
        return hay_cartas;
    }

}
