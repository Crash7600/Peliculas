/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cine.bean;

import java.util.Date;

/**
 *
 * @author Daniel
 */
public class RepartoBean {

    private Integer id = 0;
    private String nombre_actor = "";
    private Date fechanacimiento = new Date();
    private String ciudad = "";

    public RepartoBean() {

    }

    public RepartoBean(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre_actor
     */
    public String getNombre_actor() {
        return nombre_actor;
    }

    /**
     * @param nombre_actor the nombre_actor to set
     */
    public void setNombre_actor(String nombre_actor) {
        this.nombre_actor = nombre_actor;
    }

    /**
     * @return the fecha_nacimiento
     */
    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    /**
     * @param fechanacimiento the fecha_nacimiento to set
     */
    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    

    

    

    

}
