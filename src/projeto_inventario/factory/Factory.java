package projeto_inventario.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

	/*
	 * Declarar os atributos com as informações do banco
	 */
	
	//Nome do usuário do banco
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "root";
	
	//URL do banco
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/projeto_inventario";
	
	/*
	 * Método para establecer a conexão com o banco de dados
	 */
	
	public static Connection CreateConnectionToMySQL() throws Exception{
		//Carrega a classe do jdbc
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Cria a conexão com o banco
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		//Retorna a conexão
		return connection;
	}
}
