package ec.edu.espol.util;

import ec.edu.espol.common.*;
import ec.edu.espol.constants.Constantes;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class LeerEscribirDatos {

    //SINTOMAS
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

    public static boolean añadirSintoma(Sintoma s){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.RUTASINTOMAS,true))){
            String line = s.getNombre() + "|" + s.getPrioridad();
            bw.newLine();
            bw.write(line);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    //MEDICOS
    public static List<UsrMedico> cargarMedicos(){
        List<UsrMedico> medicos = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTAMEDICOS))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("\\|");
                medicos.add(new UsrMedico(data[0],data[1],Integer.valueOf(data[2]),Genero.valueOf(data[3]),Especialidad.valueOf(data[4])));
                line = br.readLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return medicos;
    }

    public static boolean añadirMedico(UsrMedico m){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.RUTAMEDICOS,true))){
            String line = m.getNombre() + "|" + m.getApellido() + "|" + m.getEdad() + "|" + m.getGenero().toString() + "|" + m.getEspecialidad().toString();
            bw.newLine();
            bw.write(line);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    //Videos
    public static CircularSimplyLinkedList<Video> cargarVideos(){
        CircularSimplyLinkedList<Video> videos = new CircularSimplyLinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTAVIDEOS))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("-");
                long l = Integer.parseInt(data[2]);
                System.out.println(l);
                videos.addLast(new Video(data[0],data[1],l));
                line = br.readLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return videos;
    }


    /*public static void main(String[] args){
        List<Sintoma> sintomas = cargarSintomas();
        //System.out.println(sintomas.size());
        for(Sintoma s: sintomas){
            System.out.println(s);
        }
        System.out.println("#############");
        System.out.println(añadirSintoma(new Sintoma("dolor de cabeza",4)));
        sintomas = cargarSintomas();
        for(Sintoma s: sintomas){
            System.out.println(s);
        }

        List<UsrMedico> medicos = cargarMedicos();
        for(UsrMedico m: medicos){
            System.out.println(m);
        }
        System.out.println("#############");
        System.out.println(añadirMedico(new UsrMedico("Juanito","Alcachofa",31,Genero.MASCULINO,Especialidad.PEDIATRIA)));
        medicos = cargarMedicos();
        for(UsrMedico m: medicos){
            System.out.println(m);
        }
    }*/
}
