package ec.edu.espol.common;

import java.util.Objects;

public class Puesto {
    private int numPuesto;
    private UsrMedico medico;

    public Puesto(int numPuesto, UsrMedico medico){
        this.numPuesto = numPuesto;
        this.medico = medico;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puesto puesto = (Puesto) o;
        return numPuesto == puesto.numPuesto;
    }
}
