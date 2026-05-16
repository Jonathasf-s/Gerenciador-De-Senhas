import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

    public Tela(){



        super("Gerador Automatico de Senhas");

        /* 540 é um valor padrao para a largura e 570 um valor padrao para a altura
        sempre temos que ter em mente esses valores quando usar o JPanel porque ele nao faz recize automatico para o monitor
        nao sei se existe uma forma de fazer ele indentificar um tamanho especifico para cada monitor
        */

        setSize(540, 570);

        //nao vai mudar de tamanho
        setResizable(false);

        // fechar o programa encerra a aplicaçao
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // faz com q a janela abra no centro da tela
        setLocationRelativeTo(null);


        // Renderiza os componentes da tela
        addComponentesDeTela();
    }

    private void addComponentesDeTela(){
        setLayout(null);

        JLabel titulo = new JLabel("Gerenciador de senhas");

        titulo.setFont(new Font("Dialog",Font.BOLD,20));


        // Centralizar o texto, preciso mudar isso no jogo da Cobrinha
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

         /*Seta cordenadas para o titulo, ele see mantem no centro mas com 10 de elevaçao,
        as o texto pode ocupar a tela inteira, e as letras podem ir a uma altura de 39 unidas no plano.
        */

        titulo.setBounds(0,10,540,70);






        add(titulo);


        JTextArea senhaInput = new JTextArea();

        // evitando que a Area de texto seja editada
        senhaInput.setEditable(false);
        senhaInput.setFont(new Font("roboto",Font.BOLD,30));

        // adicionando barra de Scrol, caso a senha fique muito grande

        JScrollPane senhaImputPane = new JScrollPane(senhaInput);
        senhaImputPane.setBounds(25,97,479,70);

        //Criar bordas
        senhaImputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(senhaImputPane);

        // criando a escolha do tamanho da senha
        JLabel tamanhoDaSenha = new JLabel("Tamanho da Senha");
        tamanhoDaSenha.setFont(new Font("Roboto",Font.BOLD,20));
        tamanhoDaSenha.setBounds(25,215,272,39);
        add(tamanhoDaSenha);


        // botoes para escolher o tipo de senha

        JToggleButton uppercaseButton = new JToggleButton("Caixa alta");
        uppercaseButton.setBounds(25, 302, 225,56);
        add(uppercaseButton);

        //lowcase letter Button

        JToggleButton lowcaseButton = new JToggleButton("Letras miudas");
        lowcaseButton.setBounds(282, 302, 225, 56);
        add(lowcaseButton);

        // botao para escolher numeros
        JToggleButton numbersButton = new JToggleButton("Numeros");
        numbersButton. setBounds(25, 373, 225, 56);
        add(numbersButton);

        // botao para escolher caracteres especiais

        JToggleButton symbolsButton = new JToggleButton("Simbolos");
        numbersButton. setBounds(282, 373, 225, 56);
        add(symbolsButton);
    }


}
