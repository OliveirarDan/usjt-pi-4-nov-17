package service;

import dao.CategoriaDAO;
import model.Categoria;;

public class CategoriaService
	{
		CategoriaDAO dao = new CategoriaDAO();

		public void criar(Categoria categoria)
			{
				dao.criar(categoria);
			}

		public void atualizar(Categoria categoria)
			{
				dao.atualizar(categoria);
			}

		public void excluir(Categoria categoria)
			{
				dao.excluir(categoria);
			}

		public Categoria carregar(int id)
			{
				return dao.carregar(id);
			}
	}
