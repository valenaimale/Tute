package Controlador;
import Modelo.IAdministrador;
import Vista.VistaJuego;
import java.rmi.RemoteException;

public class ControladorJuego  {
    private IAdministrador administrador;
    private VistaJuego vistaJuego;

    public ControladorJuego(VistaJuego vistaJuego) {
        this.vistaJuego=vistaJuego;

    }
    public void setAdministrador(IAdministrador administrador){
        this.administrador=administrador;
    }

    /*
notifyMessage("GANADOR POR TUTE");//muestra un cartel que el jugador ganador gano la partida por que canto tute, no se muestra ni incrementa nignun puntaje
notifyMessage("MOSTRA GANADOR Y PUNTAJES");//muestra los puntajes de cada uno y el ganador final
notifyMessage("MOSTRA PUNTAJES");//muestra solo los puntajes parciales
notifyMessage("INICIAR JUGADOR");
*/




    public void update_juego(Object obj) throws RemoteException {
        try {
            if(obj.equals("INICIAR JUGADOR")){
                System.out.println("hasta aca llegue 2");
                String nombre=vistaJuego.solicitar_nombre();
                administrador.crear_jugadorJuego(nombre);//cambiar por juego?
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("GANADOR POR TUTE")){
                vistaJuego.mostrarMensaje(administrador.getGanadorJuego()+ " canto Tute, gano el juego");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRA GANADOR Y PUNTAJES")){
                vistaJuego.mostrarMensaje("Puntajes finales: \n");
                for(int i=0;i<administrador.getJugadoresJuego();i++){
                    vistaJuego.mostrarMensaje(administrador.getJugadoresJuego2(i)+" - "+ administrador.getJugadoresJuego3(i));//getJugadoresJuego2 muestra el nombre mientras que getJugadoresJuego3 muestra el respectivo puntaje
                }
                vistaJuego.mostrarMensaje("El ganador es "+ administrador.getGanadorJuego());
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRA PUNTAJES")){
                vistaJuego.mostrarMensaje("Puntajes parciales: \n");
                for(int i=0;i<administrador.getJugadoresJuego();i++){
                    vistaJuego.mostrarMensaje(administrador.getJugadoresJuego2(i)+" - "+ administrador.getJugadoresJuego3(i));
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CANTIDAD DE JUGADORES")){
                int cantidad= vistaJuego.cantidad_jugadores();
                administrador.cantidad_jugadoresJuego(cantidad);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
