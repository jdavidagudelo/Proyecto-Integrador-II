package co.edu.udea.proyectointegrador.dto;
// Generated Sep 9, 2013 7:13:29 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TbPryObjetivosespecificos generated by hbm2java
 */
public class TbPryObjetivosespecificos  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nbIdn;
     private TbPryProyectos tbPryProyectos;
     private String vrDescripcion;
     private String vrAdtusuario;
     private Date dtAdtfecha;
     private long nbPorcentajesobreproyecto;
    
    public TbPryObjetivosespecificos() {
    }

	
    public TbPryObjetivosespecificos(TbPryProyectos tbPryProyectos, String vrDescripcion, String vrAdtusuario, String vrEstado, Date dtAdtfecha, long nbPorcentajesobreproyecto) {
        this.tbPryProyectos = tbPryProyectos;
        this.vrDescripcion = vrDescripcion;
        this.vrAdtusuario = vrAdtusuario;
        this.dtAdtfecha = dtAdtfecha;
        this.nbPorcentajesobreproyecto = nbPorcentajesobreproyecto;
    }
   
    public Integer getNbIdn() {
        return this.nbIdn;
    }
    
    public void setNbIdn(Integer nbIdn) {
        this.nbIdn = nbIdn;
    }
    public TbPryProyectos getTbPryProyectos() {
        return this.tbPryProyectos;
    }
    
    public void setTbPryProyectos(TbPryProyectos tbPryProyectos) {
        this.tbPryProyectos = tbPryProyectos;
    }
    public String getVrDescripcion() {
        return this.vrDescripcion;
    }
    
    public void setVrDescripcion(String vrDescripcion) {
        this.vrDescripcion = vrDescripcion;
    }
    public String getVrAdtusuario() {
        return this.vrAdtusuario;
    }
    
    public void setVrAdtusuario(String vrAdtusuario) {
        this.vrAdtusuario = vrAdtusuario;
    }
    public Date getDtAdtfecha() {
        return this.dtAdtfecha;
    }
    
    public void setDtAdtfecha(Date dtAdtfecha) {
        this.dtAdtfecha = dtAdtfecha;
    }
    public long getNbPorcentajesobreproyecto() {
        return this.nbPorcentajesobreproyecto;
    }
    
    public void setNbPorcentajesobreproyecto(long nbPorcentajesobreproyecto) {
        this.nbPorcentajesobreproyecto = nbPorcentajesobreproyecto;
    }




}


