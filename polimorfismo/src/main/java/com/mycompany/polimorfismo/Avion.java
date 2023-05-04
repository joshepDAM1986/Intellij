
package com.mycompany.polimorfismo;

/**
 *
 * @author garci
 */
class Avion extends Aereo
    {
    private  int numMotores;
    public Avion (int numMotores) {this.numMotores = numMotores;
    }
    @Override
    public void getInfo() 
    { 
        System.out.println("Avion");
    }
    public void getNumMotores()
    { 
        System.out.println("Tiene " + numMotores + " motores");
    }
}
class Helicoptero extends Aereo{
        @Override
        public void getInfo() 
        {
            System.out.println("Helicoptero");
        }
}
