package ec.edu.espol.system;

import ec.edu.espol.common.*;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;
import ec.edu.espol.util.LeerEscribirDatos;

import java.util.Iterator;

public class SysController {
    private static UsrMedico medicoLogeado = null;
    private static Consulta consulta = null;

    public static boolean añadirMedico(String nomb, String ape, String ed, Genero gen, Especialidad esp,String usr,String contr) {
        UsrMedico med = new UsrMedico(nomb, ape, Integer.parseInt(ed), gen, esp,usr,contr);
        SysData.addMedico(med);
        return true;
    }

    public static boolean añadirPaciente(String nomb, String ape, String ed, Genero gen, Sintoma s){
        UsrPaciente pac = new UsrPaciente(nomb, ape, Integer.parseInt(ed), gen,s);
        SysData.addPaciente(pac);
        return true;
    }

    public static Consulta siguienteTurno(){
        Turno turno = medicoLogeado.atenderPaciente();
        if(turno != null){
            Consulta c = new Consulta(medicoLogeado,turno.getPacienteAtender());
            SysData.addConsulta(c);
            LeerEscribirDatos.registrarConsulta(c);
            consulta = c;
            return c;
        }
        return null;
    }

    public static boolean iniciarSesion(String username, String pass) {
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

    public static boolean terminarConsulta(String diag, String rec){
        consulta.setDiagnostico(diag);
        consulta.setReceta(rec);
        consulta = null;
        return true;
    }
}
