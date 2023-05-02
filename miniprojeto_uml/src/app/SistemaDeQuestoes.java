package app;

import java.util.Scanner;

public class SistemaDeQuestoes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println(" - - - - Seja bem vindo ao APP Questoes de Concurso! - - - -");
		System.out.println();
		System.out.println("Escolha uma disciplina: ");
		System.out.println("Digite 1 para Tecnologia da Informação!");
		System.out.println("Digite 2 para Big Data!");
		System.out.println("Digite 3 para Machine Learning!");
		System.out.println("");

		int opcao = sc.nextInt();
		String materia;

		switch (opcao) {
		case 1:
			materia = "Tecnologia da Informacao!";
			System.out.println("Você escolheu: " + materia);
			break;

		case 2:
			materia = "Big Data!";
			System.out.println("Você escolheu: " + materia);
			break;

		case 3:
			materia = "Machine Learning!";
			System.out.println("Você escolheu: " + materia);
			break;

		default:
			materia = "Valor invalido!";
			break;
		}

		sc.close();

	}

	// Métodos
	public void Questoes() {
		String questoes;
	}

}
