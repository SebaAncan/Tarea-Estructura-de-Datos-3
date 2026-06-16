public class Ciudades {
    int[][] grafoDestinos;
    String[] nombreCiudad;
    boolean gate;
    int N;
    //Use la misma estructra del lab pq se ven similares
    Ciudades(){
        this.N = 100;
        this.grafoDestinos = new int[N][N];

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


}
