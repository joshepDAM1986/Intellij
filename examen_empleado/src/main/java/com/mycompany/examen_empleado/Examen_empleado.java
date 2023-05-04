

package com.mycompany.examen_empleado;

/**
 *
 * @author garci
 */

public class Examen_empleado 
{

    public static void main(String[] args) 
    {       
Empleado emp1 = new Empleado("Pedro", "Pérez", 1300, 0.02, 'B');
Empleado emp2 = new Empleado("Ana");
Empleado emp3 = new Empleado("Carmen", "Lorenzo", 1250, 0.06, 'D');

System.out.println(emp1.toString());
System.out.println(emp2.toString());
System.out.println(emp3.toString());
System.out.println("Cantidad total de empleados: " + Empleado.getNEmpleados());
System.out.println("----------------------------------------");
Empleado.setPrimaGlobal(0.1);
emp1.categoria = 'C';

System.out.println(emp1.toString());
System.out.println(emp2.toString());
System.out.println(emp3.toString());
System.out.println("Cantidad total de empleados: " + Empleado.getNEmpleados());
    }
}
