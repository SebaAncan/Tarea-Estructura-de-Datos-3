import java.awt.*;

public class Ciudades {
    //Gerardo Guíñez y Sebastián ...
    int[][] grafoDestinos;
    String[] nombreCiudad;
    boolean gate;
    int N;
    //Use la misma estructra del lab pq se ven similares
    Ciudades(){
        this.N = 100;
        this.grafoDestinos = new int[N][N];
        this.nombreCiudad = new String[N];
        inicializar();
    }

    void inicializar(){
        for(int i = 0;i <N;i++){
            for (int j = 0; j<N;j++){
                grafoDestinos[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    boolean registrarCiudad(int id, String  nombre){
        if (id < 0 || id >= N) {
            return false;
        }
        if (nombreCiudad[id] != null){
            return false;
        }

        nombreCiudad[id] = nombre;
        return true;
    }

    boolean registrarRuta(int idOrigen,int idDestino,int costo){
        if (!verificadores(idOrigen,idDestino)){
            return false;
        }
        if (nombreCiudad[idDestino] == null || nombreCiudad[idOrigen] == null){
            return false;
        }

        if (grafoDestinos[idOrigen][idDestino] != Integer.MAX_VALUE){
            return false;
        }
        if (costo < 0){
            return false;
        }

        grafoDestinos[idOrigen][idDestino] = costo;
        return true;
    }

    boolean verificadores(int idOrigen,int idDestino){
        if (idOrigen < 0 || idOrigen >= N){
            return false;
        }
        if (idDestino <0 || idDestino >= N){
            return false;
        }
        if (idDestino == idOrigen){
            return false;
        }

        return true;
    }

    int costoRuta(int idOrigen, int idDestino) {
        if (grafoDestinos[idOrigen][idDestino] == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else {
            return grafoDestinos[idOrigen][idDestino];
        }
    }

    boolean existeConexion(int idOrigen,int idDestino){
        if (!verificadores(idOrigen,idDestino)){
            return false;
        }

        int[] visitados = new int[N];

        for (int i = 0; i<N;i++){
            visitados[i] = 0;//no visitado
        }

        return buscar(idOrigen,idDestino,visitados);
    }

    private boolean buscar(int idOrigen,int idDestino,int[] visitados){
        if (idOrigen == idDestino){
            return true; //Llegamo
        }

        visitados[idOrigen] = 1; //visitao
        for (int i = 0; i< N;i++){
            if (grafoDestinos[idOrigen][i] != Integer.MAX_VALUE && visitados[i] == 0){
                if (buscar(i,idDestino,visitados)){
                    return true;
                }
            }
        }
        return false;
    }

    //implementar algoritmo de Djriska para la distancia mas corta
    public void dijkstra(int idOrigen,int idDestino){
        if (!verificadores(idOrigen,idDestino)){
            System.out.println("invalido");
            return;
        }
        int[] distancias = new int[N];
        int[] visitado = new int[N];
        int[] padre = new int[N];
        int i = 0;
        for (i = 0;i<N;i++){
            distancias[i] = Integer.MAX_VALUE;
            visitado[i] = 0;//0 false, 1 true
            padre[i] = -1; //no predecesor
        }
        distancias[idOrigen] = 0;

        for (i = 0; i<N;i++){ //buscamos q no hayamos visitado
            int x = -1;
            int minimo = Integer.MAX_VALUE;
            for (int j = 0; j<N;j++){
                if (visitado[j] == 0 && distancias[j] < minimo){
                    minimo = distancias[j];
                    x = j;
                }
            }

            //no encontramo o ya llegamo
            if (x == -1 || x == idDestino){
                break;
            }
            visitado[x] = 1;
            for (int v = 0 ; v<N;v++){
                if (visitado[v] == 0 && grafoDestinos[x][v] != Integer.MAX_VALUE){
                    int costo = distancias[x] + grafoDestinos[x][v];
                    if (costo < distancias[v]){
                        distancias[v] = costo;
                        padre[v] = x;
                    }
                }
            }
        }
        if (distancias[idDestino] == Integer.MAX_VALUE)
        {
            System.out.println("No existe un camino :c");
        }else{
            imprimirCaminoCorto(idOrigen,idDestino,padre,distancias[idDestino]);
        }
    }
    //Agregar coso para imprimir el arreglo
    public void imprimirCaminoCorto(int idOrigen,int idDestino,int[] padre,int distanciaMin){
        System.out.println("Distancia minima para ir de la ciudad " + idOrigen + " A " + idDestino + " es " + distanciaMin);
        String ruta = "";
        int actual = idDestino;
        while (actual != -1){
            if (ruta.equals("")){
                ruta = String.valueOf(actual);
            }else{
                ruta = actual + "-> " + ruta;
            }
            actual = padre[actual];
        }
        System.out.println("El camino para ir de la ciudad " + idOrigen + " a la " + idDestino + " es: " + ruta);

        /*if(idOrigen < 0 || idOrigen >= N || nombreCiudad[idOrigen] == null){
            System.out.println("No existe :c");
            return;
        }

        int[] distancias = dijkstra(idOrigen);

        System.out.println("Caminos más cortos: " + nombreCiudad[idOrigen] + "ID: " + idOrigen);

        for(int i  = 0; i < N; i++){
            System.out.println("Hacia: " + nombreCiudad[i] + "ID: " + i);

            if(distancias[i] != Integer.MAX_VALUE){
                System.out.println(distancias[i] + " km/pesos");
            } else{
                System.out.println("No existe ruta");
            }
        }

         */
    }

}
