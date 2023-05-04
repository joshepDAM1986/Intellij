
package com.mycompany.ejemplo_junit_2;

/**
 *
 * @author damci
 */

public class Operaciones 
{
    public int suma(int n1,int n2)
    {
     return n1+n2;   
    }
    
    public double conversorTemp(double temp, char system)
    {
        if (system=='F')
        return (temp-32)/1.8;
        else
        return (temp*1.8)+32;
    }
     
}
