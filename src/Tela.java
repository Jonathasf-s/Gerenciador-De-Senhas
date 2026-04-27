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

        JLabel titulo = new JLabel("Gerenciador de senhas");

        titulo.setFont(new Font("Dialog",Font.BOLD,20));

         /*Seta cordenadas para o titulo, ele see mantem no centro mas com 10 de elevaçao,
        as o texto pode ocupar a tela inteira, e as letras podem ir a uma altura de 39 unidas no plano.
        */


        titulo.setBounds(0,10,540,100);

        // Centralizar o texto, preciso mudar isso no jogo da Cobrinha

        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.TOP);

        add(titulo);
    }


}
