package ec.edu.espol.util;

import ec.edu.espol.common.*;
import ec.edu.espol.constants.Constantes;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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
    public static void cargarMedicos(PriorityQueue<UsrMedico> medicosRegistrados){
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTAMEDICOS))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("\\|");
                medicosRegistrados.offer(new UsrMedico(data[0],data[1],Integer.valueOf(data[2]),Genero.valueOf(data[3]),Especialidad.valueOf(data[4]),String.valueOf(data[5]),String.valueOf(data[6])));
                line = br.readLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
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

    //VIDEOS
    public static CircularSimplyLinkedList<Video> cargarVideos(){
        CircularSimplyLinkedList<Video> videos = new CircularSimplyLinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(Constantes.RUTAVIDEOS))){
            String line = br.readLine();
            while(line != null){
                String[] data = line.split("-");
                long l = Integer.parseInt(data[2]);
                videos.addLast(new Video(data[0],data[1],l));
                line = br.readLine();
            }
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return videos;
    }

    //CONSULTAS
    public static boolean registrarConsulta(Consulta c){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Constantes.RUTACONSULTAS,true))){
            String line = "Medico: " + c.getMedico().getNombre() + " " + c.getMedico().getApellido() + " | " +
                          "Paciente: " + c.getPaciente().getNombre() + " " + c.getPaciente().getApellido() + " | " +
                          "Fecha: " + LocalDate.now() + " | " +
                          "Hora: " + LocalDateTime.now().getHour() + "h" + LocalDateTime.now().getMinute() + " | " +
                          "Diagnostico: " + c.getDiagnostico() + " | " +
                          "Receta: " + c.getReceta() + "\n";
            bw.write(line);
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }

    //PUESTOS
    public static List<Puesto> cargarPuestos(List<UsrMedico> medicos){
        List<Puesto> puestos = new LinkedList<>();
        for(UsrMedico m: medicos){
            puestos.add(new Puesto(m));
        }
        return puestos;
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
        System.out.println(registrarConsulta(new Consulta(new UsrMedico("a","b",15,Genero.MASCULINO,Especialidad.CARDIOLOGIA, "sdsds","dsdsds"), new UsrPaciente("aaa","bbb",21,Genero.FEMENINO,new Sintoma("fiebre",1)),"diagnostico","receta")));
    }*/
}
