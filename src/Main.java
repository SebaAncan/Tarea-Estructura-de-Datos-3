public class Main {
    public static void main(String[] args){
        Ciudades redCiudad = new Ciudades();

        System.out.println("Registrar Cauquene (ID 0): " + redCiudad.registrarCiudad(0, "Cauquene"));
        System.out.println("Registrar Chillán (ID 1): " + redCiudad.registrarCiudad(1, "Chillán"));
        System.out.println("Registrar Santiago (ID 2): " + redCiudad.registrarCiudad(2, "Santiago"));
        System.out.println("Registrar San Carlos (ID 3): " + redCiudad.registrarCiudad(3, "San Carlos"));

        // Id ya ocupada
        System.out.println("Registrar duplicado en ID 1: " + redCiudad.registrarCiudad(1, "Buchupureo"));
        //Id no existe
        System.out.println("Registrar id no existe: " + redCiudad.costoRuta(4, 5));

        System.out.println("Ruta Cauquene -> Santiago (costo " + redCiudad.costoRuta(0, 2) + "): "
                + redCiudad.registrarRuta(0, 2, redCiudad.costoRuta(0, 2)));

        System.out.println("Ruta Chillán -> San Carlos (costo " + redCiudad.costoRuta(1, 3) + "): "
                + redCiudad.registrarRuta(1, 3, redCiudad.costoRuta(1, 0)));

        System.out.println("Ruta Chillán -> Cauquene (costo " + redCiudad.costoRuta(1, 0) + "): "
                + redCiudad.registrarRuta(1, 0, redCiudad.costoRuta(1, 0)));

        System.out.println("Ruta San Carlos -> Cauquene (costo " + redCiudad.costoRuta(0, 2) + "): "
                + redCiudad.registrarRuta(0, 2, redCiudad.costoRuta(3, 0)));

        // ruta con costo negativo (debe dar false)
        System.out.println(redCiudad.registrarRuta(3, 0, -50));

        //id0rigen = idDestino = 0;
        System.out.println(redCiudad.registrarRuta(0, 0, redCiudad.costoRuta(0,0)));

        //probar existeConexion() //arreglar
        System.out.println("¿Existe conexión desde Concepción a San Carlos?: " + redCiudad.existeConexion(1, 2)); // Debe ser true
        System.out.println("¿Existe conexión desde San Carlos a Concepción?: " + redCiudad.existeConexion(3, 0)); // Debe ser false

        //probar Dijkstra
    }
}
