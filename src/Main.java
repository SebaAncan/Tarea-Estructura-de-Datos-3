import java.util.Scanner;

public class Main {
        static Scanner tcld = new Scanner(System.in);
        static Ciudades redCiudad = new Ciudades();
    public static void main(String[] args){
        menu();
    }


    static void menu(){
        while (true){
            int opcion;
            System.out.println("1- REGISTRAR CIUDAD");
            System.out.println("2- REGISTRAR RUTA");
            System.out.println("3- BUSCAR CONEXION ENTRE CIUDADES");
            System.out.println("4- Buscar el camino mas corto entre 2 ciudades");
            System.out.println("5- Calcular mejores ciudades Gate");
            System.out.println("6- Usar datos pre-definidos");
            System.out.println("7- Salir");
            opcion = tcld.nextInt();
            switch (opcion){
                    case 1:
                        registrarC();
                        break;
                    case 2:
                        registrarR();
                        break;
                    case 3:
                        buscarCon();
                        break;
                     case 4:
                        calcularDj();
                        break;
                    case 5:
                        BuscarG();
                        break;
                    case 6:
                        pruebas();
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Opcion Invalida");
            }


        }
    }

    static void registrarC(){
        System.out.println("Ingrese ID");
        int id = tcld.nextInt();
        tcld.nextLine();
        System.out.println("Ingrese nombre");
        String nombre = tcld.nextLine();
        if (redCiudad.registrarCiudad(id, nombre)){
            System.out.println("Ciudad registrada exitosamente.");
        } else {
            System.out.println("Error: No se pudo registrar la ciudad");
        }
    }

    static void registrarR(){
        System.out.println("Ingrese ID origen");
        int id1 = tcld.nextInt();
        System.out.println("Ingrese ID destino");
        int id2 = tcld.nextInt();
        System.out.println("Ingrese costo de la ruta");
        int costo = tcld.nextInt();
        if (redCiudad.registrarRuta(id1,id2,costo)){
            System.out.println("Registrado exitosamente");
        }else {
            System.out.println("Error al registrar");
        }

    }
    static void buscarCon(){
        System.out.println("Ingrese ID origen");
        int id1 = tcld.nextInt();
        System.out.println("Ingrese ID destino");
        int id2 = tcld.nextInt();
       if (redCiudad.existeConexion(id1,id2)){
           System.out.println("Si existe conexion");
       }else {
           System.out.println("No existe conexion");
       }

    }
    static void calcularDj(){
        System.out.println("Ingrese ID origen");
        int id1 = tcld.nextInt();
        System.out.println("Ingrese ID destino");
        int id2 = tcld.nextInt();
        redCiudad.dijkstra(id1,id2);
    }
    static void BuscarG(){
        System.out.println("Cuantas ciudades gate quiere buscar");
        int k = tcld.nextInt();
        System.out.println("\nCalculando las " + k + " mejores ciudades gate");
        redCiudad.ciudadGate(k);
    }
    static void pruebas(){

        System.out.println("--- REGISTRO DE CIUDADES ---");
        System.out.println("Registrar Cauquenes (ID 0): " + redCiudad.registrarCiudad(0, "Cauquenes"));
        System.out.println("Registrar Chillán (ID 1): " + redCiudad.registrarCiudad(1, "Chillán"));
        System.out.println("Registrar Santiago (ID 2): " + redCiudad.registrarCiudad(2, "Santiago"));
        System.out.println("Registrar San Carlos (ID 3): " + redCiudad.registrarCiudad(3, "San Carlos"));

        // Pruebas de error
        System.out.println("Registrar duplicado en ID 1: " + redCiudad.registrarCiudad(1, "Buchupureo"));
        System.out.println("Costo de ruta inexistente (4 a 5): " + redCiudad.costoRuta(4, 5));

        System.out.println("\n--- REGISTRO DE RUTAS ---");

        // Cauquenes a Santiago directo cuesta 500
        System.out.println("Ruta Cauquenes -> Santiago (costo 500): " + redCiudad.registrarRuta(0, 2, 500));

        // Pero Cauquenes -> Chillán -> Santiago cuesta 300 en total
        System.out.println("Ruta Cauquenes -> Chillán (costo 100): " + redCiudad.registrarRuta(0, 1, 100));
        System.out.println("Ruta Chillán -> Santiago (costo 200): " + redCiudad.registrarRuta(1, 2, 200));

        System.out.println("Ruta Chillán -> San Carlos (costo 50): " + redCiudad.registrarRuta(1, 3, 50));

        // Pruebas de error en rutas
        System.out.println("Ruta con costo negativo (debe dar false): " + redCiudad.registrarRuta(3, 0, -50));
        System.out.println("Ruta hacia sí mismo (debe dar false): " + redCiudad.registrarRuta(0, 0, 10));

        System.out.println("\n--- PRUEBAS DE CONEXIÓN ---");
        System.out.println("Existe conexión desde Cauquenes a San Carlos? 0 a 3: " + redCiudad.existeConexion(0, 3)); // Debe ser true
        System.out.println("Existe conexión desde San Carlos a Cauquenes? 3 a 0: " + redCiudad.existeConexion(3, 0)); // Debe ser false

        System.out.println("\n--- PRUEBA DE DIJKSTRA ---");
        // Debería preferir dar la vuelta por Chillán (Costo 300) en lugar de ir directo 500
        System.out.println("Calculando camino mínimo desde Cauquenes 0 a Santiago 2");
        redCiudad.dijkstra(0, 2);

        System.out.println("\nCalculando las mejores ciudades gate");
        redCiudad.ciudadGate(2);
    }
}