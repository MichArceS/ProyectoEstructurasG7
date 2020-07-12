package ec.edu.espol.system;

//<<<<<<< HEAD
import ec.edu.espol.common.*;
//=======
//>>>>>>> 76a2a74796b79431e135fa07aa631d8ba5e6d878
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
    //private static PriorityQueue<UsrPaciente> pacientes;
    private static List<UsrMedico> medicosRegistrados;
    private static PriorityQueue<Puesto> puestos;
    private static CircularSimplyLinkedList<Video> videos;
    private static List<Sintoma> sintomasActuales;

    public SysData(){
        //pacientes = new PriorityQueue<>();
        medicosRegistrados = LeerEscribirDatos.cargarMedicos();
        puestos = new PriorityQueue<>((Puesto p1, Puesto p2)->p1.getMedico().getPacientesXatender().size()-p2.getMedico().getPacientesXatender().size());
        puestos.addAll(LeerEscribirDatos.cargarPuestos(medicosRegistrados));
        sintomasActuales = LeerEscribirDatos.cargarSintomas();
        videos = new CircularSimplyLinkedList<>();
    }

    public static void addMedico(UsrMedico med){
        medicosRegistrados.add(med);
    }

    /*public static void addPaciente(UsrPaciente pac){
        pacientes.offer(pac);
    }*/

    public static void cargarVideos() {
        videos = LeerEscribirDatos.cargarVideos();
    }

    private void añadirInfo(){
        addMedico(new UsrMedico("Jose","Alban",35, Genero.MASCULINO, Especialidad.MEDICINA_GENERAL,"josealb@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Bruce","Banner",42, Genero.MASCULINO, Especialidad.PSIQUIATRIA,"bruban@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Peppa","Pig",29, Genero.FEMENINO, Especialidad.PEDIATRIA,"pepapi@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Tony","Stark",32, Genero.MASCULINO, Especialidad.CARDIOLOGIA,"tonyst@espol.edu.ec","1234"));
        addMedico(new UsrMedico("Tony","Stark",32, Genero.MASCULINO, Especialidad.CARDIOLOGIA,"root","admin"));

        /*addPaciente(new UsrPaciente("Natasha","Romanov",31,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Mary","Jane",28,Genero.FEMENINO));
        addPaciente(new UsrPaciente("Peter","Parker",21,Genero.MASCULINO));
        addPaciente(new UsrPaciente("Barry","Allen",25,Genero.MASCULINO));*/

        cargarVideos();
    }


    public static UsrMedico iniciarSesion(String usuario, String contrasenia){
        for (UsrMedico m: medicosRegistrados){
            if(m.verificarUsuario(usuario, contrasenia))
                return m;
        }
        return null;
    }

    public static Puesto ingresarPaciente(UsrPaciente p){
        Puesto puesto = puestos.poll();
        puesto.getMedico().getPacientesXatender().offer(p);
        puestos.offer(puesto);
        return puesto;
    }

    //SIMULACION EN CONSOLA
    private static void menuMedico(UsrMedico m){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String opcion = "";
        while(!opcion.equals("2")){
            System.out.println("Medico " + m.getNombre() + " " + m.getApellido());
            System.out.println("1. Siguiente Turno\n" +
                    "2. Cerrar Sesión");
            System.out.print("Ingrese su opción: ");
            opcion = sc.next();
            switch (opcion){
                case "1":
                    if(!m.getPacientesXatender().isEmpty()){
                        UsrPaciente p = m.atenderPaciente();
                        System.out.println("Paciente: " + p.getNombre() + " " + p.getApellido());
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Prioridad de Sintoma: " + p.getSintoma().getPrioridad());
                        System.out.print("Ingrese Diagnostico: ");
                        String diag = sc.next();
                        System.out.print("Ingrese Receta: ");
                        String rec = sc.next();
                        Consulta c = new Consulta(m,p,diag,rec);
                        LeerEscribirDatos.registrarConsulta(c);
                    }else
                        System.out.println("No tiene pacientes por atender");
                    break;
                case "2":
                    simulacion();
                    break;
                default:
                    System.out.println("Ingrese una opción correcta: ");
            }
        }
    }

    private static void simulacion(){
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        String opcion="";
        while(!opcion.equals("6")){
            System.out.println("SIMULACION SISTEMA CLINICO");
            System.out.println("1. Ventana Turnos\n" +
                    "2. Ingresar Paciente\n" +
                    "3. Agregar Medico\n" +
                    "4. Ingresar como Medico\n" +
                    "5. Supongo que puestos :v\n" +
                    "6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = sc.next();
            switch (opcion){
                case "1":
                    break;
                case "2":
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.next();
                    System.out.print("Ingrese apellido: ");
                    String apellido = sc.next();
                    System.out.print("Ingrese su edad: ");
                    int edad = sc.nextInt();
                    System.out.print("Ingrese su genero: ");
                    Genero gen = Genero.valueOf(sc.next());
                    System.out.print("Ingrese nombre de sintoma: ");
                    String nSin = sc.next();
                    System.out.print("Ingrese la prioridad: ");
                    int prior = sc.nextInt();
                    Sintoma s = new Sintoma(nSin, prior);
                    UsrPaciente paciente = new UsrPaciente(nombre,apellido,edad,gen,s);
                    Puesto p = ingresarPaciente(paciente);
                    System.out.println("Se le ha derivado al puesto " + p.getNumPuesto() + " con el medico " + p.getMedico().getNombre() + " " + p.getMedico().getApellido());
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
