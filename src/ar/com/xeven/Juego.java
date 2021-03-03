package ar.com.xeven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Juego {
    private boolean activo;
    private Dificultad dificultad;
    private List<Jugador> jugadores = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Juego(Dificultad dificultad) {
        this.dificultad = dificultad;
        this.activo = true;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void iniciar() {
        System.out.println("Bienvenido a este juego");
        System.out.println("Se puede jugar de a 2, 3 o 4.");
        System.out.print("Ingrese la cantidad de jugadores: ");
        int cantidadJugadores = Integer.parseInt(scanner.nextLine());
        String nombre;
        Equipo equipo;
        for(int i=0; i<cantidadJugadores;i++){
            System.out.print("Indique el nombre del jugador: ");
            nombre = scanner.nextLine();
            equipo = Equipo.values()[i];
            jugadores.add(new Jugador(nombre, equipo));
            System.out.println(nombre + " tiene el color "+equipo+".");
        }
    }

    public void mostrarResultados() {
        System.out.println("*** La tabla de resultados ***");
        TreeMap<Integer, Jugador> tablaDePosiciones = new TreeMap<>();
        for(Jugador jugador : jugadores){
            tablaDePosiciones.put(jugador.getDistanciaALaMeta(), jugador);
        }
        System.out.println(tablaDePosiciones);
    }

    public void jugarTurno() {
        for(Jugador jugador : jugadores)
            if(jugador.jugar()){ // si ganó
                activo = false;
                System.out.println("El ganador es: "+jugador.getNombre());
            }
    }
}
