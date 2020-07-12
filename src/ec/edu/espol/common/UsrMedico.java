package ec.edu.espol.common;

import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

import java.util.PriorityQueue;

public class UsrMedico extends Usuario{
    private Especialidad especialidad;
    private boolean disponible;
    private String usuario;
    private String contraseña;
    private PriorityQueue<UsrPaciente> pacientesXatender;

    public UsrMedico(String n, String a, int e, Genero g, Especialidad esp, String usr, String contra) {
        super(n,a,e,g);
        especialidad = esp;
        usuario = usr;
        contraseña = contra;
        disponible = true;
        pacientesXatender = new PriorityQueue<>((UsrPaciente p1, UsrPaciente p2)->p1.getSintoma().getPrioridad()-p2.getSintoma().getPrioridad());
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

    public PriorityQueue<UsrPaciente> getPacientesXatender() {
        return pacientesXatender;
    }

    public boolean verificarUsuario(String usuario, String contrasenia){
        return (this.usuario.equals(usuario)) && (this.contraseña.equals(contrasenia));
    }

    public UsrPaciente atenderPaciente(){
        return pacientesXatender.poll();
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
