package mean;

import java.util.List;

public class ModuleGene {
	
	private String nom;
	private List geneList;
	
	//private List geneList;
	//score de chaque echantillon 
	private String listScoreSample;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<String> getgeneList() {
		return geneList;
	}
	

	public void setgeneList(List geneList) {
		this.geneList = geneList;
	}

	public String getlistScoreSample() {
		return listScoreSample;
	}

	
	public void setlistScoreSample( String listScoreSample) {
		this.listScoreSample = listScoreSample;
	}
	
}


