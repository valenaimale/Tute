package Modelo;

import java.util.ArrayList;

public class ReglaPartida  {
    private static ReglaPartida instancia;
    private  String palo_triunfo;

    private ReglaPartida() {
    }
    public static ReglaPartida getInstance(){
        if (instancia==null){
            instancia = new ReglaPartida();
        }
        return instancia;
    }

    public void setPalo_triunfo(String palo_triunfo) {
        this.palo_triunfo = palo_triunfo;
    }
    public Boolean determinar_si_puede_cantar_tute(ArrayList<Carta> cartas_en_mano) {
        Boolean rta = false;
        int cantidad11 = 0;
        int cantidad12 = 0;
        for (Carta carta:cartas_en_mano){
            if (carta.getNumero() == 12) {
                cantidad12++;
            }
            if (carta.getNumero() == 11) {
                cantidad11++;
            }
        }
        if (cantidad11 >= 4 || cantidad12 >= 4) {
            rta = true;
        }
        return rta;
    }


    public Boolean determinar_si_puede_cantar_las20(ArrayList<Carta> cartas_en_mano) {
        Boolean rta = false;
        /*for (int i = 0; i < cartas_en_mano.size(); i++) {
            int n = 0;
            for (n = 0; n < cartas_en_mano.size(); n++) {
                if (methodAux20(cartas_en_mano.get(i), cartas_en_mano.get(n)) == true) {
                    rta = true;
                }
            }
        }*/
        for (Carta carta:cartas_en_mano) {
            for (Carta carta2:cartas_en_mano) {
                if (methodAux20(carta, carta2) == true) {
                    rta = true;
                }
            }
        }
        return rta;
    }


    public Boolean determinar_si_puede_cantar_las40(ArrayList<Carta> cartas_en_mano) {
        Boolean rta = false;
        /*for (int i = 0; i < cartas_en_mano.size(); i++) {
            int n = 0;
            for (n = 0; n < cartas_en_mano.size(); n++) {
                if (methodAux40(cartas_en_mano.get(i), cartas_en_mano.get(n)) == true) {
                    rta = true;
                }
            }
        }*/
        for (Carta carta:cartas_en_mano) {
            for (Carta carta2:cartas_en_mano) {
                if (methodAux40(carta, carta2) == true) {
                    rta = true;
                }
            }
        }
        return rta;
    }

    private Boolean methodAux20(Carta carta1, Carta carta2) {
        Boolean rta = false;
        if (carta1.getPalo().equals(carta2.getPalo())) {
            if (carta1.getNumero() == 12 && carta2.getNumero() == 11 || carta1.getNumero() == 11 && carta2.getNumero() == 12) {
                rta = true;
            }
        }
        return rta;
    }

    private Boolean methodAux40(Carta carta1, Carta carta2) {
        Boolean rta = false;
        if (carta1.getPalo().equals(carta2.getPalo())) {
            if (carta1.getNumero() == 12 && carta2.getNumero() == 11 || carta1.getNumero() == 11 && carta2.getNumero() == 12) {
                if (carta1.getPalo().equals(palo_triunfo)) {
                    rta = true;
                }
            }
        }
        return rta;
    }
}
