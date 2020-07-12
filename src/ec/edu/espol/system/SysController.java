package ec.edu.espol.system;

import ec.edu.espol.common.Sintoma;
import ec.edu.espol.common.UsrMedico;
import ec.edu.espol.common.UsrPaciente;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

public class SysController {

    public boolean añadirMedico(String nomb, String ape, String ed, Genero gen, Especialidad esp,String usr,String contr) {
        UsrMedico med = new UsrMedico(nomb, ape, Integer.parseInt(ed), gen, esp,usr,contr);
        SysData.addMedico(med);
        return true;
    }

    /*public boolean añadirPaciente(String nomb, String ape, String ed, Genero gen){
        UsrPaciente pac = new UsrPaciente(nomb, ape, Integer.parseInt(ed), gen);
        SysData.addPaciente(pac);
        return true;
    }*/

}
