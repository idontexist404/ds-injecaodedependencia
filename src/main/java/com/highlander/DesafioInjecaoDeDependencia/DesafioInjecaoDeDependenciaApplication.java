package com.highlander.DesafioInjecaoDeDependencia;

import com.highlander.DesafioInjecaoDeDependencia.entities.Order;
import com.highlander.DesafioInjecaoDeDependencia.services.OrderService;
import com.highlander.DesafioInjecaoDeDependencia.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioInjecaoDeDependenciaApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	@Autowired
	private ShippingService shippingService;


	public static void main(String[] args) {
		SpringApplication.run(DesafioInjecaoDeDependenciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		Scanner input = new Scanner(System.in);
		Order order = new Order();

		System.out.println("-------------------------------");
		System.out.println("Digite o código do produto: ");
		int code = input.nextInt();
		order.setCode(code);

		System.out.println("Digite o valor básico do produto: ");
		double basic = input.nextDouble();
		order.setBasic(basic);

		System.out.println("Digite a porcentagem de desconto do produto: ");
		double discount = input.nextDouble();
		order.setDiscount(discount);

		System.out.println("-------------------------------");
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total:  R$%.2f%n ", orderService.total(order) );
	}
}
