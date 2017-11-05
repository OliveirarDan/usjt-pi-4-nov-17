use `usjt-pi-4`;

-- preencher tabela
INSERT INTO tbl_categoria(nome) VALUES ('BAR/RESTAURANTE');
INSERT INTO tbl_categoria(nome) VALUES ('CINEMA');
INSERT INTO tbl_categoria(nome) VALUES ('HOTEL');
INSERT INTO tbl_categoria(nome) VALUES ('OUTROS');

-- preencher usuario
INSERT INTO tbl_usuario(nome, sobrenome, email, senha, foto_perfil) VALUES ('Danilo', 'Oliveira', 'danilo@oliveira.com', '1234', '');
INSERT INTO tbl_usuario(nome, sobrenome, email, senha, foto_perfil) VALUES ('Estevão', 'Palhacinho', 'estevão@palhacinho.com', '1234', '');
INSERT INTO tbl_usuario(nome, sobrenome, email, senha, foto_perfil) VALUES ('Marcelinha', 'Brava', 'marcelinha@brava.com', '1234', '');
INSERT INTO tbl_usuario(nome, sobrenome, email, senha, foto_perfil) VALUES ('Nathalia', 'Nogueira', 'nathalia@nogueira.com', '1234', '');
INSERT INTO tbl_usuario(nome, sobrenome, email, senha, foto_perfil) VALUES ('Brasil', 'Marcelo', 'brasil@marcelo.com', '1234', '');

-- preencher estabelecimento
INSERT INTO tbl_estabelecimento(nome, endereco, lat, lng, horario_funcionamento, telefone, email, site,tbl_categoria_id_categoria) VALUES ('Casa do Pão de Queijo', 'Rua do pão de queijo', 10.123,12.234,'24horas por dia 7 dias por semana','1192349934','teste1@gmail.com','www,teste1.com','1');
INSERT INTO tbl_estabelecimento(nome, endereco, lat, lng, horario_funcionamento, telefone, email, site,tbl_categoria_id_categoria) VALUES ('Cinema do Pão de Queijo', 'Rua do pão de queijo', 10.123,12.234,'24horas por dia 7 dias por semana','1192349934','teste1@gmail.com','www,teste1.com','2');
INSERT INTO tbl_estabelecimento(nome, endereco, lat, lng, horario_funcionamento, telefone, email, site,tbl_categoria_id_categoria) VALUES ('Hotel do Pão de Queijo', 'Rua do pão de queijo', 10.123,12.234,'24horas por dia 7 dias por semana','1192349934','teste1@gmail.com','www,teste1.com','3');
INSERT INTO tbl_estabelecimento(nome, endereco, lat, lng, horario_funcionamento, telefone, email, site,tbl_categoria_id_categoria) VALUES ('Outra coisa do Pão de Queijo', 'Rua do pão de queijo', 10.123,12.234,'24horas por dia 7 dias por semana','1192349934','teste1@gmail.com','www,teste1.com','4');

-- preencher estabelecimento
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 1, 1, 1);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (4, 4, 4, 4, 4, 'Lugarzinho nota 4', 2, 1, 1);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (2, 2, 2, 2, 2, 'Lugarzinho nota 2', 2, 3, 3);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 4, 4, 4);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 3, 3, 3);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 1, 1, 1);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (4, 4, 4, 4, 4, 'Lugarzinho nota 4', 2, 1, 1);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (2, 2, 2, 2, 2, 'Lugarzinho nota 2', 2, 3, 3);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 4, 4, 4);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (3, 3, 3, 3, 3, 'Lugarzinho nota 3', 3, 3, 3);


select * from tbl_avaliacao;
select * from tbl_estabelecimento;
select * from tbl_usuario;
select * from tbl_categoria;


INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (1, 1, 1, 2, ((nota_acesso_cadeirante+nota_sanitario_cadeirante+nota_instrucao_braile+nota_sinalizacao_piso)/4), 'Lugarzinho nota 3', 3, 3, 3);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (5, 4, 3, 3, ((nota_acesso_cadeirante+nota_sanitario_cadeirante+nota_instrucao_braile+nota_sinalizacao_piso)/4), 'Lugarzinho nota 3', 3, 3, 3);
INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria) VALUES (1, 5, 4, 5, ((nota_acesso_cadeirante+nota_sanitario_cadeirante+nota_instrucao_braile+nota_sinalizacao_piso)/4), 'Lugarzinho nota 3', 3, 3, 3);

