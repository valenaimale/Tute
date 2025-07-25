package Vista;

import java.util.Scanner;

public class VistaPartida extends Vista{
    public String ofrecer_tute(){
        mostrarMensaje("Tute\n");
        mostrarMensaje("si/no");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public String ofrecer_cuarenta(){
        mostrarMensaje("Las cuarenta\n");
        mostrarMensaje("si/no");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }
    public String ofrecer_veinte(){
        mostrarMensaje("Las veinte\n");
        mostrarMensaje("si/no");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

}
