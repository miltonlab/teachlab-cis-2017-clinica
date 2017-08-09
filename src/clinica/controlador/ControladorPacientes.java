/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.controlador;

import clinica.modelo.Paciente;
import java.util.ArrayList;

/**
 *
 * @author miltonlab
 */
public class ControladorPacientes {
    
    private ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();
    
    public ControladorPacientes() {
        this.cargarPacientes();
    }

    /**
     * Get the value of listaPacientes
     *
     * @return the value of listaPacientes
     */
    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    /**
     * Set the value of listaPacientes
     *
     * @param listaPacientes new value of listaPacientes
     */
    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public void cargarPacientes(){
        
        listaPacientes.add(new Paciente("11046666767", "Ana Belen Puertas", 39, 'F'));
        listaPacientes.add(new Paciente("11233435446", "Juan Perez", 37, 'M'));
        listaPacientes.add(new Paciente("112234565", "Maritza Barragán", 39, 'F'));
        listaPacientes.add(new Paciente("1122222222", "Diego Suarez", 43, 'M'));
        
    }
    
    public double promedioEdad(){
        double suma = 0.0;
        for (Paciente p : this.listaPacientes){
            suma = suma + p.getEdad();
        }
        double promedio = suma / listaPacientes.size();
        return promedio;
    }
    
    
    
}
