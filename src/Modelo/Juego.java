package Modelo;
import Controlador.Observer;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Juego extends ObservableRemoto implements IJuego {//se setean los puntajes luego de cada partida
    private ArrayList<Partida> partidas;
    private ArrayList<Jugador> jugadores;
    private ReglaJuego reglas;
    private Jugador ganador;

    public Juego(){
    }

    /*public void attach (Observer anObserver){
        observers.add(anObserver);
    }
    public void detach (Observer anObserver){
        observers.remove(anObserver);
    }
    public void notifyMessage(Object obj) {
        for (Observer observer : observers) {
            observer.update(obj);
        }
    }*/

    @Override
    public void iniciar_juego() throws RemoteException {
        Mazo mazo1=new Mazo();
        jugadores=new ArrayList<>();
        partidas=new ArrayList<>();
        reglas=new ReglaJuego(jugadores);
        Boolean flag_tute=false;
        System.out.println("hasta aca llegue");//(crear clase regla_juego)
        notificarObservadores("CANTIDAD DE JUGADORES");//pide ingresar la cantidad de jugadores
        while(reglas.determinar_si_hay_ganador()==false){
            Partida partida=new Partida(mazo1,flag_tute);
            partidas.add(partida);//se van a ir agregando al final cada partida nueva
            notificarObservadores("INICIAR OBSERVADOR PARTIDA");//crea el controlador partida
            partida.iniciar_partida(this);
            if(partida.getFlagTute()==true){
                ganador=partida.getGanador_parcial();
                notificarObservadores("GANADOR POR TUTE");//muestra un cartel que el jugador ganador gano la partida por que canto tute, no se muestra ni incrementa nignun puntaje
                return;
            }
            cargar_puntajes();
        }
        establecer_ganador();
        notificarObservadores("MOSTRA GANADOR Y PUNTAJES");//muestra los puntajes de cada uno y el ganador final
        //establecer_ganador() podria ir aca
    }
    @Override
    public void cantidad_jugadores(int cantidad) throws RemoteException {
        for(int i=0;i<cantidad;i++){
            notificarObservadores("INICIAR JUGADOR");//pide el nombre del jugador para inicializarlo
        }
    }
    @Override
    public void cargar_puntajes() throws RemoteException {
        /*for(int i=0; i< jugadores.size();i++){
            int puntaje=reglas.determinar_tantos(jugadores.get(i).getBazasGanadas());
            jugadores.get(i).incrementar_puntaje(puntaje);
            jugadores.get(i).getBazasGanadas().clear();
        }*/
        for(Jugador jugador:jugadores){
            int puntaje=reglas.determinar_tantos(jugador.getBazasGanadas());
            jugador.incrementar_puntaje(puntaje);
            jugador.getBazasGanadas().clear();
        }
        notificarObservadores("MOSTRA PUNTAJES");//muestra los puntajes de cada jugador
    }
    @Override
    public void crear_jugador(String nombre) throws RemoteException{
        Jugador jugador1=new Jugador(nombre,0,new ArrayList<>(),new ArrayList<>());
        jugadores.add(jugador1);
    }

    @Override
    public ArrayList<Jugador> getJugadores() throws RemoteException {

        return jugadores;
    }

    private void establecer_ganador() {
        ganador = reglas.determinar_quien_gano();
    }

    @Override
    public ArrayList<Partida> getPartidas() throws RemoteException {

        return partidas;
    }

    @Override
    public Jugador getGanador() throws RemoteException {

        return ganador;
    }

}
