package ec.edu.espol.common;

public class UsrMedico extends Usuario{

    private String especialidad;
    private boolean disponible;

    public UsrMedico(String n, String a, int e, String g, String s, String esp) {
        super.nombre = n;
        super.apellido = a;
        super.edad = e;
        super.genero = g;
        especialidad = esp;
        disponible = true;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
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
