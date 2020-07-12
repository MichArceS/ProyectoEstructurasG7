package ec.edu.espol.system;

//<<<<<<< HEAD
import ec.edu.espol.common.Sintoma;
//=======
import ec.edu.espol.common.Puesto;
//>>>>>>> 76a2a74796b79431e135fa07aa631d8ba5e6d878
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
    private static List<UsrMedico> medicosRegistrados;
    private static LinkedList<Puesto> puestos;
    private static CircularSimplyLinkedList<Video> videos;
    private static List<Sintoma> sintomasActuales;

    public SysData(){
        pacientes = new PriorityQueue<>();
        medicosRegistrados = LeerEscribirDatos.cargarMedicos();
        sintomasActuales = LeerEscribirDatos.cargarSintomas();
        videos = new CircularSimplyLinkedList<>();
        //usuarios = new LinkedList<>();
    }

    public static void addMedico(UsrMedico med){
        medicosRegistrados.add(med);
    }

    public static void addPaciente(UsrPaciente pac){
        pacientes.offer(pac);
    }

    public static void cargarVideos() {
        videos = LeerEscribirDatos.cargarVideos();
    }

    private void añadirInfo(){
        addMedico(new UsrMedico("Jose","Alban",35, Genero.MASCULINO, Especialidad.MEDICINA_GENERAL,"josealb@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Bruce","Banner",42, Genero.MASCULINO, Especialidad.PSIQUIATRIA,"bruban@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Peppa","Pig",29, Genero.FEMENINO, Especialidad.PEDIATRIA,"pepapi@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Tony","Stark",32, Genero.MASCULINO, Especialidad.CARDIOLOGIA,"tonyst@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Tony","Stark",32, Genero.MASCULINO, Especialidad.CARDIOLOGIA,"root","admin"));

        addPaciente(new UsrPaciente("Natasha","Romanov",31,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Mary","Jane",28,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Peter","Parker",21,Genero.MASCULINO));
        addPaciente(new UsrPaciente("Barry","Allen",25,Genero.MASCULINO));

        cargarVideos();
    }

    public static UsrMedico iniciarSesion(String usuario, String contrasenia){
        for (UsrMedico m: medicosRegistrados){
            if(m.verificarUsuario(usuario, contrasenia))
                return m;
        }
        return null;
    }

    //SIMULACION EN CONSOLA

    private static void menuMedico(UsrMedico m){
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        while(!opcion.equals("2")){
            System.out.println("Medico " + m.getNombre() + " " + m.getApellido());
            System.out.println("1. Siguiente Turno\n" +
                    "2. Cerrar Sesión");
            System.out.print("Ingrese su opción: ");
            opcion = sc.next();
            switch (opcion){
                case "1":
                    break;
                case "2":
                    simulacion();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta: ");
            }
        }
    }

    public static void simulacion(){
        Scanner sc = new Scanner(System.in);
        String opcion="";
        while(!opcion.equals("6")){
            System.out.println("SIMULACION SISTEMA CLINICO");
            System.out.println("1. Ventana Turnos\n" +
                    "2. Ingresar Paciente\n" +
                    "3. Agregar Medico\n" +
                    "4. Ingresar como Medico\n" +
                    "5. Supongo que turnos :v\n" +
                    "6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.next();
            switch (opcion){
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    System.out.print("Ingrese su usuario: ");
                    String scUsuario = sc.next();
                    System.out.print("Ingrese su contraseña: ");
                    String scContraseña = sc.next();
                    UsrMedico m = iniciarSesion(scUsuario, scContraseña);
                    if(m!=null)
                        menuMedico(m);
                    else
                        System.out.println("Usuario incorrecto");
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Ingrese una opción correcta ");
            }
        }
    }

    public static void main(String[] args){
        SysData sistema = new SysData();
        simulacion();
    }

}
