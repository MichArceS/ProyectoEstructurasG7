package ec.edu.espol.common;

import ec.edu.espol.constants.Genero;

public class UsrPaciente extends Usuario{

    private Sintoma sintoma;

    public UsrPaciente(String n, String a, int e, Genero g) {
        super.nombre = n;
        super.apellido = a;
        super.edad = e;
        super.genero = g;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    @Override
    public String toString() {
        return "UsrPaciente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                '}';
    }
}
