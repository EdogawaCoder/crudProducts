package repositories;

import java.util.UUID;

import entities.Product;
import factories.ConnectionFactory;

public class ProductRepository {

	ConnectionFactory connectionFactory = new ConnectionFactory();

	public void inserir(Product product) {

		try { 
			
			// abrir conexao
			var connection = connectionFactory.obterConexao();

			// comando sql
			var stmt = connection.prepareStatement("insert into product(id, name, price, quantity) values(?,?,?,?)");
			stmt.setObject(1, product.getId());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.execute();
			
			connection.close();
			
			System.out.println("Product inserted.");
			
		} catch (Exception e) {
			System.out.println("\nErro" + e.getMessage());
		}
	}

	public void alterar(Product product) {
		try {
			// abrir conexao
						var connection = connectionFactory.obterConexao();

						// comando sql
						var stmt = connection.prepareStatement("update product set name=?, price=?, quantity=? where id=?");
						stmt.setObject(4, product.getId());
						stmt.setString(1, product.getName());
						stmt.setDouble(2, product.getPrice());
						stmt.setInt(3, product.getQuantity());
						stmt.execute();
						
						connection.close();
			
						System.out.println("Product changed.");

		} catch (Exception e) {
			System.out.println("\nErro" + e.getMessage());
		}
	}

	public void excluir(UUID id) {
		try {
			
			var connection = connectionFactory.obterConexao();

			// comando sql
			
			var stmt = connection.prepareStatement("delete from product where id=?");
		
			stmt.setObject(1, id);
			stmt.execute();
			
			connection.close();

			System.out.println("Product deleted.");
			
		} catch (Exception e) {
			System.out.println("\nErro" + e.getMessage());
		}
	}

	public void consultar(Product product) {
		try {
			
			var connection = connectionFactory.obterConexao();

			// comando sql
			var stmt = connection.prepareStatement("select * from product");
			
			var result = stmt.executeQuery();
			
			while(result.next()) {
				System.out.println("ID......:" + result.getString("id"));
				System.out.println("NAME......:" + result.getString("name"));
				System.out.println("PRICE......:" + result.getString("price"));
				System.out.println("QUANTITY......:" + result.getString("quantity"));
			}
			
			
			
			
			connection.close();

			System.out.println("Product detailed.");


		} catch (Exception e) {
			System.out.println("\nErro" + e.getMessage());
		}

	}

}
