package ar.com.xeven;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jugador {
    private Equipo equipo;
    private String nombre;
    private int posicion;
    private int meta;
    private List<Integer> jugadas = new ArrayList<>();
    private Random random = new Random();

    public Jugador(String nombre, Equipo equipo) {
        this.equipo = equipo;
        this.nombre = nombre;
        switch (equipo) {
            case ROJO:
            case AZUL:
                this.meta = 0;
                this.posicion = 100;
                break;
            case AMARILLO:
            case NEGRO:
                this.meta = 100;
                this.posicion = 0;
                break;
        }
    }

    public Boolean jugar(){
        System.out.println("** Juega "+this.nombre+" ** [ Posición "+posicion+" ] [ Meta "+meta+" ]");
        int paso = random.nextInt(4)+1;
        System.out.println("Paso: "+paso);
        jugadas.add(paso);
        if(meta == 100) {
            posicion += paso;
            return posicion>=meta;
        }else {
            posicion -= paso;
            return posicion<=meta;
        }
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getJugadas() {
        return jugadas;
    }

    public void setJugadas(List<Integer> jugadas) {
        this.jugadas = jugadas;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getMeta() {
        return meta;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return nombre + " ["+equipo+"] Posición=" + posicion +
            " Meta=" + meta;
    }

    public int getDistanciaALaMeta() {
        if(meta==0 && posicion>0){
            return posicion;
        }else if(meta==100 && posicion<100){
            return meta - posicion;
        }else {
            return 0;
        }
    }
}
