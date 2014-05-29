package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.proyectointegrador.exception.DaoException;
import co.edu.udea.proyectointegrador.service.TbPryReportesService;

// How To Invoke Ireport From Java Application

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:spring_configuration.xml")
public class PDFReportTest {
	@Autowired
	private TbPryReportesService tbPryReportesService;
	@Test
  public void main() throws JRException, IOException, SQLException, ClassNotFoundException, DaoException {
		// JasperReport jasperReport = JasperCompileManager.compileReport("/home/juan/workspace1/GestionProyectoS/src/test/Coffee.jrxml"); 
	byte[] data = tbPryReportesService.getReporteListarProyectos("pdf");
	try {
		
		File newFile = new File("reporte2.pdf");
		FileOutputStream fos = new FileOutputStream(newFile);
		try {
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}

	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	}

  }
}
