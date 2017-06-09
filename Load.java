package naviro;


import javax.servlet.http.HttpServlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;
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
        String box =  request.getParameter(CHAMP_box);
        System.out.println(box);
        //String fichier = request.getParameter( CHAMP_data );
        
        Part part = request.getPart(CHAMP_data);
        //request.get
        System.out.println(module);
        System.out.println(part);
        System.out.println("je suis la!!!");
        
        /*
         * récupération des fichiers modules.gmt*/
        String acsn = /idy/fichier/acsn.gmt;
        String dna_repair = /idy/fichier/dna_repair.gmt;
        String EMT= /idy/fichier/emtcellmotility.gmt;
        String apoptosis = /idy/fichier/apoptosis.gmt;
        String cellcycle = /idy/fichier/cellcycle.gmt;
        STRING survival = /idy/fichier/survival.gmt;
  
        //utilisation de la classe ModuleActivityAnalysis
        ModuleActivityAnalysis activity = new ModuleActivityAnalysis();
        activity.moduleActivityTable();
        
        //methode pour lancer ROMA dans mon programme
        String arguments[] = new String[6];
        arguments[1] = "-dataFile";
        arguments[2] = "data.txt";
        arguments[3] = "-moduleFile";
        arguments[4] = "modules.gmt";
        arguments[5] = "-centerData";
        arguments[6] = "1";
        ModuleActivityAnalysis.main(arguments);
       
        
        /*
       // try {
        //    validationEmail( fichier );
        //} catch (Exception e) {
            // Gérer les erreurs de validation ici. } */

		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Load.jsp" ).forward( request, response ); 
       }
	
	
}	
