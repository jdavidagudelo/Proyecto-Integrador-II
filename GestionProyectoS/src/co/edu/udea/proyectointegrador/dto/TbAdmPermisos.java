package co.edu.udea.proyectointegrador.dto;
// Generated Oct 10, 2013 10:28:13 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TbAdmPermisos generated by hbm2java
 */
public class TbAdmPermisos  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nbIdn;
	private String vrTipo;
     private String vrNombre;
     private String vrDescripcion;
     private String vrAdtusuario;
     private Date dtAdtfecha;
     
    public TbAdmPermisos() {
    }

	
    public TbAdmPermisos(String vrNombre, String vrDescripcion, String vrAdtusuario, Date dtAdtfecha) {
        this.vrNombre = vrNombre;
        this.vrDescripcion = vrDescripcion;
        this.vrAdtusuario = vrAdtusuario;
        this.dtAdtfecha = dtAdtfecha;
    }
   
    public Integer getNbIdn() {
        return this.nbIdn;
    }
    
    public void setNbIdn(Integer nbIdn) {
        this.nbIdn = nbIdn;
    }
    public String getVrNombre() {
        return this.vrNombre;
    }
    
    public void setVrNombre(String vrNombre) {
        this.vrNombre = vrNombre;
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
   

	public String getVrTipo() {
		return vrTipo;
	}


	public void setVrTipo(String vrTipo) {
		this.vrTipo = vrTipo;
	}
    
}


