package com.eventos;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.PropertyConfigurator;

/**
 * Application Lifecycle Listener implementation class Evento_ArranquePrograma
 *
 */
@WebListener
public class Evento_ArranquePrograma implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Evento_ArranquePrograma() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    //OBTENEMOS EL VALOR DEL PARAMETRO DE CONFIGURACION
    public void contextInitialized(ServletContextEvent evento_creacion)  { 
     //OBTENEMOS LA RUTA DEL web.xml 
      String ruta_depu=evento_creacion.getServletContext().getInitParameter("ruta_seguimiento");
     //CALCULAMOS DINAMICAMENTE LA RUTA A PARTIR DEL VALOR DEL PARAMETRO.    
      ruta_depu = evento_creacion.getServletContext().getRealPath(ruta_depu);
      //SE ESTABLECE LA RUTA COMO ATRIBUTO DEL SISTEMA YA QUE LOG4J NO ES DE JAVAEE 
      System.setProperty("ruta_seguimiento", ruta_depu);      
      //RUTA PARA QUE EL LOG4J ENCUENTRE SU FICHERO DE CONFIGURACION 
      String ruta_logs = evento_creacion.getServletContext().getRealPath("/WEB-INF/classes/com/eventos/log4j.properties");
      //ARRANQUE DEL SISTEMA DE LOG 
      PropertyConfigurator.configure(ruta_logs);
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}