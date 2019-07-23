<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />

<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
				    <li  class="active"><a href="#about">Cadastro Atendimento</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

	
		<h1>Atendimento</h1>
		
		<br />
		
		
		<form>
		     
		     <input type="hidden" id="idInstalacao" name="idInstalacao"/>
		     
		     <div class="row">
		     
		         <div class="col-md-8">
		         
		             <div class="form-group">
		             
                               <label for="numeroChamado">Número Chamado Instalação</label>
                               
                               <div class="input-group">
                               
	                               <input type="text" class="form-control" id="numeroInstalacao" placeholder="Número Instalação">
	                             
	                               <span class="input-group-btn">
	                                   <button type="button" class="btn btnMain" id="btn-tratar" >Tratar</button>
	                               </span>
                               </div>
                                
                       </div>
                       
                       <div class="demais-campos">
                       
	                        <div class="form-group">
	                        
	                              <label for="numeroChamado">Modelo do modem</label>
	                                     
	                              <select class="form-control" id="idModem">
								    <option selected> </option>
								    
								    <c:forEach var="item" items="${equipamentos}">
								         <option value="${item.id}">${item.nome}</option>
								    </c:forEach>
								    
								  </select>
							  
	                       </div>
	                       
	                        <hr>
	                       
	                       <h4>Instalação encerrada?</h4>
	                      
	                       <div class="row">
	                        <div class="col-md-12">
	                            
	                            <label class="radio-inline"> <input type="radio" name="instalacaoEncerrada"  id="instalacaoEncerrada" value="S" checked>
	                                Sim
	                            </label>
	                            
	                            <label class="radio-inline"> <input type="radio" name="instalacaoEncerrada" id="instalacaoEncerrada" value="N"  >
	                                Não
	                            </label>
	                        
	                        </div>
	                       </div>
	                       
	                       <hr>
	                       
	                       <div class="form-group">
	                        
	                              <label for="numeroChamado">Motivo para não instalação</label>
	                                     
	                              <select class="form-control" id="idAvarias" disabled="disabled">
	                               <option selected></option>
	                               
	                               <c:forEach var="item" items="${responsaveisAvarias}">
	                                     <option value="${item.id}">${item.nomeGrupoResponsavel}</option>
	                                </c:forEach>
	                                
	                             </select>
	                             
	                       </div>
	                       
	                        <div class="form-group">
                            
                                  <label for="numeroChamado">Descrição Motivo para não instalação</label>
                                         
                                   <input type="text" class="form-control" id="textoMotivoNaoInstalacao" placeholder="Descrição do problema"  disabled="disabled">
                                 
                           </div>
	                       
	                       <hr>
	                       
	                       <div class="form-group">
	                            <center>
	                                <button type="button" id="btn-reportar" class="btn btn-primary btn-lg">Reportar</button>
	                            </center>
	                       </div>
                       
                       </div>
		         
		         </div>
		         
		     </div>
		
		</form>
			
			
	</div>


	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/1.11.1/jquery.min.js"></script>
	
	<c:url value="/js/atendimento.js" var="jstlJs" />
    <script type="text/javascript" src="${jstlJs}"></script>
    


</body>

</html>
