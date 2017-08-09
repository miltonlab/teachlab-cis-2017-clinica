/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.modelo;

/**
 *
 * @author miltonlab
 */
public class Paciente {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String cedula;
    private String nombres;
    private int edad;
    private char sexo;

    /**
     * Get the value of sexo
     *
     * @return the value of sexo
     */
    public char getSexo() {
        return sexo;
    }

    public Paciente(String cedula, String nombres, int edad, char sexo) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.edad = edad;
        this.sexo = sexo;
    }

    /**
     * Set the value of sexo
     *
     * @param sexo new value of sexo
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    

    /**
     * Get the value of nombres
     *
     * @return the value of nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Set the value of nombres
     *
     * @param nombres new value of nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    /**
     * Get the value of cedula
     *
     * @return the value of cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Set the value of cedula
     *
     * @param cedula new value of cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        //return "Paciente{" + "cedula=" + cedula + ", nombres=" + nombres + ", edad=" + edad + ", sexo=" + sexo + '}';
        return nombres;
    }

    public String toRecord(){
        String linea= "";
        linea = this.cedula + ";" + this.nombres + ";" + this.edad + ";" + this.sexo;
        return linea;
    }
    
}
