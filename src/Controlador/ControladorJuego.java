package Controlador;
import Modelo.*;
import Vista.VistaJuego;
import Vista.VistaMano;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorJuego implements IControladorRemoto {
    private IJuego juego;
    private IPartida partida;
    private IMano mano;
    private VistaJuego vistaJuego;
    private VistaPartida vistaPartida;
    private VistaMano vistaMano;

    public <T extends IObservableRemoto> ControladorJuego(T modelo, VistaJuego vistaJuego) {
        try{
            this.setModeloRemoto(modelo);
            this.vistaJuego = vistaJuego;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ControladorJuego() {
    }
    /*
notifyMessage("GANADOR POR TUTE");//muestra un cartel que el jugador ganador gano la partida por que canto tute, no se muestra ni incrementa nignun puntaje
notifyMessage("MOSTRA GANADOR Y PUNTAJES");//muestra los puntajes de cada uno y el ganador final
notifyMessage("MOSTRA PUNTAJES");//muestra solo los puntajes parciales
notifyMessage("INICIAR JUGADOR");
*/
    public void iniciarjuego() throws RemoteException {
        this.vistaJuego=new VistaJuego();
        juego.iniciar_juego();
    }
    private void actualizar_partida_a_controlar(IPartida partida){
        this.partida=partida;
        if (vistaPartida==null){
            this.vistaPartida=new VistaPartida();
        }
    }
    private void actualizar_mano_a_controlar(IMano mano){
        this.mano=mano;
        if (vistaMano==null){
            this.vistaMano=new VistaMano();
        }
    }




    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T juegoRemoto) throws RemoteException {
        this.juego = (IJuego) juegoRemoto;

    }

    @Override
    public void actualizar(IObservableRemoto iObservableRemoto, Object obj) throws RemoteException {
        try {
            if(obj.equals("INICIAR JUGADOR")){
                System.out.println("hasta aca llegue 2");
                String nombre=vistaJuego.solicitar_nombre();
                juego.crear_jugador(nombre);//cambiar por juego?
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("GANADOR POR TUTE")){
                vistaJuego.mostrarMensaje(juego.getGanador().getNombre() + " canto Tute, gano el juego");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRA GANADOR Y PUNTAJES")){
                vistaJuego.mostrarMensaje("Puntajes finales: \n");
                for(int i=0;i<juego.getJugadores().size();i++){
                    vistaJuego.mostrarMensaje(((Juego)juego).getJugadores().get(i).getNombre()+" - "+((Juego)juego).getJugadores().get(i).getPuntaje());
                }
                vistaJuego.mostrarMensaje("El ganador es "+ ((Juego)juego).getGanador().getNombre());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRA PUNTAJES")){
                vistaJuego.mostrarMensaje("Puntajes parciales: \n");
                for(int i=0;i<juego.getJugadores().size();i++){
                    vistaJuego.mostrarMensaje(juego.getJugadores().get(i).getNombre()+" - "+juego.getJugadores().get(i).getPuntaje());
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTIDAD DE JUGADORES")){
                int cantidad= vistaJuego.cantidad_jugadores();
                juego.cantidad_jugadores(cantidad);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ACTUALIZAR OBSERVADOR PARTIDA")){
                IPartida partidaActual = juego.getPartidas().get(juego.getPartidas().size()-1);
                actualizar_partida_a_controlar(partidaActual);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        //controlador partida:
        //-------------------------------------------------------------------------------------------------------------------------------
        try {
            if(obj.equals("ANUNCIO PALO DEL TRIUNFO")){
                System.out.println("hola 2");
                vistaPartida.mostrarMensaje("El palo del triunfo es: \n"+partida.getPalo_triunfo());
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
                partida.canto_tute(desicion);
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
                partida.canto_cuarenta(desicion2);

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
                partida.canto_veinte(desicion3);
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 40")){
                vistaPartida.mostrarMensaje(partida.getGanador_parcial().getNombre() + " canto las 40");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTO 20")){
                vistaPartida.mostrarMensaje(partida.getGanador_parcial().getNombre() + " canto las 20");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ULTIMAS 10")){
                vistaPartida.mostrarMensaje(partida.getGanador_parcial().getNombre() + " se llevo la ultima baza 'ultimas 10', suma 10");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("ACTUALIZAR OBSERVADOR MANO")){
                System.out.println("hola");
                IMano manoActual = partida.getManos().get(partida.getManos().size()-1);
                actualizar_mano_a_controlar(manoActual);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        // controlador mano:
        // -----------------------------------------------------------------------------------------------------------------------------------
        try {
            if(obj.equals("SOLICITAR CARTA A JUGADOR ACTUAL")){
                int i=vistaMano.pedirIngresoDeCarta();
                while(i>=((Mano)mano).getActual().getMazo_jugador().size()){
                    i=vistaMano.error_indice();
                }
                ((Mano)mano).tirarUnaCarta(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CARTA NO DISPONIBLE PARA TIRAR")){
                vistaMano.mensaje_error_carta();
                ((Mano)mano).pedirIndice();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA")){
                vistaMano.mostrarMensaje("Cartas en mano de " + ((Mano)mano).getActual().getNombre()+"\n");
                for(int r=0;r<((Mano)mano).getActual().getMazo_jugador().size();r++){
                    vistaMano.mostrarMensaje(r + " - "+((Mano)mano).getActual().getMazo_jugador().get(r).getNumero()+ " de "+ ((Mano)mano).getActual().getMazo_jugador().get(r).getPalo());
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA")){
                vistaMano.mostrarMensaje("Cartas tiradas hasta ahora: \n");
                for(int j=0;j<((Mano)mano).getCartas_jugadas_en_esta_mano().size();j++){
                    vistaMano.mostrarMensaje(((Mano)mano).getCartas_jugadas_en_esta_mano().get(j).getNumero()+ " de "+ ((Mano)mano ).getCartas_jugadas_en_esta_mano().get(j).getPalo()+"\n");
                }
                vistaMano.mostrarMensaje("\n");
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
