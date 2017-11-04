package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Categoria;

public class CategoriaDAO
	{

		public void criar(Categoria categoria)
			{
				String sqlInsert = "INSERT INTO tbl_categoria(nome) VALUES (?)";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlInsert);)
					{
						stm.setString(1, categoria.getNome());

						stm.execute();
						String sqlQuery = "SELECT LAST_INSERT_ID()";
						try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
								ResultSet rs = stm2.executeQuery();)
							{
								if (rs.next())
									{
										categoria.setId(rs.getInt(1));
									}
							} catch (SQLException e)
							{
								e.printStackTrace();
							}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
			}

		public void atualizar(Categoria categoria)
			{
				String sqlUpdate = "UPDATE tbl_categoria SET nome=? WHERE id_categoria=?";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
					{
						stm.setString(1, categoria.getNome());
						stm.setInt(2, categoria.getId());

						stm.execute();
					} catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		public void excluir(Categoria categoria)
			{
				String sqlDelete = "DELETE FROM tbl_categoria WHERE id_categoria= ?";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlDelete);)
					{
						stm.setInt(1, categoria.getId());
						stm.execute();
					} catch (Exception e)
					{
						e.printStackTrace();
					}
			}

		public Categoria carregar(int id)
			{
				Categoria categoria = new Categoria();
				categoria.setId(id);
				String sqlSelect = "SELECT nome FROM tbl_categoria WHERE categoria.id_categoria= ?";
				try (Connection conn = ConnectionFactory.obtemConexao();
						PreparedStatement stm = conn.prepareStatement(sqlSelect);)
					{
						stm.setInt(1, categoria.getId());
						try (ResultSet rs = stm.executeQuery();)
							{
								if (rs.next())
									{
										categoria.setNome(rs.getString("nome"));

									} else
									{
										categoria.setId(-1);
										categoria.setNome(null);
									}
							} catch (SQLException e)
							{
								e.printStackTrace();
							}
					} catch (SQLException e1)
					{
						System.out.print(e1.getStackTrace());
					}
				return categoria;
			}
	}
