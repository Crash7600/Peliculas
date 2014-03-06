/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.bean;


import java.util.Date;


/**
 *
 * @author Crash
 */

public class DirectorBean {
    
    
    private Integer id = 0;
    private String nombredirector = "";
    private String nacionalidad = "";
    private Date anyoinicio = new Date();
    private Date anyofin = new Date();
    
    public DirectorBean() {
        
    }

    public DirectorBean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreDirector() {
        return nombredirector;
    }

    public void setNombreDirector(String nombredirector) {
        this.nombredirector = nombredirector;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getAnyoInicio() {
        return anyoinicio;
    }

    public void setAnyoInicio(Date anyoinicio) {
        this.anyoinicio = anyoinicio;
    }

    public Date getAnyoFin() {
        return anyofin;
    }

    public void setAnyoFin(Date anyofin) {
        this.anyofin = anyofin;
    }

}
