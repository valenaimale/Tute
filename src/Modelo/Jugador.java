package Modelo;

import java.util.ArrayList;

public class Jugador implements IJugador {
    private String nombre;
    private int puntaje;
    private ArrayList<Carta> mazo_jugador;
    private ArrayList<Carta> bazasGanadas;

    public Jugador(String nombre, int puntaje, ArrayList<Carta> mazo_jugador, ArrayList<Carta> bazasGanadas) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.mazo_jugador = mazo_jugador;
        this.bazasGanadas = bazasGanadas;
    }

    @Override
    public ArrayList<Carta> getMazo_jugador() {
        return mazo_jugador;
    }
    @Override
    public void recibir_carta(Carta carta1){
        this.mazo_jugador.add(carta1);
    }
    @Override
    public Carta tirar_carta(int i){
        return mazo_jugador.get(i);
    }
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntaje() {
        return puntaje;
    }
    @Override
    public void incrementar_puntaje(int puntaje){
        this.puntaje+=puntaje;
    }
    @Override
    public ArrayList<Carta> getBazasGanadas() {
        return bazasGanadas;
    }

    @Override
    public void setBazasGanadas(ArrayList<Carta> bazasGanadas1) {
        for(Carta carta:bazasGanadas1){
            bazasGanadas.add(carta);
        }
    }

}
