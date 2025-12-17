package Controlador;

import Modelo.IAdministrador;
import ar.edu.unlu.rmimvc.cliente.IControladorRemoto;
import ar.edu.unlu.rmimvc.observer.IObservableRemoto;

import java.rmi.RemoteException;

public class ControladorPrincipal implements IControladorRemoto {
    private ControladorJuego controladorJuego;
    private ControladorPartida controladorPartida;
    private ControlarMano controlarMano;
    private IAdministrador administrador;

    public ControladorPrincipal (ControladorJuego controladorJuego, ControladorPartida controladorPartida, ControlarMano controlarMano ) {
        this.controladorJuego=controladorJuego;
        this.controladorPartida=controladorPartida;
        this.controlarMano=controlarMano;
    }
    public void iniciarjuego() throws RemoteException {
        controladorJuego.setAdministrador(administrador);
        controladorPartida.setAdministrador(administrador);
        controlarMano.setAdministrador(administrador);
        administrador.iniciarjuego1();
    }

    @Override
    public <T extends IObservableRemoto> void setModeloRemoto(T t) throws RemoteException {
        this.administrador=(IAdministrador) t;
    }

    @Override
    public void actualizar(IObservableRemoto iObservableRemoto, Object obj) throws RemoteException {
        String evento = obj.toString();
        int indice = evento.indexOf(':');
        String controlador = evento.substring(0,indice);
        String tipo_evento = evento.substring(indice+1);
        switch (controlador){
            case "JUEGO" -> controladorJuego.update_juego(tipo_evento);
            case "PARTIDA" -> controladorPartida.update_partida(tipo_evento);
            case "MANO" -> controlarMano.update_mano(tipo_evento);
            default -> System.out.println("El prefijo "+ controlador + " no es valido");
        }

    }
}
