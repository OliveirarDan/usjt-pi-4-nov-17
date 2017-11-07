package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class EditarUsuario implements Command
{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			request.setCharacterEncoding("UTF-8");
		String uId = request.getParameter("id");
		String uNome = request.getParameter("nome");
		String uSobrenome = request.getParameter("sobrenome");
		String uEmail = request.getParameter("email");
		String uSenha = request.getParameter("senha");
		String uFoto = request.getParameter("foto");
		int id = -1;
		try
		{
			id = Integer.parseInt(uId);
		} catch (NumberFormatException e)
		{

		}

		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(uNome);
		usuario.setSobrenome(uSobrenome);
		usuario.setEmail(uEmail);
		usuario.setSenha(uSenha);

		if (uFoto != null && uFoto != "\t\t\t\t\t\t\t\t\t")
		{
			usuario.setFoto(uFoto);
		}

		// Instancia um usuário service
		UsuarioService us = new UsuarioService();
		HttpSession session = request.getSession();

		int result = us.atualizar(usuario);

		if (result == 0)
		{
			session.setAttribute("usuario", usuario);
			session.setAttribute("mensagem", "Dados atualizados com sucesso.");
		} else
		{
			session.setAttribute("mensagem", "Ocorreu um erro.");
		}

		// enviar para o jsp
		request.setAttribute("usuario", usuario);
		RequestDispatcher view = request.getRequestDispatcher("meus-dados.jsp");
		view.forward(request, response);
	}
}
