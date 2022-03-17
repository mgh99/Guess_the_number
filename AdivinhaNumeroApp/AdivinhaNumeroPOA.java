package AdivinhaNumeroApp;


/**
* AdivinhaNumeroApp/AdivinhaNumeroPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from AdivinhaNumero.idl
* jueves 17 de marzo de 2022 04H01' CET
*/

public abstract class AdivinhaNumeroPOA extends org.omg.PortableServer.Servant
 implements AdivinhaNumeroApp.AdivinhaNumeroOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("identifica", new java.lang.Integer (0));
    _methods.put ("retornaresultado", new java.lang.Integer (1));
    _methods.put ("inicio", new java.lang.Integer (2));
    _methods.put ("verifica", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // AdivinhaNumeroApp/AdivinhaNumero/identifica
       {
         int $result = (int)0;
         $result = this.identifica ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // AdivinhaNumeroApp/AdivinhaNumero/retornaresultado
       {
         int $result = (int)0;
         $result = this.retornaresultado ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // AdivinhaNumeroApp/AdivinhaNumero/inicio
       {
         int $result = (int)0;
         $result = this.inicio ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 3:  // AdivinhaNumeroApp/AdivinhaNumero/verifica
       {
         int id = in.read_long ();
         int tentativa = in.read_long ();
         int $result = (int)0;
         $result = this.verifica (id, tentativa);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:AdivinhaNumeroApp/AdivinhaNumero:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public AdivinhaNumero _this() 
  {
    return AdivinhaNumeroHelper.narrow(
    super._this_object());
  }

  public AdivinhaNumero _this(org.omg.CORBA.ORB orb) 
  {
    return AdivinhaNumeroHelper.narrow(
    super._this_object(orb));
  }


} // class AdivinhaNumeroPOA
