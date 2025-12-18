package Controlador;
import Modelo.IAdministrador;
import Vista.VistaMano;
import java.rmi.RemoteException;

public class ControlarMano {
    private IAdministrador administrador;
    private VistaMano vistaMano;

    public ControlarMano(VistaMano vistaMano) {
        this.vistaMano=vistaMano;
    }

    public void setAdministrador(IAdministrador administrador){
        this.administrador=administrador;
    }
    /*
 notifyMessage("SOLICITAR CARTA A JUGADOR ACTUAL");//pedir indice en la vista y llamar al metodo tirarUnaCarta(int i) donde i es el
 indice ingresado
 notifyMessage("CARTA NO DISPONIBLE PARA TIRAR");//pedir indice en la vista de vuelta con un mensaje de error
  notifyMessage("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA");//el controlador llama a actual.getMazo_jugador()
 notifyMessage("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA");//mostrar cartas_jugadas_en_esta_mano
*/
    public void update_mano(Object obj) throws RemoteException {
        try {
            if(obj.equals("SOLICITAR CARTA A JUGADOR ACTUAL")){
                int i=vistaMano.pedirIngresoDeCarta();
                while(i>=administrador.getActualMano()){//devuelve la cantidad de cartas que tiene el jugador
                    i=vistaMano.error_indice();
                }
                administrador.tirarUnaCartaMano(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("CARTA NO DISPONIBLE PARA TIRAR")){
                vistaMano.mensaje_error_carta();
                administrador.pedirIndiceMano();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA")){
                vistaMano.mostrarMensaje("Cartas en mano de " + administrador.getActualMano2()+"\n");//devuelve el nombre del jugador
                for(int r=0;r<administrador.getActualMano();r++){
                    vistaMano.mostrarMensaje(r + " - "+ administrador.getActualMano3(r)+ " de "+ administrador.getActualMano4(r));//getActualMano3 devuelve el numero de carta mientras que getActualMano4 devuelve el palo
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            if(obj.equals("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA")){
                vistaMano.mostrarMensaje("Cartas tiradas hasta ahora: \n");
                for(int j=0;j<administrador.getCartas_jugadas_en_esta_manoMano();j++){
                    vistaMano.mostrarMensaje(administrador.getCartas_jugadas_en_esta_manoMano2(j)+ " de "+ administrador.getCartas_jugadas_en_esta_manoMano3(j)+"\n");//getCartas_jugadas_en_esta_manoMano2 devuelve el numero de caerta y getCartas_jugadas_en_esta_manoMano3 devuelve el palo
                }
                vistaMano.mostrarMensaje("\n");
            }
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
