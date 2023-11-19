package ui;

import javax.swing.*;
import java.awt.*;

public class JanelaGenerica extends JFrame{

    public JanelaGenerica(){
        super();
    }

    public JPanel criarPainel(JLabel label, JTextField campoTexto) {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.add(label);
        painel.add(campoTexto);
        return painel;
    }
}
