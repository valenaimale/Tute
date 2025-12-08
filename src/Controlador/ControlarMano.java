/*package Controlador;

import Modelo.IMano;
import Modelo.Mano;
import Vista.VistaMano;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControlarMano implements IControladorRemoto {
    private IMano mano;
    private VistaMano vistaMano;

    public <T extends IObservableRemoto> ControlarMano(T modelo,VistaMano vistaMano) {
        try{
            this.setModeloRemoto(modelo);
            this.vistaMano = vistaMano;
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public ControlarMano() {
    }
    //
 notifyMessage("SOLICITAR CARTA A JUGADOR ACTUAL");//pedir indice en la vista y llamar al metodo tirarUnaCarta(int i) donde i es el
 indice ingresado
 notifyMessage("CARTA NO DISPONIBLE PARA TIRAR");//pedir indice en la vista de vuelta con un mensaje de error
  notifyMessage("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA");//el controlador llama a actual.getMazo_jugador()
 notifyMessage("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA");//mostrar cartas_jugadas_en_esta_mano


   // @Override
    public void update(Object obj) {
        if(obj.equals("SOLICITAR CARTA A JUGADOR ACTUAL")){
            int i=vistaMano.pedirIngresoDeCarta();
            while(i>=((Mano)observable).getActual().getMazo_jugador().size()){
                i=vistaMano.error_indice();
            }
            ((Mano)observable).tirarUnaCarta(i);
        }
        if(obj.equals("CARTA NO DISPONIBLE PARA TIRAR")){
            vistaMano.mensaje_error_carta();
            ((Mano)observable).pedirIndice();
        }
        if(obj.equals("MOSTRAME LAS CARTAS DEL JUGADOR HASTA AHORA")){
            vistaMano.mostrarMensaje("Cartas en mano de " + ((Mano)observable).getActual().getNombre()+"\n");
            for(int r=0;r<((Mano)observable).getActual().getMazo_jugador().size();r++){
                vistaMano.mostrarMensaje(r + " - "+((Mano)observable).getActual().getMazo_jugador().get(r).getNumero()+ " de "+ ((Mano)observable).getActual().getMazo_jugador().get(r).getPalo());
            }
        }
        if(obj.equals("MOSTRAME LAS CARTAS TIRADAS HASTA AHORA")){
            vistaMano.mostrarMensaje("Cartas tiradas hasta ahora: \n");
            for(int j=0;j<((Mano)observable).getCartas_jugadas_en_esta_mano().size();j++){
                vistaMano.mostrarMensaje(((Mano)observable).getCartas_jugadas_en_esta_mano().get(j).getNumero()+ " de "+ ((Mano)observable).getCartas_jugadas_en_esta_mano().get(j).getPalo()+"\n");
            }
            vistaMano.mostrarMensaje("\n");
        }
    }//

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.mano=(IMano) t;
    }

    @Override
    public void actualizar(IObservableRemoto iObservableRemoto, Object obj) throws RemoteException {
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
}*/
