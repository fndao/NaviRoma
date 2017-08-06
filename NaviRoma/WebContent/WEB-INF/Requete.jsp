<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>NaviRoma</title>
        <link type="text/css" rel="stylesheet" href="./1_.css" />
    </head>
    
    <body>
    	<form method="post" action="requete" enctype="multipart/form-data"> 
	        <div class="container">
	      <header class="row col-sm-12">
	        <div class="page-header">
	          <h1>NaviRoma<img src="curie.png" class="image"></h1>
	        </div>
	      </header>
	      <div class="row col-sm-12">
	        <nav class="col-sm-4">          
	          <ul class="nav nav-pills nav-stacked">
	            <!-- <li class="active"> <a href="#"> <span class="glyphicon glyphicon-home"></span> Home </a> </li> -->
	            <li> <a href="" type="text/html" href=""/><span class="glyphicon glyphicon-book"></span> Home </a> </li>
	            <li> <a href="doc.html" type="text/html" href="doc.html"/> <span class="glyphicon glyphicon-facetime-video"></span> Documentation </a> </li>
	            <li> <a href="downlods.html" type="text/html" href="downlods.html"/><span class="glyphicon glyphicon-book"></span> Downloads </a> </li>
	            <li> <a href="contact.html" type="text/html" href="contact.html"/> <span class="glyphicon glyphicon-headphones"></span> Refferences </a> </li>
	          </ul>
	        </nav>
	        <section class="col-sm-10">
	          <div class="panel panel-default">
	            <div class="panel-heading">
	              <h3 class="panel-title">Welcome to NaviRoma !!!</h3>
	            </div>
	            <div class="panel-body">
	          
	              <p>
	              NaviRoma is a web server designed to visualize the transcriptomic activity of a module or biological pathway on <a href="https://acsn.curie.fr/" title="https://acsn.curie.fr/">ACSN</a> maps.
				  It uses a computation algorithm, <a href="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4760130/" title="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC4760130/">ROMA</a>, 
				  to estimate the activity score of a set of genes from the different genes that compose it.
				  The results are then mapped to ACSN using the <a href="https://navicell.curie.fr/" title="https://navicell.curie.fr/">NaviCell</a> web service.
	              </p>
	           	  <p>
		           	Select a map on which you would like to view your data, submit your expression data, check box centered data if your data is not centered.
		           	Start the analysis by clicking on the submit button.
					For more details, see the tutorial.
	          	 </p>
	

	            
	            </div>
	            
	          </div>
	        </section>
	        
			<section>
			
			
				<div id= "contenu1">    
				<tr>
			
					<td> 
						 Select Maps: <select name = "module"> 
					  <option selected>Maps or Modules</option>
					  <option>ACSN</option>
					  <option>DNA_repair</option>
					  <option>CellCycle</option>
					  <option>Survival</option>
					  <option>EMT_motility</option>
					  <option>Apoptosis</option>
						</select>
					
					</td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td> 
						Expression Matrix (txt file):
						<input type="file" name="matrix" >
					</td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td> 
						Samples file: (txt file):
						<input type="file" name="sample">
					</td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<td>
						<label>
						  <input type="checkbox" id="cbox1" name="box" value="checkbox1">
						  centered data.
						</label>
					</td>
				
				</tr>
				           
			</div>
				
				
					
				<div id="menu">
					 <input type="submit" value="Submit"> 
					 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					  <input type="submit" value="Cancel">  
				</div>	
				    
	        </section>
	        
	      </div>
	      
	      <footer class="row col-sm-12">
	        <div class="panel panel-body">
	          <p> NaviRoma is created and maintained by <a href="http://sysbio.curie.fr/" title="http://sysbio.curie.fr/">Computational Systems Biology of Cancer</a>  in  <a href="https://curie.fr/" title="https://curie.fr/"> Institut Curie</a> .</p>
	          <p> copyright: Aout 2017 </p> 
	        </div>
	      </footer>
	    </div>
        </form>
    </body>
</html>
