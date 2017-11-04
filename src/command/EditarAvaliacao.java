package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Avaliacao;
import service.AvaliacaoService;

public class EditarAvaliacao implements Command
{

	@Override

	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//dados da avaliacï¿½o
		String aId = request.getParameter("aId");
		String aNotaAcessoCadeirante = request.getParameter("aNotaAcessoCadeirante");
		String aNotaSanitarioCadeirante = request.getParameter("aNotaSanitarioCadeirante");
		String aNotaInstrucaoBraile = request.getParameter("aNotaInstrucaoBraile");
		String aNotaSinalizacaoPiso = request.getParameter("aNotaSinalizacaoPiso");
//		String aNotaGeral = request.getParameter("aNotaGeral");
		String aComentario = request.getParameter("aComentario");
		int id =-1;
		try{
			id = Integer.parseInt(aId);
		} catch (NumberFormatException e){
			
		}
		
		//dados extras ESTABELECIMENTO
		int eId=1;
		
		//dados extras USUARIO
		int uId=1;
		
		//dados extras CATEGORIA
		int cId=1;
		
		
		//Instanciando o JavaBean Avaliacao
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(id);
		avaliacao.setNotaAcessoCadeirante(Integer.parseInt(aNotaAcessoCadeirante));
		avaliacao.setNotaSanitarioCadeirante(Integer.parseInt(aNotaSanitarioCadeirante));
		avaliacao.setNotaInstrucaoBraile(Integer.parseInt(aNotaInstrucaoBraile));
		avaliacao.setNotaSinalizacaoPiso(Integer.parseInt(aNotaSinalizacaoPiso));
//		avaliacao.setNotaGeral(Double.parseDouble(aNotaGeral));
		avaliacao.setComentario(aComentario);
		avaliacao.setId_Estabelecimento(eId);
		avaliacao.setId_Usuario(uId);
		avaliacao.setId_Categoria(cId);
		
		
		//Instanciando o service
		AvaliacaoService as = new AvaliacaoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		//Gerando média
		double media = avaliacao.getNotaAcessoCadeirante()+avaliacao.getNotaInstrucaoBraile()+avaliacao.getNotaSanitarioCadeirante()+avaliacao.getNotaSinalizacaoPiso();
		media = media/4;
		avaliacao.setNotaGeral(media);
		
		as.atualizar(avaliacao);
		request.setAttribute("avaliacao", avaliacao);
		view = request.getRequestDispatcher("AlterarAvaliacao.jsp");
		view.forward(request, response);
				
		

	}

}
