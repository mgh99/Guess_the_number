
import AdivinhaNumeroApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;


public class Client {

    static AdivinhaNumero animpl;






    public static void main(String args[]){
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


    try{
        ORB orb = ORB.init(args, null);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        String name = "AdivinhaNumero";
        animpl = AdivinhaNumeroHelper.narrow(ncRef.resolve_str(name));


        int myid = animpl.identifica(); //identifica o cliente
        int resultado = animpl.retornaresultado(); //devuelve el resultado del juego

	    System.out.println(resultado); //imprime el resultado

        int tentativa = 0; //numero de intentos
        int x = animpl.inicio(); //indica si el juego ha comenzado
        int conferir = 0; //numero a adivinar

        while (x == 0){ 
            int valor = in.nextInt(); //valor introducido por el usuario
            tentativa ++; //incrementa el numero de intentos


            conferir = animpl.verifica(myid, valor); //verifica si el numero introducido es correcto

            if(conferir == 0){
                System.out.println("HAS GANADO");
                x = 1;
            }else{
                System.out.println("ERROR :<");
            }      
        }
    
    }catch (Exception e){
        System.err.println("Erro: " + e );
    }


}
}
