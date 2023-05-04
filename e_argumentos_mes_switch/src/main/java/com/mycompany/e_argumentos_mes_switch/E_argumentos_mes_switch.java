
package com.mycompany.e_argumentos_mes_switch;

/**
 *
 * @author damci
 */

public class E_argumentos_mes_switch
{
    public static void main(String[] args) 
    {
    int dias=0;
    String mes=args[0];
    String mesLower=mes.toLowerCase();
    //String mesUpper=mes.toUpperCase();
     
        switch (mesLower)
        
            {
            case "enero","marzo","mayo","julio","agosto","octubre","diciembre": dias=31;
                //String mesUpper=mes.toUpperCase();
                //System.out.println(mesLowerCap +" tiene " +dias +" dias");
            break;
            case "febrero": dias=28;
                 //System.out.println(mesUpper +" tiene " +dias +" dias"); 
                //System.out.println(mesLowerCap +" tiene " +dias +" dias");
            break;
            case "abril","jumio","septiembre","noviembre": dias=30;
                //System.out.println(mesUpper +" tiene " +dias +" dias"); 
                //System.out.println(mesLowerCap +" tiene " +dias +" dias");
            break;
            default: dias=-1;
                //System.out.println("Mes no válido");
            break;
            }
    
            //String mesLowerCap=mesLower.toUpperCase().charAt(0) +mes.substring(1, mesLower.length()).toLowerCase();
            String mesLowerCap=mesLower.substring(0,1).toUpperCase()+mesLower.substring(1);
            
            if (dias != -1)
                {
                    System.out.println(mesLowerCap +" tiene " +dias +" dias");
                }
            else
                {
                    System.out.println("Mes no válido");
                }
        
    }
}



