package co.edu.udea.proyectointegrador.dto;
// Generated Jan 15, 2014 8:40:52 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TbPryEventos generated by hbm2java
 */
public class TbPryEventos  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nbIdn;
     private TbPryProyectos tbPryProyectos;
     private String vrNombre;
     private String vrDescripcion;
     private Date dtFechainicial;
     private Date dtFechafinal;
     
     private String vrAdtusuario;
     private Date dtAdtfecha;
    public TbPryEventos() {
    }

    public TbPryEventos(TbPryProyectos tbPryProyectos, String vrNombre, String vrDescripcion, Date dtFechainicial, Date dtFechafinal) {
       this.tbPryProyectos = tbPryProyectos;
       this.vrNombre = vrNombre;
       this.vrDescripcion = vrDescripcion;
       this.dtFechainicial = dtFechainicial;
       this.dtFechafinal = dtFechafinal;
    }
   
    public String getVrAdtusuario() {
		return vrAdtusuario;
	}

	public void setVrAdtusuario(String vrAdtusuario) {
		this.vrAdtusuario = vrAdtusuario;
	}

	public Date getDtAdtfecha() {
		return dtAdtfecha;
	}

	public void setDtAdtfecha(Date dtAdtfecha) {
		this.dtAdtfecha = dtAdtfecha;
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
    public Date getDtFechainicial() {
        return this.dtFechainicial;
    }
    
    public void setDtFechainicial(Date dtFechainicial) {
        this.dtFechainicial = dtFechainicial;
    }
    public Date getDtFechafinal() {
        return this.dtFechafinal;
    }
    
    public void setDtFechafinal(Date dtFechafinal) {
        this.dtFechafinal = dtFechafinal;
    }




}


