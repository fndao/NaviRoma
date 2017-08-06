package mean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NaviRo {
	
	/**
	 * @param args
	 * @author NDAO Fatou
	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		String ligne;
//	    BufferedReader lecteurAvecBuffer = null;
//		List<ModuleGene> listeModule= new ArrayList();
//		@SuppressWarnings("unused")
//		List<ModuleGene> listeModuleGene= new ArrayList();
//	    ModuleGene moduleGene = null;
//	   // List listScoreSample = null;
//	    String listScoreSample = "";
//	    
//
//	    try
//	      {
//		lecteurAvecBuffer = new BufferedReader(new FileReader("/data/users/fndao/naviroma/output/moduletable_simple.txt"));
//		String echantillon = null;
//		String[] score = null;
//		if ((ligne = lecteurAvecBuffer.readLine()) != null)
//			//recovery of samples in module file
//			//echantillon  = ligne.split("\t");
//			echantillon  = ligne;
//			
//		
//		//recovery of modules and their scores in the file
//		while  ((ligne = lecteurAvecBuffer.readLine()) != null){
//			score = ligne.split("\t");
//			moduleGene = new ModuleGene();
//			moduleGene.setNom(score[0]);
//			
//			//listScoreSample = new ArrayList();
//			for (int i = 1; i < score.length; i++) {
//				@SuppressWarnings("unused")
//				String string = score[i];
//				//listScoreSample.add(score[i]);
//				listScoreSample = listScoreSample + score[i] +"\t";
//			}
//			
//			moduleGene.setlistScoreSample(listScoreSample);
//			System.out.println(listScoreSample);
//
//			//recovery of  genes in  modules
//			
//			List listGene = addGenesList(moduleGene.getNom());
//			
//			moduleGene.setgeneList(listGene);
//			
//			listeModule.add(moduleGene);
//			
//			listScoreSample = "";
//		
//		}
//
//		
//		//list of genes with values in samples
//		List<GeneSample> listGeneSample = new ArrayList<GeneSample>() ;
//		List<GeneSample> listGeneSampleWithoutDuplicate = new ArrayList<GeneSample>() ;
//		for (ModuleGene module : listeModule) {
//			GeneSample geneSample = null;
//			for (String gene : module.getgeneList()) {
//				geneSample = new GeneSample();
//				geneSample.setgeneName(gene);
//				geneSample.setsumScoreSample(module.getlistScoreSample().split("\t"));
//						
//				listGeneSample.add(geneSample);
//			}
//					
//		}
//		
//		// Manage duplicates
//		
//		for (GeneSample GeneSample : listGeneSample) {
//					
//					
//			//verify if gene is traited or not
//					
//			 boolean geneTraite = verifyGeneProcess(listGeneSampleWithoutDuplicate,
//					GeneSample);
//					
//			if(!geneTraite){
//						
//						
//				String[] score1 = new String [GeneSample.getsumScoreSample().length];
//				for (int i = 0; i < score1.length; i++) {
//					score1[i]=""+0;
//				}
//				int nbGene = 0;
//				
//				//research of duplicates
//				for (GeneSample GeneSample2 : listGeneSample) {
//							
//					if(GeneSample.getgeneName().equals(GeneSample2.getgeneName())){
//								
//						String[] score2 = GeneSample2.getsumScoreSample();
//								
//						//added scores
//						for (int i = 0; i < score2.length; i++) {
//							score1[i] = Double.parseDouble(score1[i]) + Double.parseDouble(score2[i])+"";
//									
//						}
//						//number of duplicates
//						nbGene++;
//					}
//							
//				}
//				
//				// socres are added and the number of duplication are known we calculate the mean 
//				String[] scoreMoyenne = score1;
//						
//				for (int i = 0; i < score1.length; i++) {
//							
//					scoreMoyenne[i] =""+Double.parseDouble(score1[i])/nbGene ;
//				
//				}
//				GeneSample.setsumScoreSample(scoreMoyenne);
//						
//				//add genes in the list without duplication
//						
//				listGeneSampleWithoutDuplicate.add(GeneSample);
//						
//				nbGene = 0;
//						
//			}
//					
//					
//		}
//		
//		//
//		//Write to gene.txt file
//		FileWriter fileWrite =new  FileWriter("test_ACSN.txt",true);
//		// header of file : line 1
//		fileWrite.write(echantillon);
//		fileWrite.write("\n");
//		
//		for (GeneSample geneSample : listGeneSampleWithoutDuplicate) {
//			fileWrite.write(geneSample.getgeneName());
//			fileWrite.write("\t");
//			for (String scoreEch : geneSample.getsumScoreSample()) {
//						
//				fileWrite.write(scoreEch);
//				fileWrite.write("\t");
//			}
//			fileWrite.write("\n");
//					
//		}
//
//		
//		fileWrite.flush();
//		fileWrite.close();
//		lecteurAvecBuffer.close();
//		
//	      }
//	    catch(FileNotFoundException exc)
//	      {
//		System.out.println("Erreur d'ouverture");
//	      } catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
	    
//	  }
	
	
	
	public void calculateMean(String moduleTableSimple ,String module) {
		
		
		
		String ligne;
	    BufferedReader lecteurAvecBuffer = null;
		List<ModuleGene> listeModule= new ArrayList();
		@SuppressWarnings("unused")
		List<ModuleGene> listeModuleGene= new ArrayList();
	    ModuleGene moduleGene = null;
	   // List listScoreSample = null;
	    String listScoreSample = "";
	    

	    try
	      {
		lecteurAvecBuffer = new BufferedReader(new FileReader(moduleTableSimple));
		String echantillon = null;
		String[] score = null;
		if ((ligne = lecteurAvecBuffer.readLine()) != null)
			//recovery of samples in module file
			//echantillon  = ligne.split("\t");
			echantillon  = ligne;
			
		
		//recovery of modules and their scores in the file
		while  ((ligne = lecteurAvecBuffer.readLine()) != null){
			score = ligne.split("\t");
			moduleGene = new ModuleGene();
			moduleGene.setNom(score[0]);
			
			//listScoreSample = new ArrayList();
			for (int i = 1; i < score.length; i++) {
				@SuppressWarnings("unused")
				String string = score[i];
				//listScoreSample.add(score[i]);
				listScoreSample = listScoreSample + score[i] +"\t";
			}
			
			moduleGene.setlistScoreSample(listScoreSample);
			System.out.println(listScoreSample);

			//recovery of  genes in  modules
			
			List listGene = addGenesList(moduleGene.getNom(),module);
			
			moduleGene.setgeneList(listGene);
			
			listeModule.add(moduleGene);
			
			listScoreSample = "";
		
		}

		
		//list of genes with values in samples
		List<GeneSample> listGeneSample = new ArrayList<GeneSample>() ;
		List<GeneSample> listGeneSampleWithoutDuplicate = new ArrayList<GeneSample>() ;
		for (ModuleGene moduleGen : listeModule) {
			GeneSample geneSample = null;
			for (String gene : moduleGen.getgeneList()) {
				geneSample = new GeneSample();
				geneSample.setgeneName(gene);
				geneSample.setsumScoreSample(moduleGen.getlistScoreSample().split("\t"));
						
				listGeneSample.add(geneSample);
			}
					
		}
		
		// Manage duplicates
		
		for (GeneSample GeneSample : listGeneSample) {
					
					
			//verify if gene is traited or not
					
			 boolean geneTraite = verifyGeneProcess(listGeneSampleWithoutDuplicate,
					GeneSample);
					
			if(!geneTraite){
						
						
				String[] score1 = new String [GeneSample.getsumScoreSample().length];
				for (int i = 0; i < score1.length; i++) {
					score1[i]=""+0;
				}
				int nbGene = 0;
				
				//research of duplicates
				for (GeneSample GeneSample2 : listGeneSample) {
							
					if(GeneSample.getgeneName().equals(GeneSample2.getgeneName())){
								
						String[] score2 = GeneSample2.getsumScoreSample();
								
						//added scores
						for (int i = 0; i < score2.length; i++) {
							score1[i] = Double.parseDouble(score1[i]) + Double.parseDouble(score2[i])+"";
									
						}
						//number of duplicates
						nbGene++;
					}
							
				}
				
				// socres are added and the number of duplication are known we calculate the mean 
				String[] scoreMoyenne = score1;
						
				for (int i = 0; i < score1.length; i++) {
							
					scoreMoyenne[i] =""+Double.parseDouble(score1[i])/nbGene ;
				
				}
				GeneSample.setsumScoreSample(scoreMoyenne);
						
				//add genes in the list without duplication
						
				listGeneSampleWithoutDuplicate.add(GeneSample);
						
				nbGene = 0;
						
			}
					
					
		}
		
		//
		//Write to gene.txt file
		FileWriter fileWrite =new  FileWriter("C:\\outPutRoma\\resultCalculMean.txt",true);
		// header of file : line 1
		fileWrite.write(echantillon);
		fileWrite.write("\n");
		
		for (GeneSample geneSample : listGeneSampleWithoutDuplicate) {
			fileWrite.write(geneSample.getgeneName());
			fileWrite.write("\t");
			for (String scoreEch : geneSample.getsumScoreSample()) {
						
				fileWrite.write(scoreEch);
				fileWrite.write("\t");
			}
			fileWrite.write("\n");
					
		}

		
		fileWrite.flush();
		fileWrite.close();
		lecteurAvecBuffer.close();
		
	      }
	    catch(FileNotFoundException exc)
	      {
		System.out.println("Erreur d'ouverture");
	      } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
		
	}
	
	public NaviRo() {
		
	}

	/**
	 * @param listGeneSampleWithoutDuplicate
	 * @param geneSample
	 * @param geneTraite
	 * @return
	 */
	private static boolean verifyGeneProcess(List<GeneSample> listGeneSampleWithoutDuplicate,GeneSample geneSample) {
		boolean geneTraite = false;
		for (GeneSample geneSampleDoublon : listGeneSampleWithoutDuplicate) {
			if(geneSampleDoublon.getgeneName().equals(geneSample.getgeneName())){
				geneTraite = true;
				break;
			}
		}
		return geneTraite;
	}

	
	/**
	 * @param moduleGene
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "resource", "unchecked" })
	private static List addGenesList(String nomModule,String module)
			throws FileNotFoundException, IOException {
		String ligne;
	    BufferedReader lecteurDNA = null;
		lecteurDNA = new BufferedReader(new FileReader(module));
		
		String[] gene = null;
		List listeGene = new ArrayList();
		while  ((ligne = lecteurDNA.readLine()) != null){
			gene = ligne.split("\t");
			if(gene[0].equals(nomModule)){
				
				for (int i = 1; i < gene.length; i++) {
					listeGene.add( gene[i]);
					
				}

				break;
			}
			
		 }
		return listeGene;
	}
	
	
}
	
