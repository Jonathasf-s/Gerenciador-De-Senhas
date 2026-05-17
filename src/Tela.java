import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {

        private Logica logica;
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

        // ingecao de Dependencia
        Logica logica = new Logica();


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

        // craindo o tamanho da seenha
        JTextArea passwordLengthImputArea = new JTextArea();
        passwordLengthImputArea.setFont(new Font("Dialog",Font.PLAIN, 32));
        passwordLengthImputArea.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordLengthImputArea.setBounds(310,215,192,39);
        add(passwordLengthImputArea);



        // criando o Label da senha
        JLabel tamanhoDaSenha = new JLabel("Tamanho da Senha");
        tamanhoDaSenha.setFont(new Font("Roboto",Font.BOLD,20));
        tamanhoDaSenha.setBounds(25,215,272,39);
        add(tamanhoDaSenha);


        // botoes para escolher o tipo de senha

        JToggleButton uppercaseButton = new JToggleButton("Caixa alta");
        uppercaseButton.setBounds(25, 302, 225,56);
        add(uppercaseButton);

        //lowcase letter Button

        JToggleButton lowcaseButton = new JToggleButton("Letras minusculas");
        lowcaseButton.setBounds(25, 373, 225, 56);
        add(lowcaseButton);

        // botao para escolher numeros
        JToggleButton numbersButton = new JToggleButton("Numeros");
        numbersButton.setBounds(282, 302, 225, 56);
        add(numbersButton);

        // botao para escolher caracteres especiais

        JToggleButton symbolsButton = new JToggleButton("Simbolos");
        symbolsButton.setBounds(282, 373, 225, 56);
        add(symbolsButton);

        // Criando o botao para Startar

        JButton generateButton = new JButton("Gerar");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // validaçao: geraçao de senha apenas quando o tamanho *length* > 0 e um dos botoes for apertado
                if (passwordLengthImputArea.getText().length()<= 0 ) return;
                boolean anyToggleSelected = lowcaseButton.isSelected() || uppercaseButton.isSelected() || numbersButton.isSelected() || symbolsButton.isSelected();

                // gerador de senha
                int passwordLength = Integer.parseInt(passwordLengthImputArea.getText());
                if(anyToggleSelected){

                    String inciacaoDesenha = logica.geracaoSenha(passwordLength,uppercaseButton.isSelected(),
                            lowcaseButton.isSelected(),
                            numbersButton.isSelected(),
                            symbolsButton.isSelected());

                    // display da senha
                    senhaInput.setText(inciacaoDesenha);

                }
            }
        });
        //tudo pronto
        add(generateButton);
    }


}
