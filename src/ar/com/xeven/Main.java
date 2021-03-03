package ar.com.xeven;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Juego juego = new Juego(Dificultad.ALTA);
        juego.iniciar();
        while(juego.isActivo()){
            juego.jugarTurno();
        }
        juego.mostrarResultados();

    }
}
