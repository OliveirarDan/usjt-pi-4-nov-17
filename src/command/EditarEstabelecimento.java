package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Estabelecimento;
import service.EstabelecimentoService;

public class EditarEstabelecimento implements Command
{

 @Override

 public void executar(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

  String edID = request.getParameter("id");
  String edNome = request.getParameter("nome");
  String edEndereco = request.getParameter("endereco");
  String edHorario = request.getParameter("horario");
  String edTelefone = request.getParameter("telefone");
  String edEmail = request.getParameter("email");
  String edSite = request.getParameter("site");
  
  int id =-1;
  try{
   id = Integer.parseInt(edID);
  } catch (NumberFormatException e){
   
  }
  
  //dados extras CATEGORIA
    int cId=1;
  
  //Instanciando o JavaBean Editar Estabelecimento
  Estabelecimento estabelecimento = new Estabelecimento();
  estabelecimento.setId(id);
  estabelecimento.setNome(edNome);
  estabelecimento.setEndereco(edEndereco);
  estabelecimento.setHorario(edHorario);
  estabelecimento.setTelefone(edTelefone);
  estabelecimento.setEmail(edEmail);
  estabelecimento.setSite(edSite);
  estabelecimento.setIdCategoria(cId);
  
  EstabelecimentoService cs = new EstabelecimentoService();
	RequestDispatcher view = null;
	HttpSession session = request.getSession();

	cs.atualizar(estabelecimento);
	@SuppressWarnings("unchecked")
	ArrayList<Estabelecimento> lista = (ArrayList<Estabelecimento>) session
			.getAttribute("lista");
	int pos = busca(estabelecimento, lista);
	lista.remove(pos);
	lista.add(pos, estabelecimento);
	session.setAttribute("lista", lista);
	request.setAttribute("estabelecimento", estabelecimento);
	view = request.getRequestDispatcher("VisualizarEstabelecimento.jsp");

	view.forward(request, response);

}

public int busca(Estabelecimento estabelecimento, ArrayList<Estabelecimento> lista) {
	Estabelecimento to;
	for (int i = 0; i < lista.size(); i++) {
		to = lista.get(i);
		if (to.getId() == estabelecimento.getId()) {
			return i;
		}
	}
	return -1;
}

}
