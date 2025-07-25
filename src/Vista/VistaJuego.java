package Vista;

import java.util.Scanner;

public class VistaJuego extends Vista{
    public String solicitar_nombre(){
        mostrarMensaje("Ingrese su nombre para comenzar a jugar!\n");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public int cantidad_jugadores(){
        mostrarMensaje("Ingrese la cantidad de jugadores con la que se va a jugar el juego: \n");
        Scanner scanner=new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("¡Error! Ingrese un número entero válido.");
            scanner.next();
            System.out.print("Ingrese un número entero: ");
        }
        return scanner.nextInt();
    }
}
