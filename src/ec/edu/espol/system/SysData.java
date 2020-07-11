package ec.edu.espol.system;

import ec.edu.espol.common.Sintoma;
import ec.edu.espol.common.UsrMedico;
import ec.edu.espol.common.UsrPaciente;
import ec.edu.espol.common.Usuario;
import ec.edu.espol.constants.Especialidad;
import ec.edu.espol.constants.Genero;
import ec.edu.espol.util.CircularSimplyLinkedList;
import ec.edu.espol.util.LeerEscribirDatos;
import ec.edu.espol.util.Video;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SysData {
    private static PriorityQueue<UsrPaciente> pacientes;
    private static List<UsrMedico> medicos;
    private static CircularSimplyLinkedList<Video> videos;
    //private static LinkedList<Usuario> usuarios;
    private static List<Sintoma> sintomasActuales;

    public SysData(){
        pacientes = new PriorityQueue<>();
        medicos = LeerEscribirDatos.cargarMedicos();
        sintomasActuales = LeerEscribirDatos.cargarSintomas();
        videos = new CircularSimplyLinkedList<>();
        //usuarios = new LinkedList<>();
    }

    public static void addMedico(UsrMedico med){
        medicos.add(med);
    }

    public static void addPaciente(UsrPaciente pac){
        pacientes.offer(pac);
    }

    private void añadirInfo(){
        addMedico(new UsrMedico("Jose","Alban",35, Genero.MASCULINO, Especialidad.MEDICINA_GENERAL));
        addMedico(new UsrMedico("Bruce","Banner",42, Genero.MASCULINO, Especialidad.PSIQUIATRIA));
        addMedico(new UsrMedico("Peppa","Pig",29, Genero.FEMENINO, Especialidad.PEDIATRIA));
        addMedico(new UsrMedico("Tony","Stark",32, Genero.MASCULINO, Especialidad.CARDIOLOGIA));

        addPaciente(new UsrPaciente("Natasha","Romanov",31,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Mary","Jane",28,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Peter","Parker",21,Genero.MASCULINO));
        addPaciente(new UsrPaciente("Barry","Allen",25,Genero.MASCULINO));

    }

    //SIMULACION EN CONSOLA


    private static void simulacion(){
        Scanner sc = new Scanner(System.in);
        String opcion = sc.next();
        System.out.println("SIMULACION SISTEMA CLINICO");
        System.out.println("1. Ventana Turnos\n" +
                           "2. Ingresar Paciente\n" +
                           "3. Agregar Medico\n" +
                           "4. ");
        while(opcion!="6"){
            switch (opcion){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case"5":
                    break;
                default:
                    System.out.println("Ingrese una opción correcta: ");

            }
        }
    }

    public void main(String[] args){
        simulacion();
    }

}
