import AdivinhaNumeroApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.*;

import java.util.Properties;

class AdivinhaNumeroImpl extends AdivinhaNumeroPOA {
    private ORB orb;


    Random n = new Random();
    public int a = 0;
    public int contador = 0;
    public int vencedor = 0;
    public int result = 0;

	public void setORB(ORB orb_val) {
		orb = orb_val;
	}

    

    public int retornaresultado (){
        result = n.nextInt(6);
        return result;
    }

    public int identifica(){
        contador++;
        return n.nextInt(1000);
    }

    public int inicio(){
        return a;
    }

    public int verifica(int id, int tentativa){
        if((tentativa == result )&&(a == 0)){
            a = 1;
            vencedor = id;
            contador--;
            return 0; 
        }
        return 1;

    }
}





public class Server {

    public static void main(String args[]){

    try{
        ORB orb = ORB.init(args, null);

        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        AdivinhaNumeroImpl cc = new AdivinhaNumeroImpl();
        cc.setORB(orb);    


        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(cc);
        AdivinhaNumero href = AdivinhaNumeroHelper.narrow(ref); 


        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        String name = "AdivinhaNumero";
        NameComponent path[] = ncRef.to_name(name);
        ncRef.rebind(path, href);

        orb.run();    



    }catch (Exception e){
        System.err.println("Erro: " + e );
    }

    }
}
