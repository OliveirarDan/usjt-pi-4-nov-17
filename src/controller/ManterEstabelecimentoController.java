package controller;

import service.EstabelecimentoService;
import model.Estabelecimento;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManterEstabelecimentoController
 */
@WebServlet("/ManterEstabelecimento.do")
public class ManterEstabelecimentoController extends HttpServlet
	{
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public ManterEstabelecimentoController()
			{
				super();

			}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
				doPost(request, response);
			}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException
			{
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

				switch (acao)
					{
					case "Criar":
						es.criar(estabelecimento);
						estabelecimento = es.carregar(estabelecimento.getId());

						// manda parametro para o JSP via request
						request.setAttribute("estabelecimento", estabelecimento);
						dispatcher = request.getRequestDispatcher("estabelecimento.jsp");
						break;

					}

			}

	}
