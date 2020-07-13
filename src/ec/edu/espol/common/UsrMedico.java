package ec.edu.espol.common;

import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

import java.util.PriorityQueue;

public class UsrMedico extends Usuario{
    private Especialidad especialidad;
    private boolean disponible;
    private Puesto puesto;
    private String usuario;
    private String contraseña;
    private PriorityQueue<Turno> turnos;

    public UsrMedico(String n, String a, int e, Genero g, Especialidad esp, String usr, String contra) {
        super(n,a,e,g);
        especialidad = esp;
        usuario = usr;
        contraseña = contra;
        turnos = new PriorityQueue<>((Turno t1, Turno t2)->t2.getPacienteAtender().getSintoma().getPrioridad() - t1.getPacienteAtender().getSintoma().getPrioridad());
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Turno atenderPaciente(){
        return turnos.poll();
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

    public PriorityQueue<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(PriorityQueue<Turno> turnos) {
        this.turnos = turnos;
    }

    public boolean verificarUsuario(String usuario, String contrasenia){
        return (this.usuario.equals(usuario)) && (this.contraseña.equals(contrasenia));
    }


    @Override
    public String toString() {
        return nombre+" "+apellido;
    }

    public String infoCompleta() {
        return "UsrMedico{" +
                ", disponible=" + disponible +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pacientes=" + turnos.size() +
                '}';
    }
}
