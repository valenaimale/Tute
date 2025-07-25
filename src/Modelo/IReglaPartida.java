package Modelo;

import java.util.ArrayList;

public interface IReglaPartida {
    Boolean determinar_si_puede_cantar_tute(ArrayList<Carta> cartas_en_mano);

    Boolean determinar_si_puede_cantar_las20(ArrayList<Carta> cartas_en_mano);

    Boolean determinar_si_puede_cantar_las40(ArrayList<Carta> cartas_en_mano);
}
