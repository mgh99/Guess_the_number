
import AdivinhaNumeroApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;

public class Client {

    static AdivinhaNumero animpl;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Thread jogar = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread conectar = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        try {
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "AdivinhaNumero";
            animpl = AdivinhaNumeroHelper.narrow(ncRef.resolve_str(name));

            int myid = animpl.identifica(); // identifica el cliente
            int resultado = animpl.retornaresultado(); // devuelve el resultado del juego

            /*
             * System.out.println(resultado); //imprime el resultado
             * 
             * int tentativa = 0; //numero de intentos
             * int x = animpl.inicio(); //indica si el juego ha comenzado
             * int conferir = 0; //numero a adivinar
             * 
             * while (x == 0){
             * int valor = in.nextInt(); //valor introducido por el usuario
             * tentativa ++; //incrementa el numero de intentos
             * 
             * 
             * conferir = animpl.verifica(myid, valor); //verifica si el numero introducido
             * es correcto
             * 
             * if(conferir == 0){
             * System.out.println("HAS GANADO");
             * x = 1;
             * }else{
             * System.out.println("ERROR :<");
             * }
             * }
             */

            int numAleatorio = (int) ((Math.random() * 100) + 1); // numero aleatorio del 1 al 100
            int numUser; // numero introducido por el usuario
            int contador = animpl.inicio(); // contador de intentos

            System.out.println("Adivina el numero del 1 al 100");
            System.out.print("Tienes 5 intentos, dime un numero entre el 1 y el 100: ");
            numUser = in.nextInt();

            for (contador = 0; contador <= 4; contador++) {

                numAleatorio = animpl.verifica(myid, numUser); // verifica si el numero introducido es correcto

                // Primero comprobamos si ha acertado
                if (numAleatorio == numUser) {
                    System.out.println(" ");
                    System.out.println("Otra oportunidad!!, ESPERA NOOO, HAS GANADOOO!!!");
                    System.out.println("Has acertado el numero es: " + numAleatorio);
                    break;
                }

                // Si no ha acertado comprobamos si es mayor o menor
                if (numAleatorio > numUser) {
                    System.out.println(" ");
                    System.out.println("El numero es mayor que " + numUser);
                } else if (numAleatorio < numUser) {
                    System.out.println(" ");
                    System.out.println("El numero es menor que " + numUser);
                }

                // Cuando solo le queda un intento dar una pista
                if (contador <= 1) {
                    System.out.println(" ");
                    System.out.println("Te quedan " + (4 - contador) + " intentos");
                    System.out.print("Otra opurtunidad!: ");
                    numUser = in.nextInt();
                } else if (contador == 2) {
                    System.out.println(" ");
                    int x = numAleatorio / 10;
                    System.out.println("Una pista, la primera cifra es " + x);
                    System.out.print("Otra opurtunidad!: ");
                    numUser = in.nextInt();
                } else if (contador >= 3) {
                    System.out.println(" ");
                    System.out.println("Otra opurtunidad!");
                    System.out.print("Oh, oh..., ULTIMA OPURTUNIDAD!: ");
                    numUser = in.nextInt();
                }

                // Si ha gastado todos los intentos
                if (contador == 4) {
                    System.out.println(" ");
                    System.out.println("Has perdido, el numero era: " + numAleatorio);
                    break;
                }
            }

        } catch (Exception e) {
            System.err.println("Erro: " + e);
        }

    }
}
