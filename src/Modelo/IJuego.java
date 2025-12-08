package Modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IJuego extends IObservableRemoto {
    void iniciar_juego() throws RemoteException;

    void cantidad_jugadores(int cantidad) throws RemoteException;

    void cargar_puntajes() throws RemoteException;

    void crear_jugador(String nombre) throws RemoteException;

    ArrayList<Jugador> getJugadores() throws RemoteException;

    ArrayList<Partida> getPartidas() throws RemoteException;

    Jugador getGanador() throws RemoteException;
}
