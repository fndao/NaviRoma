package naviro;


import javax.servlet.http.HttpServlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import fr.curie.ROMA.ModuleActivityAnalysis;


//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Load extends HttpServlet {
	
	public static final String CHAMP_Maps = "module";
	public static final String CHAMP_data  = "fichier";
	public static final String CHAMP_box = "box";
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) 
	throws ServletException, IOException{
	
		//response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Load.jsp" ).forward( request, response );	
	}

	public void doPost( HttpServletRequest  request, HttpServletResponse response ) 
		throws ServletException, IOException{
	
        /* Récupération des champs du formulaire. */
        
        String module = request.getParameter( CHAMP_Maps );
        System.out.println(module);
       //idy/fichier/acsn.gmt
        String box =  request.getParameter(CHAMP_box);
        System.out.println(box);
        //String fichier = request.getParameter( CHAMP_data );
        
        Part part = request.getPart(CHAMP_data);
        //request.get
       
       
        
        System.out.println(part);
        System.out.println("je suis la!!!");
        
  

        
       // ModuleActivityAnalysis activity = new ModuleActivityAnalysis();
       //activity.moduleActivityTable();
        
        /*
       // try {
        //    validationEmail( fichier );
        //} catch (Exception e) {
            // Gérer les erreurs de validation ici. } */

       
		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Load.jsp" ).forward( request, response ); 
       }
	
	
}	
