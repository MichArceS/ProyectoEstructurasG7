package ec.edu.espol.common;

import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

public class UsrMedico extends Usuario{

    private Especialidad especialidad;
    private boolean disponible;

    public UsrMedico(String n, String a, int e, Genero g, Especialidad esp) {
        super.nombre = n;
        super.apellido = a;
        super.edad = e;
        super.genero = g;
        especialidad = esp;
        disponible = true;
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
