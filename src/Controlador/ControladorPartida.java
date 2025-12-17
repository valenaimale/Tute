package Controlador;

import Modelo.IAdministrador;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorPartida {

    private IAdministrador administrador;
    private VistaPartida vistaPartida;

    public ControladorPartida(VistaPartida vistaPartida) {
        this.vistaPartida=vistaPartida;
    }
    public void setAdministrador(IAdministrador administrador){
        this.administrador=administrador;
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
*/

    public void update_partida(Object obj) throws RemoteException {
        try {
            if(obj.equals("ANUNCIO PALO DEL TRIUNFO")){
                vistaPartida.mostrarMensaje("El palo del triunfo es: \n"+administrador.getPalo_triunfoPartida());
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
                administrador.canto_tutePartida(desicion);
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
                administrador.canto_cuarentaPartida(desicion2);

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
                administrador.canto_veintePartida(desicion3);
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 40")){
                vistaPartida.mostrarMensaje(administrador.getGanador_parcialPartida() + " canto las 40");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 20")){
                vistaPartida.mostrarMensaje(administrador.getGanador_parcialPartida() + " canto las 20");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ULTIMAS 10")){
                vistaPartida.mostrarMensaje(administrador.getGanador_parcialPartida() + " se llevo la ultima baza 'ultimas 10', suma 10");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
