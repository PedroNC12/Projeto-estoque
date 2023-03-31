package projeto_inventario.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import projeto_inventario.dados.Produto;
import projeto_inventario.factory.Factory;

public class DAO {
	
	public void insert(Produto produto) {
		//String que vai realizar a ação de inserir no BD
		String SQL = "INSERT INTO projeto_inventario.produto(nome, quantidade) VALUES(?, ?)";
		
		//Instânciamento dos objetos para trabalhar o banco
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar a conexão
			con = Factory.CreateConnectionToMySQL();
			
			//Preparar a frase para realizar a query
			pstm = con.prepareStatement(SQL);
			
			pstm.setString(1, produto.getNome());
			pstm.setInt(2, produto.getQuantidade());
			
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
				if(con!=null) {
					con.close();
				}if(pstm!=null) {
					pstm.close();
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public List<Produto> listarProdutos(){
		//Objeto do tipo ArrayList usado para listar os produtos
		List<Produto> lista = new ArrayList<>();
		
		//String para realizar a query
		String SQL = "SELECT * FROM projeto_inventario.produto";
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			//Criar a conexão com o banco
			con = Factory.CreateConnectionToMySQL();
			
			//Preparar o objeto que irá realizar a query
			pstm = con.prepareStatement(SQL);
			
			//Preparar o objeto que irá recuperar os valores
			rs = pstm.executeQuery();
			
			//Instanciar o objeto da classe produto
			Produto produto = new Produto();
			
			//Recuperar os valores e adicioná-los à lista
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getInt(3));
				
				lista.add(produto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Verificar o estado e fechar as conexões
			try {
				if(con!=null) {
					con.close();
				}if(pstm!=null) {
					pstm.close();
				}if(rs!=null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return lista;
	}
	
	//Método para visualizar as informações de um único item
	public Produto visualizarProduto(String nome) {
		//String para realizar a query
		String SQL = "SELECT * FROM projeto_inventario.produto WHERE nome = ?";
		
		//Objetos para realizar a conexão
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		//Objeto da classe Produto
		Produto produto = new Produto();
		
		try {
			//Abrir a conexão
			con = Factory.CreateConnectionToMySQL();
			
			//Preparar a frase para query
			pstm = con.prepareStatement(SQL);
			
			pstm.setString(1, nome);
			
			//Preparar o ResultSet para recuperar os valores do banco
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				produto.setId(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setQuantidade(rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) {
					con.close();
				}if(pstm!=null) {
					pstm.close();
				}if(rs!=null) {
					rs.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return produto;
	}
	
	public void updateQuantidade(int quantidade, String nome) {
		//String para realizar a query
		String SQL = "UPDATE projeto_inventario.produto SET quantidade = ? WHERE nome = ?";
		
		//Objetos para cuidar da conexão e da query
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//Estabelecer a conexão com o banco
			con = Factory.CreateConnectionToMySQL();
			
			//Preparar a frase para query
			pstm = con.prepareStatement(SQL);
			
			pstm.setInt(1, quantidade);
			pstm.setString(2, nome);
			
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões, se estiverem abertas
			try {
				if(con!=null) {
					con.close();
				}if(pstm!=null) {
					pstm.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void deleteProduto(int id) {
		//String para realizar a query
		String SQL = "DELETE FROM projeto_inventario.produto WHERE id = ?";
		
		//Objetos para abrir a conexão e prepapar a frase para query
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			//Abrir a conexão
			con = Factory.CreateConnectionToMySQL();
			
			//Preparar a frase para query
			pstm = con.prepareStatement(SQL);
			
			pstm.setInt(1, id);
			
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//Fechar as conexões
			try {
			if(con!=null) {
				con.close();
			}if(pstm!=null) {
				pstm.close();
			}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		Produto prod = new Produto();
		
		dao.deleteProduto(35);
		
		for(Produto i : dao.listarProdutos()) {
			System.out.println(i.getId() +" " +i.getNome() +" " +i.getQuantidade());
		}
	}

}
