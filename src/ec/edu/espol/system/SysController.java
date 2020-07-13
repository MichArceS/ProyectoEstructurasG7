package ec.edu.espol.system;

import ec.edu.espol.common.*;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;
import ec.edu.espol.util.LeerEscribirDatos;

import java.util.Iterator;

public class SysController {
    private static UsrMedico medicoLogeado = null;
    private static Consulta consulta = null;

    public boolean añadirMedico(String nomb, String ape, String ed, Genero gen, Especialidad esp,String usr,String contr) {
        UsrMedico med = new UsrMedico(nomb, ape, Integer.parseInt(ed), gen, esp,usr,contr);
        SysData.addMedico(med);
        return true;
    }

    public boolean añadirPaciente(String nomb, String ape, String ed, Genero gen, Sintoma s){
        UsrPaciente pac = new UsrPaciente(nomb, ape, Integer.parseInt(ed), gen,s);
        SysData.addPaciente(pac);
        return true;
    }

    public Turno atenderPaciente(){
        return medicoLogeado.getTurnos().poll();
    }

    public boolean siguienteTurno(){
        Turno turno = medicoLogeado.atenderPaciente();
        Consulta c = new Consulta(medicoLogeado,turno.getPacienteAtender());
        SysData.addConsulta(c);
        LeerEscribirDatos.registrarConsulta(c);
        return true;
    }

    public boolean logIn(String username, String pass) {
        Iterator<UsrMedico> it = SysData.medicosRegistrados.iterator();
        while(it.hasNext()) {
            UsrMedico m = it.next();
            if (m.verificarUsuario(username,pass) && m.isDisponible()) {
                medicoLogeado = m;
                return true;
            }
        }
        return false;
    }
}
