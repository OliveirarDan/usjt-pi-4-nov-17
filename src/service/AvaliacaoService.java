package service;

import dao.AvaliacaoDAO;
import model.Avaliacao;;

public class AvaliacaoService
	{
		AvaliacaoDAO dao = new AvaliacaoDAO();

		public void criar(Avaliacao avaliacao)
			{
				dao.criar(avaliacao);
			}

		public void atualizar(Avaliacao avaliacao)
			{
				dao.atualizar(avaliacao);
			}

		public void excluir(Avaliacao avaliacao)
			{
				dao.excluir(avaliacao);
			}

		public Avaliacao carregar(int id)
			{
				return dao.carregar(id);
			}
	}
