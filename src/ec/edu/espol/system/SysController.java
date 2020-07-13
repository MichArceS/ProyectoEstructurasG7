package ec.edu.espol.system;

import ec.edu.espol.common.Consulta;
import ec.edu.espol.common.Sintoma;
import ec.edu.espol.common.UsrMedico;
import ec.edu.espol.common.UsrPaciente;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;
import ec.edu.espol.util.LeerEscribirDatos;

public class SysController {
    private static UsrMedico medicoLogeado = null;

    public boolean añadirMedico(String nomb, String ape, String ed, Genero gen, Especialidad esp,String usr,String contr) {
        UsrMedico med = new UsrMedico(nomb, ape, Integer.parseInt(ed), gen, esp,usr,contr);
        SysData.addMedico(med);
        return true;
    }


    public static boolean iniciarSesion(String usuario, String contrasenia){
        for (UsrMedico m: SysData.medicosRegistrados){
            if(m.verificarUsuario(usuario, contrasenia))
                medicoLogeado = m;
                return true;
        }
        return false;
    }

    public boolean añadirPaciente(String nomb, String ape, String ed, Genero gen, Sintoma s){
        UsrPaciente pac = new UsrPaciente(nomb, ape, Integer.parseInt(ed), gen,s);
        SysData.addPaciente(pac);
        return true;
    }

    public UsrPaciente atenderPaciente(){
        return SysData.pacientes.poll();
    }

    public boolean siguienteTurno(){
        UsrPaciente p = atenderPaciente();
        Consulta c = new Consulta(medicoLogeado,p);
        LeerEscribirDatos.registrarConsulta(c);
        return true;
    }


}
