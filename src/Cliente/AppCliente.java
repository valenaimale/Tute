package Cliente;

import Controlador.ControladorJuego;

import Controlador.ControladorPartida;
import Controlador.ControladorPrincipal;
import Controlador.ControlarMano;
import Vista.VistaJuego;
import Vista.VistaMano;
import Vista.VistaPartida;
import ar.edu.unlu.rmimvc.RMIMVCException;
import ar.edu.unlu.rmimvc.Util;
import ar.edu.unlu.rmimvc.cliente.Cliente;

import javax.swing.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AppCliente {
    public static void main(String[] args) throws RemoteException {
        ArrayList<String> ips = Util.getIpDisponibles();
        String ip = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la que escuchará peticiones el cliente", "IP del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ips.toArray(),
                null
        );
        String port = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que escuchará peticiones el cliente", "Puerto del cliente",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                9999
        );
        String ipServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione la IP en la corre el servidor", "IP del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );
        String portServidor = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el puerto en el que corre el servidor", "Puerto del servidor",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                8888
        );
        VistaJuego vistaJuego = new VistaJuego();
        VistaPartida vistaPartida = new VistaPartida();
        VistaMano vistaMano = new VistaMano();
        ControladorJuego controladorJuego = new ControladorJuego(vistaJuego);
        ControladorPartida controladorPartida = new ControladorPartida(vistaPartida);
        ControlarMano controlarMano = new ControlarMano(vistaMano);
        ControladorPrincipal controladorPrincipal=new ControladorPrincipal(controladorJuego,controladorPartida,controlarMano);
        Cliente c = new Cliente(ip, Integer.parseInt(port), ipServidor, Integer.parseInt(portServidor));
        try {
            c.iniciar(controladorPrincipal);
            controladorPrincipal.iniciarjuego();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RMIMVCException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
