package app;

import java.util.Scanner;

public class Questoes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[][] questions = { { "Qual é a melhor linguagem de programação?", "Todas" },
				{ "Java e JavaScript são a mesma coisa?", "Não" } };
				
		for (int i = 0; i < questions.length; i++) {
			String pergunta = questions[i][0];
			String respostaCorreta = questions[i][1];

			System.out.println(pergunta);
			String respostaDoUsuario = sc.nextLine();

			if (respostaDoUsuario.equalsIgnoreCase(respostaCorreta)) {
				System.out.println("Resposta correta!");
			} else {
				System.out.println("Resposta incorreta.");
			}
			
		}

		sc.close();
	}
	
	//Métodos
	public void totalDeAcertos() {
 		int totalAcertos;
 	}
 	
 	public void totalDeErros() {
 		int totalErros;
 	}
}