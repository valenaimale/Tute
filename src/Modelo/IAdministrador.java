package Modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdministrador extends IObservableRemoto {
    void reciboNotificacionJuego(Object obj) throws RemoteException;

    void reciboNotificacionPartida(Object obj) throws RemoteException;

    void reciboNotificacionMano(Object obj) throws RemoteException;

    void cargarMano(Mano mano) throws RemoteException;

    void cargarPartida(Partida partida) throws RemoteException;

    //---------------------------------------------------------------------------------------------------
    //metodos partida
    String getPalo_triunfoPartida() throws RemoteException;

    void canto_tutePartida(String desicion) throws RemoteException;

    void canto_cuarentaPartida(String desicion2) throws RemoteException;

    void canto_veintePartida(String desicion3) throws RemoteException;

    String getGanador_parcialPartida() throws RemoteException;

    //--------------------------------------------------------------------------------------------------
    //metodos juego
    void crear_jugadorJuego(String nombre) throws RemoteException;

    String getGanadorJuego() throws RemoteException;

    int getJugadoresJuego() throws RemoteException;

    String getJugadoresJuego2(int indice) throws RemoteException;

    int getJugadoresJuego3(int indice) throws RemoteException;

    void cantidad_jugadoresJuego(int cantidad) throws RemoteException;

    //--------------------------------------------------------------------------------------------------
    //metodos mano
    int getActualMano() throws RemoteException;

    void tirarUnaCartaMano(int i) throws RemoteException;

    void pedirIndiceMano() throws RemoteException;

    String getActualMano2() throws RemoteException;

    int getActualMano3(int r) throws RemoteException;

    String getActualMano4(int r) throws RemoteException;

    int getCartas_jugadas_en_esta_manoMano() throws RemoteException;

    int getCartas_jugadas_en_esta_manoMano2(int j) throws RemoteException;

    String getCartas_jugadas_en_esta_manoMano3(int j) throws RemoteException;

    void iniciarjuego1() throws RemoteException;
}
