package ec.edu.espol.util;

import ec.edu.espol.common.*;
import ec.edu.espol.constants.Constantes;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class LeerEscribirDatos {

    public static List<Sintoma> cargarSintomas(){
        List<Sintoma> sintomas = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTASINTOMAS))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("\\|");
                sintomas.add(new Sintoma(data[0], Integer.valueOf(data[1])));
                line = br.readLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return sintomas;
    }

    public static boolean añadirSintoma(String nombre, String prioridad){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/ec/edu/espol/util/sintomas.txt",true))){
            String line = nombre + "|" + prioridad;
            bw.newLine();
            bw.write(line);

        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    /*public static void main(String[] args){
        List<Sintoma> sintomas = cargarSintomas();
        //System.out.println(sintomas.size());
        for(Sintoma s: sintomas){
            System.out.println(s);
        }
        System.out.println("#############");
        System.out.println(añadirSintoma("escalofríos","2"));
        sintomas = cargarSintomas();
        for(Sintoma s: sintomas){
            System.out.println(s);
        }
    }*/
}
