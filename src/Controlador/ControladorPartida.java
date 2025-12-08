/*package Controlador;

import Modelo.IPartida;
import Modelo.Mano;
import Modelo.Partida;
import Vista.VistaMano;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorPartida implements IControladorRemoto {

    private IPartida partida_actual;
    private VistaPartida vistaPartida;

    public <T extends IObservableRemoto> ControladorPartida(T modelo, VistaPartida vistaPartida) {
        try{
            this.setModeloRemoto(modelo);
            this.vistaPartida = vistaPartida;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ControladorPartida() {
    }
    /*
notifyMessage("TUTE ");//el controlador llamaria al metodo cantar tute con el jugador que gano la mano o baza Y EL STRING QUE INGRESO POR TECLADO EL USUARIO (S/N)
notifyMessage("LAS 40");//el controlador llamaria al metodo cantar las 40 Y EL STRING QUE INGRESO POR TECLADO EL USUARIO (S/N)
notifyMessage("LAS 20");//el controlador llamaria al metodo cantar las 20 Y EL STRING QUE INGRESO POR TECLADO EL USUARIO (S/N)
notifyMessage("CANTO 40" );//mostrar por pantalla que el jugador canto 40 y deberia mostrar las cartas...(vistaPartida.mostrarMensaje("El jugador " + ((Partida)observable).getGanador_parcial().getNombre() + " canto las 40, se le suman 40 puntos");)
notifyMessage("CANTO 20");//mostrar por pantalla que el jugador canto 20 y deberia mostrar las cartas...(vistaPartida.mostrarMensaje("El jugador " + ((Partida)observable).getGanador_parcial().getNombre() + " canto las 20, se le suman 20 puntos");)
notifyMessage("ULTIMAS 10");//mostrar por pantalla que jugador se llevo la ultima baza
notifyMessage("INICIAR CONTROLADOR MANO");
notifyMessage("ANUNCIO PALO DEL TRIUNFO");


    public void actualizar_partida_a_controlar(IPartida partida_actual){
        this.partida_actual=partida_actual;
    }
    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.partida_actual=(IPartida) t;
    }

    @Override
    public void actualizar(IObservableRemoto iObservableRemoto, Object obj) throws RemoteException {
        try {
            if(obj.equals("ANUNCIO PALO DEL TRIUNFO")){
                vistaPartida.mostrarMensaje("El palo del triunfo es: \n"+partida_actual.getPalo_triunfo());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("TUTE ")){
                String desicion=vistaPartida.ofrecer_tute();
                while(!desicion.equals("si") && !desicion.equals("no")){
                    vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                    desicion=vistaPartida.ofrecer_tute();
                }
                partida_actual.canto_tute(desicion);
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("LAS 40")){
                String desicion2=vistaPartida.ofrecer_cuarenta();
                while(!desicion2.equals("si") && !desicion2.equals("no")){
                    vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                    desicion2=vistaPartida.ofrecer_cuarenta();
                }
                partida_actual.canto_cuarenta(desicion2);

            }
        }catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("LAS 20")){
                String desicion3=vistaPartida.ofrecer_veinte();
                while(!desicion3.equals("si") && !desicion3.equals("no")){
                    vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                    desicion3=vistaPartida.ofrecer_veinte();
                }
                partida_actual.canto_veinte(desicion3);
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 40")){
                vistaPartida.mostrarMensaje(partida_actual.getGanador_parcial().getNombre() + " canto las 40");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 20")){
                vistaPartida.mostrarMensaje(partida_actual.getGanador_parcial().getNombre() + " canto las 20");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ULTIMAS 10")){
                vistaPartida.mostrarMensaje(partida_actual.getGanador_parcial().getNombre() + " se llevo la ultima baza 'ultimas 10', suma 10");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("INICIAR CONTROLADOR MANO")){
                Mano manoActual = partida_actual.getManos().get(partida_actual.getManos().size()-1);
                ControlarMano controladorMano = new ControlarMano(manoActual, new VistaMano());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}*/
