
package com.mycompany.repasoclases;

/**
 *
 * @author damci
 */

public class Factura 
{
    private float bi;
    private float iva;

    public float getBi() 
    {
        return bi;
    }

    public void setBi(float bi) 
    {
        this.bi = bi;
        this.contabilizar();
    }

    public float getIva() 
    {
        return iva;
    }

    public void setIva(float iva) 
    {
        this.iva = iva;
    }
    private void contabilizar()
    {
        //Crear asiento con factura
        int añoActual=2022;
    }
    
}
