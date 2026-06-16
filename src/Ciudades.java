public class Ciudades {
    int[][] grafoDestinos;
    String[] nombreCiudad;
    boolean gate;
    int N;
    //Use la misma estructra del lab pq se ven similares
    Ciudades(){
        this.N = 100;
        this.grafoDestinos = new int[N][N];
        this.nombreCiudad = new String[N];

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
            visitados[i] = 0;//no visitao
        }
        boolean exito = buscar(idOrigen,idDestino,visitados);
        return exito;
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

    //Agregar coso para imprimir el arreglo


}
