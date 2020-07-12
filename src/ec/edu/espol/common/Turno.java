package ec.edu.espol.common;

public class Turno {

    private UsrMedico medicoAsignado;
    private UsrPaciente pacienteAtender;
    private Puesto puestoAsignado;
    private int turnoAsignado;

    public Turno(UsrMedico m, UsrPaciente p, Puesto pA, int t) {
        medicoAsignado = m;
        pacienteAtender = p;
        puestoAsignado = pA;
        turnoAsignado = t;
    }

    public UsrMedico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(UsrMedico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public UsrPaciente getPacienteAtender() {
        return pacienteAtender;
    }

    public void setPacienteAtender(UsrPaciente pacienteAtender) {
        this.pacienteAtender = pacienteAtender;
    }

    public Puesto getPuestoAsignado() {
        return puestoAsignado;
    }

    public void setPuestoAsignado(Puesto puestoAsignado) {
        this.puestoAsignado = puestoAsignado;
    }

    public int getTurnoAsignado() {
        return turnoAsignado;
    }

    public void setTurnoAsignado(int turnoAsignado) {
        this.turnoAsignado = turnoAsignado;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "medicoAsignado=" + medicoAsignado +
                ", pacienteAtender=" + pacienteAtender +
                ", puestoAsignado=" + puestoAsignado +
                ", turnoAsignado=" + turnoAsignado +
                '}';
    }
}
