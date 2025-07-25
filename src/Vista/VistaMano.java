package Vista;

import java.util.ArrayList;
import java.util.Scanner;
import Controlador.ControlarMano;
public class VistaMano extends Vista{
    public int pedirIngresoDeCarta(){
        mostrarMensaje("Ingrese el indice de la carta que desea tirar: \n");
        Scanner scanner=new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("¡Error! Ingrese un número entero válido.");
            scanner.next(); // Consumir el dato incorrecto
            System.out.print("Ingrese un índice (número entero): ");
        }
        return scanner.nextInt();
    }
    public int error_indice(){
        mostrarMensaje("El indice que ingreso no es valido, por favor ingrese el indice de vuelta: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();
    }
    public void mensaje_error_carta(){
        mostrarMensaje("Esta carta no puede tirarse en este momento, elija una valida: ");
    }
}
