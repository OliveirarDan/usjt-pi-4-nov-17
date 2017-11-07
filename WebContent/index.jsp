<%@ page contentType="text/html; charset=ISO-8859-1" language="java"	pageEncoding="UTF-8" import="java.sql.*" errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-br">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png" />
<link rel="icon" type="image/png" href="assets/img/favicon.png" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<!-- verifica se há um usuário logado. -->
<c:if test="${empty usuario}">
    <c:redirect url="login.jsp" />
</c:if>


<title>Sem Barreiras | Você pode ir aonde você quiser</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!--  Arquivo de inclusao padrao de JS e CSS  -->
<jsp:include page="config.jsp"/>

<!--  JS  -->
<script src="assets/js/index.js"></script>
<!--  Google Maps  -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCKUbkUKty6JH0D33M50VHXJTiYZSpc958&libraries=places"></script>
</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="blue"
			data-image="assets/img/sidebar-1.jpg">
			<div class="logo">
				<a href="index.jsp" class="simple-text"> Sem
					Barreiras </a>
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="active"><a href="index.jsp"> <i
							class="material-icons">location_on</i>
							<p>Mapa</p>
					</a></li>
					<li><a href="javascript:void(0)" data-toggle="modal" data-target=".cadastrarEstabelecimento-modal"> <i class="material-icons">person</i>
							<p>Inserir novo local</p>
					</a></li>
					<li><a href="controller.do?command=ListarEstabelecimentoReiniciar"> <i class="material-icons">content_paste</i>
							<p>Meus locais</p>
					</a></li>
					<li><a href="javascript:void(0)" data-toggle="modal" data-target="meusDadosModal"> <i class="material-icons">face</i>
							<p>Meus dados</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<input id="pac-input" class="controls" type="text" placeholder="Buscar Endereço">
			<div id="map"></div>
		</div>
		<div class="modal fade cadastrarEstabelecimento-modal" tabindex="-1"
			role="dialog" aria-labelledby="cadastrarEstabelecimento">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<jsp:include page="estabelecimento.jsp"/>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
