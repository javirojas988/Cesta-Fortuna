import java.util.Random;

public class Cesta {
    private int bolasBlancas ; 
    private int bolasAzules  ; 
    private int bolasNegras ; 

    public Cesta(int bolasAzules , int bolasBlancas , int bolasNegras){
        this.bolasAzules = bolasAzules ; 
        this.bolasNegras = bolasNegras ; 
        this.bolasBlancas = bolasBlancas ; 
    }

    public int obtenerBolasTotaleS(){
        int bolasTotales = bolasAzules + bolasNegras + bolasBlancas ;
        return  bolasTotales ; 
    }

    public char sacarBola() {
        char bola = extraerBola(bolasNegras, bolasAzules, bolasBlancas);
        if ( bola == 'A'){
            bolasAzules -= 1 ;
        } else if ( bola == 'B') {
            bolasBlancas -= 1 ;
        } else {
            bolasNegras -= 1 ; 
        }
        return bola ; 
    }

    public static char extraerBola(int a , int b , int n ){
        Random rand = new Random() ; 
        int totalBolas= a+b+n ;
        
        //bolsa vacia 
        if ( totalBolas == 0 ) return 'V';

        // genera un numero entre 1 y el total de bolas restantes 
        int tirada = rand.nextInt(totalBolas)+1;

        // lógica de rangos de probabilidad 
        if ( tirada <= b ){
            return 'B' ;
        } else if ( tirada == b + a ){
            return 'A' ; 
        } else {
            return 'N';
        }
    }

    public int getBolasAzules() {
        return bolasAzules;
    }
    public int getBolasBlancas() {
        return bolasBlancas;
    }
    public int getBolasNegras() {
        return bolasNegras;
    }
}

