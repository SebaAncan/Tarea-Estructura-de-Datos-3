public class Main {
    public static void main(String[] args){
        Ciudades redCiudad = new Ciudades();

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
        System.out.println("¿Existe conexión desde Cauquenes a San Carlos? (0 a 3): " + redCiudad.existeConexion(0, 3)); // Debe ser true
        System.out.println("¿Existe conexión desde San Carlos a Cauquenes? (3 a 0): " + redCiudad.existeConexion(3, 0)); // Debe ser false

        System.out.println("\n--- PRUEBA DE DIJKSTRA ---");
        // Debería preferir dar la vuelta por Chillán (Costo 300) en lugar de ir directo 500
        System.out.println("Calculando camino mínimo desde Cauquenes (0) a Santiago (2)...");
        redCiudad.dijkstra(0, 2);

        // Al final de tu public static void main...
        System.out.println("\nCalculando las mejores ciudades para instalar centros de abastecimiento...");
        redCiudad.ciudadGate(2);
    }
}