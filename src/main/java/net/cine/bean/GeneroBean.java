/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.bean;

/**
 *
 * @author Daniel
 */
public class GeneroBean {
    
    private Integer id = 0;
    private String tipo_genero = "";
    
    
     public GeneroBean() {
    }

    public GeneroBean(Integer id) {
        this.id = id;
    }

   
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the tipo_genero
     */
    public String getTipo_genero() {
        return tipo_genero;
    }

    /**
     * @param tipo_genero the tipo_genero to set
     */
    public void setTipo_genero(String tipo_genero) {
        this.tipo_genero = tipo_genero;
    }

    

     
    
}
