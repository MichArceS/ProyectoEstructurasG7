package ec.edu.espol.common;

import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

import java.util.PriorityQueue;

public class UsrMedico extends Usuario{

    private Especialidad especialidad;
    private boolean disponible;
    private String usuario;
    private String contraseña;
    private static PriorityQueue<Turno> turnos;

    public UsrMedico(String n, String a, int e, Genero g, Especialidad esp,String usr,String contra) {
        super.nombre = n;
        super.apellido = a;
        super.edad = e;
        super.genero = g;
        especialidad = esp;
        disponible = true;
        usuario = usr;
        contraseña = contra;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "UsrMedico{" +
                "especialidad='" + especialidad + '\'' +
                ", disponible=" + disponible +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
