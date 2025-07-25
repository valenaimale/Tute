package Controlador;

import Modelo.IPartida;
import Modelo.Mano;
import Modelo.Partida;
import Vista.VistaMano;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorPartida implements IControladorRemoto {

    private IPartida partida;
    private VistaPartida vistaPartida;

    public <T extends IObservableRemoto> ControladorPartida(T modelo, VistaPartida vistaPartida) {
        try{
            this.setModeloRemoto(modelo);
            this.vistaPartida = vistaPartida;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
   /* @Override
    public void update(Object obj) {
        if(obj.equals("ANUNCIO PALO DEL TRIUNFO")){
            vistaPartida.mostrarMensaje("El palo del triunfo es: \n"+((Partida)observable).getPalo_triunfo());
        }
        if(obj.equals("TUTE ")){
            String desicion=vistaPartida.ofrecer_tute();
            while(!desicion.equals("si") && !desicion.equals("no")){
                vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                desicion=vistaPartida.ofrecer_tute();
            }
            ((Partida)observable).canto_tute(desicion);
        }
        if(obj.equals("LAS 40")){
            String desicion2=vistaPartida.ofrecer_cuarenta();
            while(!desicion2.equals("si") && !desicion2.equals("no")){
                vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                desicion2=vistaPartida.ofrecer_cuarenta();
            }
            ((Partida)observable).canto_cuarenta(desicion2);

        }
        if(obj.equals("LAS 20")){
            String desicion3=vistaPartida.ofrecer_veinte();
            while(!desicion3.equals("si") && !desicion3.equals("no")){
                vistaPartida.mostrarMensaje("ingrese 'si' o 'no'");
                desicion3=vistaPartida.ofrecer_veinte();
            }
            ((Partida)observable).canto_veinte(desicion3);
        }
        if(obj.equals("CANTO 40")){
            vistaPartida.mostrarMensaje(((Partida)observable).getGanador_parcial().getNombre() + " canto las 40");
        }
        if(obj.equals("CANTO 20")){
            vistaPartida.mostrarMensaje(((Partida)observable).getGanador_parcial().getNombre() + " canto las 20");
        }
        if(obj.equals("ULTIMAS 10")){
            vistaPartida.mostrarMensaje(((Partida)observable).getGanador_parcial().getNombre() + " se llevo la ultima baza 'ultimas 10', suma 10");
        }
        if(obj.equals("INICIAR CONTROLADOR MANO")){
            Mano manoActual = ((Partida)observable).getManos().get(((Partida)observable).getManos().size()-1);
            ControlarMano controladorMano = new ControlarMano(manoActual, new VistaMano());
        }
    }*/

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.partida=(IPartida) t;
    }

    @Override
    public void actualizar(IObservableRemoto iObservableRemoto, Object obj) throws RemoteException {
        try {
            if(obj.equals("ANUNCIO PALO DEL TRIUNFO")){
                vistaPartida.mostrarMensaje("El palo del triunfo es: \n"+((Partida)partida).getPalo_triunfo());
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
                ((Partida)partida).canto_tute(desicion);
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
                ((Partida)partida).canto_cuarenta(desicion2);

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
                ((Partida)partida).canto_veinte(desicion3);
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 40")){
                vistaPartida.mostrarMensaje(((Partida)partida).getGanador_parcial().getNombre() + " canto las 40");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 20")){
                vistaPartida.mostrarMensaje(((Partida)partida).getGanador_parcial().getNombre() + " canto las 20");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ULTIMAS 10")){
                vistaPartida.mostrarMensaje(((Partida)partida).getGanador_parcial().getNombre() + " se llevo la ultima baza 'ultimas 10', suma 10");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("INICIAR CONTROLADOR MANO")){
                Mano manoActual = ((Partida)partida).getManos().get(((Partida)partida).getManos().size()-1);
                ControlarMano controladorMano = new ControlarMano(manoActual, new VistaMano());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
