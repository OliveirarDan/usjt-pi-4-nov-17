<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Alterar Estabelecimento</title>

            <link href="assets/css/bootstrap.min.css" rel="stylesheet">
            <link href="assets/css/style.css" rel="stylesheet">
        </head>

        <body>
     
                <!-- Container Principal -->
                <div id="main" class="container">
                    <h3 class="page-header">Alterar Estabelecimento #${cliente.id }</h3>
                    <!-- Formulario para alteração de clientes -->
                    <form action="controller.do" method="post">
                        <!-- area de campos do form -->
                        <input type="hidden" name="id" value="${cliente.id }" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome completo" value="${estabelecimento.nome }">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label for="endereco">Endereço</label>
                                <input type="endereco" class="form-control" name="endereco" id="endereco" maxlength="15"  placeholder="endereco" value="${estabelecimento.endereco }">
                            </div>

                            <div class="form-group col-md-6">
                                <label for="horario">Horário</label>
                                <input type="horario" class="form-control" name="horario" id="horario" required maxlength="60" placeholder="horario" value="${estabelecimento.horario }">
                            </div>
                           <div class="form-group col-md-6">
                                <label for="telefone">Telefone</label>
                                <input type="telefone" class="form-control" name="telefone" id="telefone" required maxlength="60" placeholder="telefone" value="${estabelecimento.telefone }">
                            </div>
                        </div>
                           <div class="row">
                         <div class="form-group col-md-6">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" name="email" id="email" required maxlength="60" placeholder="email" value="${estabelecimento.email }">
                            </div>
                               <div class="form-group col-md-6">
                                <label for="site">Site</label>
                                <input type="site" class="form-control" name="site" id="site" required maxlength="60" placeholder="site" value="${estabelecimento.site }">
                            </div>
                          </div>
               
                        <hr/>
                        <div id="actions" class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn btn-primary" name="command" value="AlterarEstabelecimento">Salvar</button>
                                <a href="ListarEstabelecimento.jsp" class="btn btn-default">Cancelar</a>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="js/jquery.min.js"></script>
                <script src="js/bootstrap.min.js"></script>
        </body>

        </html>