package Modelo;
import Controlador.Observer;
import ar.edu.unlu.rmimvc.observer.ObservableRemoto;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Partida extends ObservableRemoto implements IPartida {//cada vez que se reparte es una partida nueva, luego de cada mano se verifica si el ganador puede cantar algo
    private String palo_triunfo;
    private ReglaPartida reglas;
    private Crupier repartidor;
    private ArrayList<Mano> manos;
    private Mazo mazo1;
    private Jugador ganador_parcial;
    private Boolean flagTute;

    public Partida(Mazo mazo1,Boolean flagTute) {
        this.mazo1=mazo1;
        this.flagTute=flagTute;
    }

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
    @Override
    public void iniciar_partida(Juego juego1) throws RemoteException {
        repartidor=new Crupier(mazo1);
        manos=new ArrayList<>();
        repartidor.repartir(juego1.getJugadores());
        palo_triunfo=repartidor.Palo_triunfo(juego1.getJugadores());
        reglas=new ReglaPartida(palo_triunfo);
        int i=0;
        while(!repartidor.determinar_si_hay_cartas(juego1.getJugadores())==false) {
            ArrayList<Carta> cartas = new ArrayList<>();
            Mano mano = new Mano(cartas);
            manos.add(mano);//se van a ir agregando al final cada mano nueva
            notificarObservadores("INICIAR CONTROLADOR MANO");//crea el controlador de cada mano
            notificarObservadores("ANUNCIO PALO DEL TRIUNFO");//al comienzo de cada mano se muestra el palo del triunfo de la partida
            mano.iniciar_mano(this, juego1.getJugadores(), i);
            verificador_ganador(mano);
            if(flagTute==true){
                return;
            }
            i=juego1.getJugadores().indexOf(mano.getGanador());
        }
        ultimas10();
    }

    @Override
    public void verificador_ganador(Mano mano) throws RemoteException {
        ganador_parcial=mano.getGanador();
        mano.getGanador().setBazasGanadas(mano.getCartas_jugadas_en_esta_mano());
        if(reglas.determinar_si_puede_cantar_tute(ganador_parcial.getMazo_jugador())==true){
            notificarObservadores("TUTE ");
            //el controlador llamaria al metodo cantar tute con el jugador que gano la mano o baza
        }
        else if(reglas.determinar_si_puede_cantar_las40(ganador_parcial.getMazo_jugador())==true){
            notificarObservadores("LAS 40");
            //el controlador llamaria al metodo cantar las 40
        }
        else if(reglas.determinar_si_puede_cantar_las20(ganador_parcial.getMazo_jugador())==true){
            notificarObservadores("LAS 20");
            //el controlador llamaria al metodo cantar las 20
        }
        devolver_cartas_al_mazo(mano);
    }

    @Override
    public void canto_tute(String si_o_no) throws RemoteException{
        if(si_o_no.equals("si")){
            flagTute=true;
        }
    }
    @Override
    public void canto_cuarenta(String si_o_no) throws RemoteException {
        if(si_o_no.equals("si")){
            ganador_parcial.incrementar_puntaje(40);
            notificarObservadores("CANTO 40" );//mostrar por pantalla que el jugador canto 40 y deberia mostrar las cartas...
        }
    }
    @Override
    public void canto_veinte(String si_o_no) throws RemoteException {
        if(si_o_no.equals("si")){
            ganador_parcial.incrementar_puntaje(20);
            notificarObservadores("CANTO 20");//mostrar por pantalla que el jugador canto 20 y deberia mostrar las cartas...
        }
    }
    @Override
    public void ultimas10() throws RemoteException {
        ganador_parcial.incrementar_puntaje(10);
        notificarObservadores("ULTIMAS 10");//mostrar por pantalla que jugador se llevo la ultima baza
    }
    @Override
    public String getPalo_triunfo() throws RemoteException{
        return palo_triunfo;
    }
    @Override
    public Jugador getGanador_parcial() throws RemoteException {
        return ganador_parcial;
    }
    @Override
    public Boolean getFlagTute() throws RemoteException {
        return flagTute;
    }
    @Override
    public ArrayList<Mano> getManos() throws RemoteException {
        return manos;
    }
    private void devolver_cartas_al_mazo(Mano mano) throws RemoteException {
        /*for(int i=0;i<mano.getCartas_jugadas_en_esta_mano().size();i++){
            Carta aniadir=mano.getCartas_jugadas_en_esta_mano().get(i);
            reaniadirCartasAlMAzo(aniadir);
        }*/
        for (Carta carta : mano.getCartas_jugadas_en_esta_mano()) {
            reaniadirCartasAlMAzo(carta);
        }
    }

    private void reaniadirCartasAlMAzo(Carta carta) {
        this.mazo1.setMazo(carta);
    }

}
