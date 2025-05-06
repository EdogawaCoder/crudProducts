package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Product;
import repositories.ProductRepository;

public class ProductController {

	public void managerProducts() {

		var scanner = new Scanner(System.in);

		System.out.println("Choose an option: \n ");
		System.out.println("1 - Insert a product ");
		System.out.println("2 - List product");
		System.out.println("3 - Update the product");
		System.out.println("4 - Delete product \n");
		System.out.print("Choose an option: ");

		var option = scanner.nextLine();

		var productRepository = new ProductRepository();

		switch (option) {

		case "1":
			var productRegist = new Product();
			
			productRegist.setId(UUID.randomUUID());

			System.out.print("NAME........: ");
			productRegist.setName(scanner.nextLine());

			System.out.print("PRICE........: ");
			productRegist.setPrice(Double.parseDouble(scanner.nextLine()));

			System.out.print("QUANTITY........: ");
			productRegist.setQuantity(Integer.parseInt(scanner.nextLine()));
			
			productRepository.inserir(productRegist);
			break;

		case "2":
			
			productRepository.consultar(null);
			
			break;

case "3":
			
			var produtoEdicao = new Product();
			
			produtoEdicao.setId(UUID.randomUUID());
			
			System.out.print("ID..........: ");
			produtoEdicao.setId(UUID.fromString(scanner.nextLine()));
			
			System.out.print("NAME........: ");
			produtoEdicao.setName(scanner.nextLine());
			
			System.out.print("PREÇO.......: ");
			produtoEdicao.setPrice(Double.parseDouble(scanner.nextLine()));
			
			System.out.print("QUANTIDADE..: ");
			produtoEdicao.setQuantity(Integer.parseInt(scanner.nextLine()));
			
			productRepository.alterar(produtoEdicao);
			
			break;
			
		case "4":
			
			System.out.print("ID..........: ");
			var id = UUID.fromString(scanner.nextLine());
			
			productRepository.excluir(id);
			
			break;
			
		default:
			System.out.println("\nOpção inválida!");
			break;
		}
		
		scanner.close();
	}
}