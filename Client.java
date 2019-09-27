
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


        int myid = animpl.identifica(); //passa meu ID
        int resultado = animpl.retornaresultado(); //passa o numero para acertar

	    System.out.println(resultado); // HACK

        int tentativa = 0; // conta as tentativas
        int x = animpl.inicio(); // inidica q inicia o jogo
        int conferir = 0; // pega o retorno do quando verifica

        while (x == 0){ 
            int valor = in.nextInt(); // le o valor do chute
            tentativa ++; // conta a tentativa


            conferir = animpl.verifica(myid, valor); // verifica se tu acertou primeiro

            if(conferir == 0){
                System.out.println("Vc ganhou!");
                x = 1;
            }else{
                System.out.println("Errou :<");
            }      
        }
    
        




    }catch (Exception e){
        System.err.println("Erro: " + e );
    }


}
}
