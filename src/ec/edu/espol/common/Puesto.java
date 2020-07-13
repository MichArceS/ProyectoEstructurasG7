package ec.edu.espol.common;

public class Puesto {
    private int numPuesto;
    private UsrMedico medico;
    private static int puestosTotales=0;

    public Puesto(UsrMedico medico){
        this.medico = medico;
        numPuesto+= puestosTotales + 1 ;
        puestosTotales+=1;
    }

    public static int getPuestosTotales() {
        return puestosTotales;
    }

    public int getNumPuesto() {
        return numPuesto;
    }

    public void setNumPuesto(int numPuesto) {
        this.numPuesto = numPuesto;
    }

    public UsrMedico getMedico() {
        return medico;
    }

    public void setMedico(UsrMedico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return String.valueOf(numPuesto+" "+medico);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puesto puesto = (Puesto) o;
        return numPuesto == puesto.numPuesto;
    }
}
