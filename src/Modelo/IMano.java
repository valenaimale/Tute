package Modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IMano extends IObservableRemoto {
    void iniciar_mano(Partida partida, ArrayList<Jugador> jugadores, int i) throws RemoteException;

    void pedirIndice() throws RemoteException;

    void tirarUnaCarta(int i) throws RemoteException;

    void almacenar(Carta tirada) throws RemoteException;

    ArrayList<Carta> getCartas_jugadas_en_esta_mano() throws RemoteException;

    Jugador getGanador() throws RemoteException;

    Jugador getActual() throws RemoteException;
}
