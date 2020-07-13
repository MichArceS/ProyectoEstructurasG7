package ec.edu.espol.common;

public class Consulta {
    private UsrMedico medico;
    private UsrPaciente paciente;
    private String diagnostico;
    private String receta;

    public Consulta(UsrMedico medico, UsrPaciente paciente){
        this.medico = medico;
        this.paciente = paciente;
    }

    public void setDiagnostico(String dig){diagnostico = dig;}

    public void setReceta(String rec){receta = rec;
    }

    public UsrMedico getMedico() {
        return medico;
    }

    public UsrPaciente getPaciente() {
        return paciente;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getReceta() {
        return receta;
    }
}
