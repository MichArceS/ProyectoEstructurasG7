package ec.edu.espol.common;

import ec.edu.espol.constants.Genero;

public class UsrPaciente extends Usuario{

    private Sintoma sintoma;

    public UsrPaciente(String n, String a, int e, Genero g, Sintoma s) {
        super(n,a,e,g);
        sintoma = s;
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
