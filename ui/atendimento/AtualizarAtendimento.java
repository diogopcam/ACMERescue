package ui.atendimento;
import dados.eventos.Evento;
import dados.StatusAtendimento;
import dados.catalogo.ListaEventos;
import excecoes.CampoVazio;
import ui.evento.JanelaEvento;
import ui.evento.JanelaGenerica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarAtendimento extends JanelaGenerica {
    private JPanel container;

    private JLabel labelDuracao, labelStatus;
    private JTextField duracaoTextField;
    private JButton atualizarAtendimento, sair, limparDados;
    private ListaEventos listaEventos;

    private JComboBox<String> listaStatus;
    private JanelaAtendimento janelaAnterior;
    private JFrame frame;
    private JTextArea area;
    private JScrollPane scrollPane;
    private Evento evento;
    private TratadorEventos tratador;

    public AtualizarAtendimento(JanelaAtendimento j, Evento e) {
        super();
        janelaAnterior = j;
        evento = e;

        listaEventos = janelaAnterior.getJanelaAnterior().getDadosEventos();
        tratador = new TratadorEventos();

        frame = new JFrame("Atualização de um atendimento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        labelDuracao = new JLabel("Duração (em horas): ");
        duracaoTextField = new JTextField(30);

        labelStatus = new JLabel("Status do atendimento: ");
        String[] opcoes = {"Executando", "Finalizado", "Cancelado"};
        listaStatus = new JComboBox<>(opcoes);

        atualizarAtendimento = new JButton("Atualizar atendimento");
        atualizarAtendimento.addActionListener(tratador);

        sair = new JButton("Sair");
        sair.addActionListener(tratador);

        limparDados = new JButton("Limpar dados");
        limparDados.addActionListener(tratador);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        container.add(criarPainel(labelDuracao, duracaoTextField));
        container.add(criarPainel(labelStatus, listaStatus));

        container.add(atualizarAtendimento);
        container.add(limparDados);
        container.add(sair);


        area = new JTextArea(20, 50);
        scrollPane = new JScrollPane(area);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        container.add(scrollPane);

        frame.add(container);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        this.pack();
    }

    public JPanel criarPainel(JLabel label, JComboBox e) {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel.add(label);
        painel.add(e);
        return painel;
    }

    public void defineStatus(String s, Evento e) {
        switch (s) {
            case "Executando":
                e.getAtendimento().setStatus((StatusAtendimento.EXECUTANDO));
            case "Finalizado":
                e.getAtendimento().setStatus((StatusAtendimento.FINALIZADO));
            case "Cancelado":
                e.getAtendimento().setStatus((StatusAtendimento.CANCELADO));
        }
    }

    private class TratadorEventos extends Component implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == atualizarAtendimento) {
                try{
                    if(duracaoTextField.getText().isEmpty()){
                        throw new CampoVazio("O campo de duração deve ser preenchido! ");
                    } else {
                        if(listaEventos.formatoCodigo(duracaoTextField.getText())) {
                            String status = (String) listaStatus.getSelectedItem();
                            defineStatus(status, evento);
                            area.setText("Atendimento do evento cadastrado com sucesso! ");
                        } else {
                            throw new NumberFormatException("O campo de duração deve ser preenchido com um valor numérico inteiro!");
                        }
                    }
                } catch (CampoVazio v){
                    area.setText(v.getMessage());
                    JOptionPane.showMessageDialog(AtualizarAtendimento.this, v.getMessage());
                } catch (NumberFormatException n){
                    area.setText(n.getMessage());
                    JOptionPane.showMessageDialog(AtualizarAtendimento.this, n.getMessage());
                }
            }
        }
    }
}


