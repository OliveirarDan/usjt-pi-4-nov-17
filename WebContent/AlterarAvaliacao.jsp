<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Avaliação</title>

			<link href="assets/starRating/css/styles.css" rel="stylesheet">
			<link href="assets/starRating/css/star-rating.css" rel="stylesheet">
			
            
        </head>

        <body>
                
                <!-- Container Principal -->
                <div >
                    <h3 >Alterar Avaliação #${avaliacao.id }</h3>
                    <!-- Formulario para alteração de Avaliacao -->
                    <form action="controller.do" method="post"  >
                        <!-- area de campos do form -->
                        <input type="hidden" name="aId" value="${avaliacao.id }" />
                        
                        <h3>Atualizar Avaliaçãos</h3>    
				    	<div id="aNotaAcessoCadeirante">
					    	<p>
						    	<label id="aNotaAcessoCadeirante" >Acesso cadeirante: </label>
						   		<select id="star-rating-1" name="aNotaAcessoCadeirante"  >
									<option value="${avaliacao.notaAcessoCadeirante}" selected="selected"> ${avaliacao.notaAcessoCadeirante}</option>
									<option value="5">5</option>
									<option value="4">4</option>
									<option value="3">3</option>
									<option value="2">2</option>
									<option value="1">1</option>
								</select>
							</p>
						</div> 
				    	<div  id="aNotaSanitarioCadeirante" >
					    	<p>
						    	<label id="aNotaSanitarioCadeirante" >Sanitário cadeirante: </label>
						   		<select id="star-rating-2" name="aNotaSanitarioCadeirante" >
									<option value="${avaliacao.notaSanitarioCadeirante}" selected="selected"> ${avaliacao.notaSanitarioCadeirante}</option>
									<option value="5">5</option>
									<option value="4">4</option>
									<option value="3">3</option>
									<option value="2">2</option>
									<option value="1">1</option>
								</select>
							</p>
						</div>	  
				    	<div  id="aNotaInstrucaoBraile" >
					    	<p>
						    	<label id="aNotaInstrucaoBraile" >Instrução em Braile: </label>
						   		<select id="star-rating-3" name="aNotaInstrucaoBraile" >
									<option value="${avaliacao.notaInstrucaoBraile}" selected="selected"> ${avaliacao.notaInstrucaoBraile}</option>
									<option value="5">5</option>
									<option value="4">4</option>
									<option value="3">3</option>
									<option value="2">2</option>
									<option value="1">1</option>
								</select>
							</p>
						</div>	  
				    	<div  id="aNotaSinalizacaoPiso" >
					    	<p>
						    	<label id="aNotaSinalizacaoPiso" >Sinalização de Piso: </label>
						   		<select id="star-rating-4" name="aNotaSinalizacaoPiso" >
						    		<option value="${avaliacao.notaSinalizacaoPiso}" selected="selected"> ${avaliacao.notaSinalizacaoPiso}</option>
									<option value="5">5</option>
									<option value="4">4</option>
									<option value="3">3</option>
									<option value="2">2</option>
									<option value="1">1</option>
								</select>
							</p>
						</div>  
    					<div>
    						<label id="aNotaGeral" >Nota Geral: ${avaliacao.notaGeral} </label>
    					</div>
				
					    
					    <div>
					    	<input type="text" placeholder="Comentario" name="aComentario" id="aComentario" value="${avaliacao.comentario}">
					    </div>
					                        
                        <hr />
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit"  name="command" value="EditarAvaliacao">Salvar</button>
                                <button type="submit"  name="command" value="ExcluirAvaliacao">Excluir</button>
                            </div>
                        </div>
                    </form>
                </div>
                
                <script src="assets/starRating/js/scale.fix.js"></script>
	<script src="assets/starRating/js/star-rating.min.js"></script>

	<script>
		
		
	
			var starrating1 = new StarRating( document.getElementById( 'star-rating-1' ));
			var starrating2 = new StarRating( document.getElementById( 'star-rating-2' ));
			var starrating3 = new StarRating( document.getElementById( 'star-rating-3' ));
			var starrating4 = new StarRating( document.getElementById( 'star-rating-4' ));
			
		
		//atualiza campos
	
			
		
		//validando rating
		function validar() {  
			
			
			
		    if(document.getElementById("star-rating-1").selectedIndex == ""){   
				alert('Esta faltando a nota de Acesso Cadeirante!');  
		        return false;
		    } else if(document.getElementById("star-rating-2").selectedIndex == ""){   
				alert('Esta faltando a nota de Sanitário Cadeirante!');  
		        return false;
		    } else if(document.getElementById("star-rating-3").selectedIndex == ""){   
				alert('Esta faltando a nota de Instrução em Braile!');  
		        return false;
		    } else if(document.getElementById("star-rating-4").selectedIndex == "" ){   
				alert('Esta faltando a nota de Sinalização de Piso!');  
		        return false;
		    } else {
				return true;
		    }  
		}

	</script>
               
        </body>

        </html>