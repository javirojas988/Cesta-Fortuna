public class Concursante {
    private String nombre ; 
    private int premioAcumulado = 0 ; 
    public static final int VALOR_BOLA_B = 100 ; 
    public static final int VALOR_BOLA_A = 200 ;


    public Concursante(String nombre, int premioAcumulado) {
        this.nombre = nombre;
        this.premioAcumulado = premioAcumulado;
    } 
    
    // veo mejor recibir el valor de char y aqui hacer la operacion con if else , con las constantes en private y ya 
    public void sumarPrecio(int cantidad){
        premioAcumulado += cantidad ; 
    }

    public void bancaRota(){
        premioAcumulado = 0 ;
    }
    public int getPremioAcumulado() {
        return premioAcumulado;
    }
    
}
