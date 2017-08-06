package navi;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileItemFactory;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

import fr.curie.ROMA.ModuleActivityAnalysis;
import mean.NaviRo;


public class Requete extends HttpServlet {

	public static final String moduleFile = "module";
	public static final String dataFile = "matrix";
	public static final String sampleFile ="sample";
	public static final String CHAMP_box = "box";
	public static final Object box = null;
	
	public static String acsnKey = "ACSN";
	public static String acsnFile = "C:\\module/acsn.gmt";
	
	public static String dnaKey = "DNA_repair";
	public static String dna_repair = "C:\\module/dna_repair.gmt";
	
	public static String cellcycKey = "CellCycle";
	public static String cellcycle = "C:\\module/cellcycle.gmt";
	
	public static String survivalKey = "Survival"; 
	public static String survival = "C:\\module/survival.gmt";
	
	public static String emtKey = "EMT_motility";
	public static String EMT = "C:\\module/emtcellmotility.gmt";
	
	public static String apoptosisKey = "Apoptosis";
	public static String apoptosis = "C:\\module/apoptosis.gmt";
	
	static final Map<String, String> FILES_BY_MAP = new HashMap<String, String>();
	static {
		FILES_BY_MAP.put(acsnKey, acsnFile);
		FILES_BY_MAP.put(dnaKey, dna_repair);
		FILES_BY_MAP.put(cellcycKey, cellcycle);
		FILES_BY_MAP.put(survivalKey, survival);
		FILES_BY_MAP.put(emtKey, EMT);
		FILES_BY_MAP.put(apoptosisKey, apoptosis);
		
		// System.out.println(FILES_BY_MAP);
	}

	public void doGet( HttpServletRequest request, HttpServletResponse response ) 
	throws ServletException, IOException{
	
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Requete.jsp" ).forward( request, response );	
	}

	
	public void doPost( HttpServletRequest  request, HttpServletResponse response ) 
		throws ServletException, IOException{
		
		/* Récupération des champs du formulaire. */

		String module = request.getParameter(moduleFile);
		String modulePathName = FILES_BY_MAP.get(module);
		System.out.println(module);
		//System.out.println( FILES_BY_MAP.getKey());
		String box = request.getParameter(CHAMP_box);
		System.out.println(box);
		
		//recupération de la matrix d'expression
		Part data = request.getPart(dataFile);
		String pathname = saveFile(response, data);
		
		//récupération des samples file
		Part sample = request.getPart(sampleFile);
	    String pathname1 = saveFile(response, sample);
		
	    
		
	    
		 // Lancer ROMA dans mon programme
		
	      String arguments[] = new String[10];
	      arguments[0] = "-dataFile"; 
	      arguments[1] = pathname;
	      arguments[2] = "-moduleFile";
	      arguments[3] = modulePathName;
	      arguments[4] = "-centerData";
		  arguments[5] = "1";
	      arguments[6] = "-sampleFile";
	      arguments[7] = pathname1;
	      arguments[8] = "-outputFolder";
	      arguments[9] = "C:\\outPutRoma";
	      if ("checkbox1".equals(box)) {
				arguments[4] = "-centerData";
				arguments[5] = "1";
			}
	     
		 ModuleActivityAnalysis.main(arguments);	
		 
		 NaviRo naviro = new NaviRo();
		 naviro.calculateMean("C:\\outPutRoma\\moduletable_simple.txt", modulePathName);
		 String moduleName = (modulePathName.split("/")[1]).split("\\.")[0];
		
		 //NaviRo.main(String[] args);
		 NaviCellLoader naviCellLoader = new NaviCellLoader();
		 
		 String resultCalculMean ="C:\\outPutRoma\\resultCalculMean.txt";
		 
		 String uRLNaviCell = "https://navicell.curie.fr/navicell/newtest/maps/"+moduleName+"/master/index.php";
		 
		 BufferedReader lecteurAvecBuffer = new BufferedReader(new FileReader(resultCalculMean));
		 String firstColumn = lecteurAvecBuffer.readLine().split("\t")[1];
		 
		 
		 
		 naviCellLoader.LoadNaviCellWithData(resultCalculMean, uRLNaviCell,firstColumn, "transcriptome");
	 
          	
		this.getServletContext().getRequestDispatcher( "/WEB-INF/Requete.jsp" ).forward( request, response );
       }
	  

	private String saveFile(HttpServletResponse response, Part part) throws IOException {
		final String fileName = getFileName(part);

		OutputStream out = null;
		InputStream filecontent = null;

		String pathname = "C:\\upload\\" + fileName;
		//String pathname1 = "/data/users/fndao/workspace/NaviRoma/upload_Samp" + File.separator + fileName;
		File file = new File(pathname);
		try {
			out = new FileOutputStream(file);
			filecontent = part.getInputStream();

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		} catch (FileNotFoundException fne) {
			final PrintWriter writer = response.getWriter();
			writer.println("You either did not specify a file to upload or are "
					+ "trying to upload a file to a protected or nonexistent " + "location.");
			writer.println("<br/> ERROR: " + fne.getMessage());
			writer.close();
	
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
		return pathname;
	}

	private String getFileName(final Part part) {
		final String partHeader = part.getHeader("content-disposition");
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
}	





