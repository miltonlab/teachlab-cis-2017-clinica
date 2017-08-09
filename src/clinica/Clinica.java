/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import clinica.modelo.Paciente;

/**
 *
 * @author miltonlab
 */
public class Clinica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Paciente p = new Paciente("111111", "Juan Perez", 30, 'M');
        System.out.println(p);
        System.out.println(p.toRecord());
        
    }
    
}
