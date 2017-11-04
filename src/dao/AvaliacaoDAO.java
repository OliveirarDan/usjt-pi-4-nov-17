package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Avaliacao;

public class AvaliacaoDAO
{

	public void criar(Avaliacao avaliacao)
	{
		String sqlInsert = "INSERT INTO tbl_avaliacao(nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setInt(1, avaliacao.getNotaAcessoCadeirante());
			stm.setInt(2, avaliacao.getNotaSanitarioCadeirante());
			stm.setInt(3, avaliacao.getNotaInstrucaoBraile());
			stm.setInt(4, avaliacao.getNotaSinalizacaoPiso());
			stm.setDouble(5, avaliacao.getNotaGeral());
			stm.setString(6, avaliacao.getComentario());
			stm.setInt(7, avaliacao.getId_Usuario());
			stm.setInt(8, avaliacao.getId_Estabelecimento());
			stm.setInt(9, avaliacao.getId_Categoria());

			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();)
			{
				if (rs.next())
				{
					avaliacao.setId(rs.getInt(1));
				}
			} catch (SQLException e)
			{
				String sqlUpdate = "UPDATE tbl_avaliacao SET nota_acesso_cadeirante=?, nota_sanitario_cadeirante=?, nota_instrucao_braile=?, "
						+ "nota_sinalizacao_piso=?, media_nota=?, comentario=? WHERE id_avaliacao=?";
				try (Connection conn1 = ConnectionFactory.obtemConexao();
						PreparedStatement stm1 = conn1.prepareStatement(sqlUpdate);)
				{
					stm1.setInt(1, avaliacao.getNotaAcessoCadeirante());
					stm1.setInt(2, avaliacao.getNotaSanitarioCadeirante());
					stm1.setInt(3, avaliacao.getNotaInstrucaoBraile());
					stm1.setInt(4, avaliacao.getNotaSinalizacaoPiso());
					stm1.setDouble(5, avaliacao.getNotaGeral());
					stm1.setString(6, avaliacao.getComentario());
					stm1.setInt(7, avaliacao.getId());
					stm1.execute();
				} catch (Exception e1)
				{
					e1.printStackTrace();
				}

			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public void atualizar(Avaliacao avaliacao)
	{
		String sqlUpdate = "UPDATE tbl_avaliacao SET nota_acesso_cadeirante=?, nota_sanitario_cadeirante=?, nota_instrucao_braile=?, "
				+ "nota_sinalizacao_piso=?, media_nota=?, comentario=? WHERE id_avaliacao=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setInt(1, avaliacao.getNotaAcessoCadeirante());
			stm.setInt(2, avaliacao.getNotaSanitarioCadeirante());
			stm.setInt(3, avaliacao.getNotaInstrucaoBraile());
			stm.setInt(4, avaliacao.getNotaSinalizacaoPiso());
			stm.setDouble(5, avaliacao.getNotaGeral());
			stm.setString(6, avaliacao.getComentario());
			stm.setInt(7, avaliacao.getId());
			stm.execute();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void excluir(Avaliacao avaliacao)
	{
		String sqlDelete = "DELETE FROM tbl_avaliacao WHERE id_avaliacao = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1, avaliacao.getId());
			stm.execute();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public Avaliacao carregar(int id)
	{
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setId(id);
		String sqlSelect = "SELECT nota_acesso_cadeirante, nota_sanitario_cadeirante, nota_instrucao_braile, nota_sinalizacao_piso, media_nota, comentario"
				+ " FROM tbl_avaliacao WHERE avaliacao.id_avaliacao = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			stm.setInt(1, avaliacao.getId());
			try (ResultSet rs = stm.executeQuery();)
			{

				Avaliacao avaliacao1 = new Avaliacao();
				avaliacao1.setId(id);
				String sqlSelect1 = "SELECT nota_acesso_cadeirante,nota_sanitario_cadeirante,nota_instrucao_braile,nota_sinalizacao_piso,media_nota,comentario,tbl_usuario_Id_usuario,tbl_estabelecimento_id_estabelecimento,tbl_estabelecimento_tbl_categoria_id_categoria"
						+ " FROM tbl_avaliacao WHERE tbl_avaliacao.id_avaliacao = ?";
				try (Connection conn1 = ConnectionFactory.obtemConexao();
						PreparedStatement stm1 = conn1.prepareStatement(sqlSelect1);)
				{
					stm1.setInt(1, avaliacao1.getId());
					try (ResultSet rs1 = stm1.executeQuery();)
					{
						if (rs1.next())
						{
							avaliacao1.setNotaAcessoCadeirante(rs1.getInt("nota_acesso_cadeirante"));
							avaliacao1.setNotaSanitarioCadeirante(rs1.getInt("nota_sanitario_cadeirante"));
							avaliacao1.setNotaInstrucaoBraile(rs1.getInt("nota_instrucao_braile"));
							avaliacao1.setNotaSinalizacaoPiso(rs1.getInt("nota_sinalizacao_piso"));
							avaliacao1.setNotaGeral(rs1.getDouble("media_nota"));
							avaliacao1.setComentario(rs1.getString("comentario"));
							avaliacao1.setId_Usuario(rs1.getInt("tbl_usuario_Id_usuario"));
							avaliacao1.setId_Estabelecimento(rs1.getInt("tbl_estabelecimento_id_estabelecimento"));
							avaliacao1.setId_Categoria(rs1.getInt("tbl_estabelecimento_tbl_categoria_id_categoria"));

						} else
						{
							avaliacao1.setId(-1);
							avaliacao1.setNotaAcessoCadeirante(-1);
							avaliacao1.setNotaSanitarioCadeirante(-1);
							avaliacao1.setNotaInstrucaoBraile(-1);
							avaliacao1.setNotaSinalizacaoPiso(-1);
							avaliacao1.setNotaGeral(-1);
							avaliacao1.setComentario(null);
							avaliacao1.setId_Usuario(-1);
							avaliacao1.setId_Estabelecimento(-1);
							avaliacao1.setId_Categoria(rs1.getInt(-1));
						}
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				} catch (SQLException e1)
				{
					System.out.print(e1.getStackTrace());
				}
				return avaliacao1;

			}
		} catch (SQLException e1)
		{
			System.out.print(e1.getStackTrace());
		}
		return avaliacao;
	}
}
