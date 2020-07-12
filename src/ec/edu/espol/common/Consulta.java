package ec.edu.espol.common;

public class Consulta {
    private UsrMedico medico;
    private UsrPaciente paciente;
    private String diagnostico;
    private String receta;

    public Consulta(UsrMedico medico, UsrPaciente paciente, String diagnostico, String receta){
        this.medico = medico;
        this.paciente = paciente;
        this.diagnostico = diagnostico;
        this.receta = receta;
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
