package co.edu.udea.proyectointegrador.dto;
// Generated Sep 9, 2013 7:13:29 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * TbNtfUsuariostipontf generated by hbm2java
 */
public class TbNtfUsuariostipontf  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer nbIdn;
     private TbNtfsTipontfsroles tbNtfsTipontfsroles;
     private TbAdmUsuarios tbAdmUsuarios;
     private boolean blNotificar;
     private String vrAdtusuario;
     private Date dtAdtfecha;
     
    public TbNtfUsuariostipontf() {
    }

	
    public TbNtfUsuariostipontf(TbNtfsTipontfsroles tbNtfsTipontfsroles, TbAdmUsuarios tbAdmUsuarios, boolean blNotificar, String vrAdtusuario, Date dtAdtfecha) {
        this.tbNtfsTipontfsroles = tbNtfsTipontfsroles;
        this.tbAdmUsuarios = tbAdmUsuarios;
        this.blNotificar = blNotificar;
        this.vrAdtusuario = vrAdtusuario;
        this.dtAdtfecha = dtAdtfecha;
    }
   
    public Integer getNbIdn() {
        return this.nbIdn;
    }
    
    public void setNbIdn(Integer nbIdn) {
        this.nbIdn = nbIdn;
    }
    public TbNtfsTipontfsroles getTbNtfsTipontfsroles() {
        return this.tbNtfsTipontfsroles;
    }
    
    public void setTbNtfsTipontfsroles(TbNtfsTipontfsroles tbNtfsTipontfsroles) {
        this.tbNtfsTipontfsroles = tbNtfsTipontfsroles;
    }
    public TbAdmUsuarios getTbAdmUsuarios() {
        return this.tbAdmUsuarios;
    }
    
    public void setTbAdmUsuarios(TbAdmUsuarios tbAdmUsuarios) {
        this.tbAdmUsuarios = tbAdmUsuarios;
    }
    public boolean isBlNotificar() {
        return this.blNotificar;
    }
    
    public void setBlNotificar(boolean blNotificar) {
        this.blNotificar = blNotificar;
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
  



}


