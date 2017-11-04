package service;

import java.util.ArrayList;

import dao.EstabelecimentoDAO;
import model.Estabelecimento;;

public class EstabelecimentoService
	{
		EstabelecimentoDAO dao = new EstabelecimentoDAO();

		public Estabelecimento criar(Estabelecimento estabelecimento)
			{
				estabelecimento = dao.criar(estabelecimento);
				return estabelecimento;
			}

		public void atualizar(Estabelecimento estabelecimento)
			{
				dao.atualizar(estabelecimento);
			}

		public void excluir(Estabelecimento estabelecimento)
			{
				dao.excluir(estabelecimento);
			}

		public Estabelecimento carregar(int id)
			{
				return dao.carregar(id);
			}
		
		public ArrayList<Estabelecimento> listarEstabelecimentos(){
			return dao.listarEstabelecimentos();
		}
		public ArrayList<Estabelecimento> listarEstabelecimentos(String chave){
			return dao.listarEstabelecimentos(chave);
		}
	}
