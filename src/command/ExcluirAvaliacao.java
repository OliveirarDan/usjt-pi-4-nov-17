package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import service.AvaliacaoService;

public class ExcluirAvaliacao implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String aId = request.getParameter("aId");
		
		int id = -1;
		
		try {
			id = Integer.parseInt(aId);
		} catch (NumberFormatException e) {
			
		}
		
		//Instanciar o javabean
		Avaliacao avaliacao =  new Avaliacao();
		avaliacao.setId(id);
		
		//instanciar o service
		AvaliacaoService as = new AvaliacaoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		as.excluir(avaliacao);
		
		
		
		
	}

}
