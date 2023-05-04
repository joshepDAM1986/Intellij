
package com.mycompany.ejemplo_junit;

/**
 *
 * @author damci
 */

public class Test1 
{
    public int multiplica(int a,int b)
    {
    return a*b;
    }
    public int factorial (int numero)
    {
        if (numero<0)
            throw new ArithmeticException ("El factorial de un numero negativo no existe");
        else if(numero==0)
             return 1;
    int factorial = numero;
    for (int i = (numero - 1);i>1;i--)
    {
        factorial=factorial*i;
    }
    return factorial;
    }
    public int suma(int n1,int n2)
    {
    if (n1>0 || n2< 0) throw new IllegalArgumentException("No se aceptan valores negativos");
    return n1+n2;   
    }
}
