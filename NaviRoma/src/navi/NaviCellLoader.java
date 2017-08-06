package navi;

import java.util.HashSet;
import java.util.Vector;

import javax.servlet.http.Part;

import fr.curie.jnavicell.NaviCell;


public class NaviCellLoader {
	


	public static void main(String[] args) {
		 //TODO Auto-generated method stub
	try{
			
		String data = "C:\\outPutRoma/resultcalculMean.txt";
			String URLNaviCell = "https://navicell.curie.fr/navicell/newtest/maps/acsn/master/index.php";
			int compNumber = 11;
			String columnName = "TCGA-AA-A01I";
			
			LoadNaviCellWithData(data,URLNaviCell,columnName,"ICA");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void LoadNaviCellWithData(String dataFile, String URLNaviCell, String columnName, String analysisPrefix){
				
        NaviCell n = new NaviCell();
        
        
        n.setMapUrl(URLNaviCell);
        

        n.launchBrowser();

        //data loading
        n.importData("", dataFile,  "mRNA Expression data", analysisPrefix);
        
         //select heatmap for visualization
       // n.drawingConfigSelectHeatmap("", true);
        //n.drawingConfigApply("");
        
        //select map staining for visualization
        n.drawingConfigSelectMapStaining("", true);
        n.drawingConfigApply("");
 
        // select sample and datatable 
        // n.heatmapEditorSelectSample("", 0,columnName);
        // n.heatmapEditorSelectDatatable("", 0, analysisPrefix);
        
       // select sample or datatable
        n.mapStainingEditorSelectSample("", columnName);
        n.mapStainingEditorSelectDatatable("", analysisPrefix); 
        
        /*
         * parameters of configurous for test
         */
       //  We open the color editor
        n.continuousConfigOpen("",analysisPrefix,"color");
        // Define that the method for computing a value for multiple HUGOs is average
        n.continuousConfigSetSampleMethod("","color",analysisPrefix,0);
       //  Modify the low threshold for the green part of the color scale
        n.continuousConfigSetValueAt("",analysisPrefix,"color","sample",0,-0.1f);
       //  Modify the low threshold for the red part of the color scale
        n.continuousConfigSetValueAt("",analysisPrefix,"color","sample",2,0.1f);
       //  We close the color editor and apply the changes
        n.continuousConfigApplyAndClose("", analysisPrefix, "color");
        
        // visualize the results
        n.heatmapEditorApply("");
        n.mapStainingEditorApply("");
		
	}

}