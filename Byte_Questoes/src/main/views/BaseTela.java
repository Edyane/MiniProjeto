package main.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import main.controllers.ControleDeQuestoes;


/**
 * A classe BaseTela representa uma tela base para as telas da aplicação.
 * Ela fornece funcionalidades comuns, como a criação da janela, adição de
 * componentes e métodos para exibir e fechar a tela.
 */
public class BaseTela implements ActionListener{
    protected JFrame janela;
    protected JLabel titulo;
    protected JButton botaoMenu;

    protected ControleDeQuestoes controleDeQuestoes;

    /**
     * Construtor da classe BaseTela.
     * @param controleDeQuestoes o controle de questões da aplicação.
     * @param nomeJanela o nome da janela.
     * @param tituloJanela o título da janela.
     */
    public BaseTela(ControleDeQuestoes controleDeQuestoes, String nomeJanela, String tituloJanela) {
        this.controleDeQuestoes = controleDeQuestoes;

        // Setando textos e fontes
        this.janela = new JFrame(nomeJanela);

        this.titulo = new JLabel(tituloJanela);
        this.titulo.setFont(new Font("Poppins", Font.BOLD, 20));

        this.janela.setLayout(null); //Setando layout da janela;
        this.janela.setSize(500, 300);
        this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.janela.setLocationRelativeTo(null);

        this.janela.add(this.titulo);

    }

    /**
     * Exibe a tela.
     */
    public void exibirTela() {
        this.janela.setVisible(true);
    }

    /**
     * Fecha a tela.
     */
    public void fecharTela() {
        this.janela.setVisible(false);
    }

    /**
     * Método de ação executado quando ocorre um evento.
     * @param e o evento que foi acionado.
     */
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Adiciona um botão de menu à tela.
     */
    protected void adicionaBotaoMenu() {
        this.botaoMenu = new JButton("menu");

        this.botaoMenu.setFont(new Font("Inter", Font.CENTER_BASELINE, 8));
        this.botaoMenu.setBounds(400, 10, 70, 20);
        // this.botaoMenu.setForeground(corbotaoMenuEBusca); //Setando cor para o título do botão listagem;
        this.botaoMenu.addActionListener(this);
        this.janela.add(this.botaoMenu);

    }
}
