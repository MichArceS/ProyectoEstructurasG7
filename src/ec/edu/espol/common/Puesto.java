package ec.edu.espol.common;

public class Puesto {
    private int puestoAsignado;
    private UsrMedico medico;
    private static int puestosTotales=0;

    public Puesto(UsrMedico medico){
        this.medico = medico;
        puestoAsignado = puestosTotales + 1 ;
        puestosTotales+=1;
    }

    public static int getPuestosTotales() {
        return puestosTotales;
    }

    public int getPuestoAsignado() {
        return puestoAsignado;
    }

    public UsrMedico getMedico() {
        return medico;
    }

    public void setMedico(UsrMedico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return String.valueOf(puestoAsignado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puesto puesto = (Puesto) o;
        return puestoAsignado == puesto.puestoAsignado;
    }
}
