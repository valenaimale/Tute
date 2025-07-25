package Modelo;

import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IPartida extends IObservableRemoto {
    /*public void attach (Observer anObserver){
            observers.add(anObserver);
        }
        public void detach (Observer anObserver){
            observers.remove(anObserver);
        }

        public void notifyMessage(Object obj){
            for (Observer observer:observers){
                observer.update(obj);
            }
        }*/
    void iniciar_partida(Juego juego1) throws RemoteException;

    void verificador_ganador(Mano mano) throws RemoteException;

    void canto_tute(String si_o_no) throws RemoteException;

    void canto_cuarenta(String si_o_no) throws RemoteException;

    void canto_veinte(String si_o_no) throws RemoteException;

    void ultimas10() throws RemoteException;

    String getPalo_triunfo() throws RemoteException;

    Jugador getGanador_parcial() throws RemoteException;

    Boolean getFlagTute() throws RemoteException;

    ArrayList<Mano> getManos() throws RemoteException;
}
