package Controlador;
import Modelo.IJuego;
import Modelo.Partida;
import Vista.VistaJuego;
import Modelo.Juego;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorJuego implements IControladorRemoto {
    private IJuego juego;
    private VistaJuego vistaJuego;

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
   /* @Override
    public void update(Object obj) {
        if(obj.equals("INICIAR JUGADOR")){
            String nombre=vistaJuego.solicitar_nombre();
            ((Juego)observable).crear_jugador(nombre);
        }
        if(obj.equals("GANADOR POR TUTE")){
            vistaJuego.mostrarMensaje(((Juego)observable).getGanador().getNombre() + " canto Tute, gano el juego");
        }
        if(obj.equals("MOSTRA GANADOR Y PUNTAJES")){
            vistaJuego.mostrarMensaje("Puntajes finales: \n");
            for(int i=0;i<((Juego)observable).getJugadores().size();i++){
                vistaJuego.mostrarMensaje(((Juego)observable).getJugadores().get(i).getNombre()+" - "+((Juego)observable).getJugadores().get(i).getPuntaje());
            }
            vistaJuego.mostrarMensaje("El ganador es "+ ((Juego)observable).getGanador().getNombre());
        }
        if(obj.equals("MOSTRA PUNTAJES")){
            vistaJuego.mostrarMensaje("Puntajes parciales: \n");
            for(int i=0;i<((Juego)observable).getJugadores().size();i++){
                vistaJuego.mostrarMensaje(((Juego)observable).getJugadores().get(i).getNombre()+" - "+((Juego)observable).getJugadores().get(i).getPuntaje());
            }
        }
        if(obj.equals("CANTIDAD DE JUGADORES")){
            int cantidad= vistaJuego.cantidad_jugadores();
            ((Juego)observable).cantidad_jugadores(cantidad);
        }
        if(obj.equals("INICIAR OBSERVADOR PARTIDA")){
            Partida partidaActual = ((Juego)observable).getPartidas().get(((Juego)observable).getPartidas().size()-1);
            ControladorPartida controladorPartida = new ControladorPartida(partidaActual, new VistaPartida());
        }

    }*/

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
                ((Juego)juego).crear_jugador(nombre);//cambiar por juego?
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("GANADOR POR TUTE")){
                vistaJuego.mostrarMensaje(((Juego)juego).getGanador().getNombre() + " canto Tute, gano el juego");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRA GANADOR Y PUNTAJES")){
                vistaJuego.mostrarMensaje("Puntajes finales: \n");
                for(int i=0;i<((Juego)juego).getJugadores().size();i++){
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
                for(int i=0;i<((Juego)juego).getJugadores().size();i++){
                    vistaJuego.mostrarMensaje(((Juego)juego).getJugadores().get(i).getNombre()+" - "+((Juego)juego).getJugadores().get(i).getPuntaje());
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTIDAD DE JUGADORES")){
                int cantidad= vistaJuego.cantidad_jugadores();
                ((Juego)juego).cantidad_jugadores(cantidad);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("INICIAR OBSERVADOR PARTIDA")){
                Partida partidaActual = ((Juego)juego).getPartidas().get(((Juego)juego).getPartidas().size()-1);
                ControladorPartida controladorPartida = new ControladorPartida(partidaActual, new VistaPartida());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
