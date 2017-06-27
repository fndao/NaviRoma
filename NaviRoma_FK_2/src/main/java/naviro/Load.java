package naviro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.glass.ui.Window.Level;

//import fr.curie.ROMA.ModuleActivityAnalysis;

public class Load extends HttpServlet {

	public static final String CHAMP_Maps = "module";
	public static final String CHAMP_data = "fichier";
	public static final String CHAMP_box = "box";
	public static String acsnKey = "acsn";
	public static String acsnFile = "/idy/fichier/acsn.gmt";
	public static String dna_repair = "/idy/fichier/dna_repair.gmt";
	public static String EMT = "/idy/fichier/emtcellmotility.gmt";
	public static String apoptosis = "/idy/fichier/apoptosis.gmt";
	public static String cellcycle = "/idy/fichier/cellcycle.gmt";
	public static String survival = "/idy/fichier/survival.gmt";
	static final Map<String, String> FILES_BY_MAP = new HashMap<String, String>();
	static {
		FILES_BY_MAP.put(acsnKey, acsnFile);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/WEB-INF/Load.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Récupération des champs du formulaire. */

		String module = request.getParameter(CHAMP_Maps);
		String modulePathName = FILES_BY_MAP.get(module);
		System.out.println(module);
		String box = request.getParameter(CHAMP_box);
		System.out.println(box);
		// String fichier = request.getParameter( CHAMP_data );

		Part vfgfg = request.getPart(CHAMP_data);
		// request.get

		String pathname = saveFile(response, vfgfg);

		System.out.println(module);
		System.out.println(vfgfg);
		System.out.println("je suis la!!!");

		/*
		 * récupération des fichiers modules.gmt
		 * 
		 * // utilisation de la classe ModuleActivityAnalysis //
		 * ModuleActivityAnalysis activity = new ModuleActivityAnalysis(); //
		 * activity.moduleActivityTable();
		 * 
		 * // methode pour lancer ROMA dans mon programme String arguments[] =
		 * new String[6]; arguments[1] = "-dataFile"; arguments[2] = "data.txt";
		 * arguments[3] = "-moduleFile"; arguments[4] = "modules.gmt";
		 * arguments[5] = "-centerData"; //
		 * ModuleActivityAnalysis.main(arguments);
		 * 
		 * /* // try { // validationEmail( fichier ); //} catch (Exception e) {
		 * // Gérer les erreurs de validation ici. }
		 */

		this.getServletContext().getRequestDispatcher("/WEB-INF/Load.jsp").forward(request, response);
	}

	private String saveFile(HttpServletResponse response, Part part) throws IOException {
		final String fileName = getFileName(part);

		OutputStream out = null;
		InputStream filecontent = null;

		String pathname = "/home/bka/workspace-2/NaviRoma_FK_2/upload" + File.separator + fileName;
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
