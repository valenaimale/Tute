package Modelo;


import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.io.Serializable;
import java.rmi.RemoteException;

public class Administrador extends ObservableRemoto implements IAdministrador, Serializable {
    private Juego juego;
    private Partida partida;
    private Mano mano;

    public Administrador(){
        this.juego=new Juego();
    }

    @Override
    public void iniciarjuego1() throws RemoteException {
        juego.agregar_admin(this);
        juego.iniciar_juego();
    }
    @Override
    public void reciboNotificacionJuego(Object obj) throws RemoteException {
        notificarObservadores(obj);
    }
    @Override
    public void reciboNotificacionPartida(Object obj) throws RemoteException {
        notificarObservadores(obj);
    }
    @Override
    public void reciboNotificacionMano(Object obj) throws RemoteException {
        notificarObservadores(obj);
    }
    @Override
    public void cargarMano(Mano mano){
        this.mano=mano;
        mano.iniciar_admin(this);
    }
    @Override
    public void cargarPartida(Partida partida){
        this.partida=partida;
        partida.iniciar_admin(this);
    }
    //---------------------------------------------------------------------------------------------------
    //metodos partida
    @Override
    public String getPalo_triunfoPartida() throws RemoteException {
        String palo_triunfo=partida.getPalo_triunfo();
        return palo_triunfo;
    }
    @Override
    public void canto_tutePartida(String desicion) throws RemoteException {
        partida.canto_tute(desicion);
    }
    @Override
    public void canto_cuarentaPartida(String desicion2) throws RemoteException {
        partida.canto_cuarenta(desicion2);
    }
    @Override
    public void canto_veintePartida(String desicion3) throws RemoteException {
        partida.canto_veinte(desicion3);
    }
    @Override
    public String getGanador_parcialPartida() throws RemoteException {
        String nombre=partida.getGanador_parcial().getNombre();
        return nombre;
    }
    //--------------------------------------------------------------------------------------------------
    //metodos juego
    @Override
    public void crear_jugadorJuego(String nombre) throws RemoteException {
        juego.crear_jugador(nombre);
    }
    @Override
    public String getGanadorJuego() throws RemoteException {
        String nombre=juego.getGanador().getNombre();
        return nombre;
    }
    @Override
    public int getJugadoresJuego() throws RemoteException {
        return juego.getJugadores().size();
    }
    @Override
    public String getJugadoresJuego2(int indice) throws RemoteException {
        return juego.getJugadores().get(indice).getNombre();
    }
    @Override
    public int getJugadoresJuego3(int indice) throws RemoteException {
        return juego.getJugadores().get(indice).getPuntaje();
    }
    @Override
    public void cantidad_jugadoresJuego(int cantidad) throws RemoteException {
        juego.cantidad_jugadores(cantidad);
    }
    //--------------------------------------------------------------------------------------------------
    //metodos mano
    @Override
    public int getActualMano() throws RemoteException {
        return mano.getActual().getMazo_jugador().size();
    }
    @Override
    public void tirarUnaCartaMano(int i) throws RemoteException {
        mano.tirarUnaCarta(i);
    }
    @Override
    public void pedirIndiceMano() throws RemoteException {
        mano.pedirIndice();
    }
    @Override
    public String getActualMano2() throws RemoteException {
        return mano.getActual().getNombre();
    }
    @Override
    public int getActualMano3(int r) throws RemoteException {
        return mano.getActual().getMazo_jugador().get(r).getNumero();
    }
    @Override
    public String getActualMano4(int r) throws RemoteException {
        return mano.getActual().getMazo_jugador().get(r).getPalo();
    }
    @Override
    public int getCartas_jugadas_en_esta_manoMano() throws RemoteException {
        return mano.getCartas_jugadas_en_esta_mano().size();
    }
    @Override
    public int getCartas_jugadas_en_esta_manoMano2(int j) throws RemoteException {
        return mano.getCartas_jugadas_en_esta_mano().get(j).getNumero();
    }
    @Override
    public String getCartas_jugadas_en_esta_manoMano3(int j) throws RemoteException {
        return mano.getCartas_jugadas_en_esta_mano().get(j).getPalo();
    }



}
