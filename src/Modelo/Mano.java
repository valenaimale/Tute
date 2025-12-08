package Modelo;

import Controlador.Observer;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class Mano extends ObservableRemoto implements IMano, Serializable {
    private ArrayList<Carta> cartas_jugadas_en_esta_mano;
    private ReglaMano reglas;
    private Jugador ganador;
    private Jugador actual;

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
    public Mano(ArrayList<Carta> cartas_jugadas_en_esta_mano) {
        this.cartas_jugadas_en_esta_mano = cartas_jugadas_en_esta_mano;
    }
    @Override
    public void iniciar_mano(Partida partida, ArrayList<Jugador> jugadores, int i) throws RemoteException{
        reglas=ReglaMano.getInstance();
        reglas.setPalo_triunfo(partida.getPalo_triunfo());
        actual=jugadores.get(i);
        for(int j=0;j< jugadores.size();j++){// no se puede for each, ya que no se requiere recorrer la lista en orden
            pedirIndice();
            i++;
            i=i% jugadores.size();
            actual=jugadores.get(i);
        }
    }
    @Override
    public void pedirIndice() throws RemoteException {
        notificarObservadores("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA");//el controlador llama a actual.getMazo_jugador()
        notificarObservadores("SOLICITAR CARTA A JUGADOR ACTUAL");//pedir indice en la vista y llamar al metodo tirarUnaCarta(int i) donde i es el indice ingresado
    }
    @Override
    public void tirarUnaCarta(int i) throws RemoteException {
        Carta tirada=actual.tirar_carta(i);
        if(validacion(tirada)==false){
            notificarObservadores("CARTA NO DISPONIBLE PARA TIRAR");//pedir indice en la vista de vuelta con un mensaje de error
            //El controlador solicita a la vista que pida reingresar una carta
        }
        else{
            almacenar(tirada);
        }
    }
    private Boolean validacion(Carta tirada) {
        Boolean rta = true;
        ArrayList<Carta> cartasDisp = reglas.determinarQueCartaSiYQueNo(cartas_jugadas_en_esta_mano, actual.getMazo_jugador());
        if (reglas.metodoParaValidarCartaCorrecta(tirada, cartasDisp) == false) {
            rta = false;
        }
        return rta;
    }
    @Override
    public void almacenar(Carta tirada) throws RemoteException {
        actual.getMazo_jugador().remove(tirada);
        cartas_jugadas_en_esta_mano.add(tirada);
        notificarObservadores("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA");//mostrar cartas_jugadas_en_esta_mano
        if(reglas.determinar_ganadorManoParcial(tirada,cartas_jugadas_en_esta_mano)==true){
            ganador=actual;
        }
    }

    @Override
    public ArrayList<Carta> getCartas_jugadas_en_esta_mano() throws RemoteException {
        return cartas_jugadas_en_esta_mano;
    }

    @Override
    public Jugador getGanador() throws RemoteException {
        return ganador;
    }
    @Override
    public Jugador getActual() throws RemoteException {
        return actual;
    }
}
