package command;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Estabelecimento;
import service.EstabelecimentoService;

public class CriarEstabelecimento implements Command
{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		String uNome = request.getParameter("txtNome");
		String uEndereco = request.getParameter("txtEndereco");
		Float uLat = Float.parseFloat(request.getParameter("txtLatitude"));
		Float uLng = Float.parseFloat(request.getParameter("txtLongitude"));
		String uHorario = request.getParameter("txtHorario");
		String uTelefone = request.getParameter("txtTelefone");
		String uEmail = request.getParameter("txtEmail");
		String uSite = request.getParameter("txtSite");
		Integer uCategoria = Integer.parseInt(request.getParameter("optCategoria"));

		String acao = request.getParameter("acao");

		// instanciar o javabean
		Estabelecimento estabelecimento = new Estabelecimento();
		estabelecimento.setNome(uNome);
		estabelecimento.setEndereco(uEndereco);
		estabelecimento.setLat(uLat);
		estabelecimento.setLng(uLng);
		estabelecimento.setHorario(uHorario);
		estabelecimento.setTelefone(uTelefone);
		estabelecimento.setEmail(uEmail);
		estabelecimento.setSite(uSite);
		estabelecimento.setIdCategoria(uCategoria);
		RequestDispatcher dispatcher = null;
		EstabelecimentoService es = new EstabelecimentoService();
		int insertedId;
		insertedId = es.criar(estabelecimento);
		estabelecimento.setId(insertedId);
		
		String jsonObject = "{"
				+ "\"id\":  \"" + estabelecimento.getId() + "\", "
				+ "\"endereco\": \"" + estabelecimento.getEndereco() + "\", "
				+ "\"lat\": \"" + estabelecimento.getLat() + "\", "
				+ "\"lng\": \"" + estabelecimento.getLng() + "\", "
				+ "\"horario\": \"" + estabelecimento.getHorario() + "\", "
				+ "\"telefone\": \"" + estabelecimento.getTelefone() + "\", "
				+ "\"email\": \"" + estabelecimento.getEmail() + "\", "
				+ "\"site\": \"" + estabelecimento.getSite() + "\", "
				+ "\"categoria\": \"" + estabelecimento.getCategoria().getNome()
				+ "\"}";
		

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(jsonObject);
		
		dispatcher = request.getRequestDispatcher("estabelecimento.jsp");
		
	}

}
