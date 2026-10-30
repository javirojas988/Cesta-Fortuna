import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static Scanner sc = new Scanner(System.in);

    public static  int lecturaSegura(String frase){
        int respuesta = 2;
        boolean repetir = false ; 

        do {
            repetir = false;
            System.out.print(frase);
            
            try {
                respuesta = sc.nextInt() ; 
                if ( respuesta < 0 ){
                    repetir = true ;
                    System.out.println("Introduce un número positivo");
                }
            } catch (InputMismatchException e) {
                repetir = true ; 
                System.out.println("Introduce un número entero");
                sc.next();
            }
        } while (repetir == true);

        return respuesta ; 
    }

    public static void main(String[] args) throws Exception {
        // int numero = lecturaSegura("prueba: ");
        String nombre ; 
        int opcion ;
        int i = 1 ;
        int cantidad = 0 ;
        boolean pasarTurno ;
        boolean plantarse = false ;
        boolean perdio    = false ;

        Cesta cesta = new Cesta(10, 10, 30);
        
        System.out.println("Bienvenido a cesta fortuna. Juegue si es mayor de 18 y bajo su responsabilidad() ");
        System.out.print("Como se llama: ");
        nombre = sc.nextLine();

        Concursante concu = new Concursante(nombre , 0);

        System.out.printf("Muy bien %s, empezemos \n\n******************************\n\n", nombre);

        while (plantarse == false && perdio == false ){
            
            
            char bola ;

            System.out.println("Turno "+ i );
            System.out.printf("Premio actual %d \n", concu.getPremioAcumulado());
            System.out.printf("Bolas totales %d \n" , cesta.obtenerBolasTotaleS());
            System.out.printf("1. Sacar bola\n2. Plantarse y llevarse el dinero\n");
            opcion = lecturaSegura("Elija una opción: ");
            System.out.println("---------------------------");
            switch (opcion) {
                
                case 1:
                    pasarTurno = true ;
                    bola = cesta.sacarBola();
                    System.out.printf("Bola %s \n", bola);

                    switch (bola) {
                        case 'A':
                            concu.sumarPrecio(Concursante.VALOR_BOLA_A);
                            break;
                        case 'B':
                            concu.sumarPrecio(Concursante.VALOR_BOLA_B);
                            break;
                        case 'N':
                            System.out.println("Mua Mua Muaaaa");
                            System.out.println("Greed");
                            perdio = true ; 
                            break;
                    }
                    break;

                case 2:
                    plantarse = true ;
                    pasarTurno = true;
                    System.out.println("Gracias por participar");
                    System.out.println("Premio conseguido: "+ concu.getPremioAcumulado());
                    break;
                default:
                    pasarTurno = false;
                    System.out.println("Elija una opción válida");
                    break;
            }
            if ( cesta.getBolasAzules() == 0 && cesta.getBolasBlancas() == 0 ){
                System.out.println("No quedan más bolas azules o blancas, has ganado, enhorabuena\n Has dejado el programa en banca rota");
                plantarse = true; 
            }
            if ( pasarTurno == true){
                i++;
            }
        }
        
    }
}
