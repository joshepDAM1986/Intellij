

package com.mycompany.repasoclases;

/**
 *
 * @author damci
 */

public class Repasoclases 
{

    public static void main(String[] args) 
    {
        ConIVA f=new ConIVA(100f,.21f,121);
        f.setBi(200);
        f.calcularTotal();
    }
}
