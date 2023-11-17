import jdk.jfr.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import jdk.jfr.Event;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaEvento extends JFrame {
    private JTextField codigo, data, latitude, longitude;
    private JButton criarEvento, limparCampos, eventosCad, sairCad;

    private JTextArea area;
    private TratadorEventos tratador;

    public JanelaEvento() {
        super();
        this.setTitle("Eventos T32");
        this.setSize(800, 600);

        codigo = new JTextField();
        data = new JTextField();
        latitude = new JTextField();
        longitude = new JTextField();
        criarEvento = new JButton("Criar evento");
        limparCampos = new JButton("Limpar campos");
        eventosCad = new JButton("Apresentar todos eventos");
        sairCad = new JButton("Sair");
        area = new JTextArea();



        JPanel container = new JPanel();
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(codigo);
        container.add(data);
        container.add(latitude);
        container.add(longitude);
        container.add(criarEvento);
        container.add(limparCampos);
        container.add(eventosCad);
        container.add(sairCad);

        container.add(area);

        this.add(container);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();

        tratador = new TratadorEventos();
        criarEvento.addActionListener(tratador);
        limparCampos.addActionListener(tratador);
        eventosCad.addActionListener(tratador);
        sairCad.addActionListener(tratador);

        this.setVisible(true);
    }

    class TratadorEventos implements ActionListener {
        ListaEventos listaEventos = new ListaEventos();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == criarEvento) {
                String codigoStr = codigo.getText();
                String dataStr = data.getText();
                double latitudeDoub = Double.parseDouble(latitude.getText());
                double longitudeDoub = Double.parseDouble(longitude.getText());
                Evento evento = new Evento(codigoStr, dataStr, latitudeDoub, longitudeDoub);

                boolean confere = listaEventos.addEvento(evento);

                if(confere){
                    int t = listaEventos.getListaEventos().size();
                    area.setText("Não há eventos com esse código e o tamanho da lista é "+t);
                } else {
                    area.setText("Cadastro não realizado! Já há um evento com esse código.");
                }
            }

            if(e.getSource() == limparCampos){
                codigo.setText(" ");
                data.setText(" ");
                latitude.setText(" ");
                longitude.setText(" ");
                area.setText(" ");
            }

            if(e.getSource() == eventosCad){
                listaEventos.ordEventos();
                area.setText(" ");
                for(Evento ev:listaEventos.getListaEventos()){
                    area.append(ev.eventoToString());
                    area.append("\n\n");
                }
            }

            if(e.getSource() == sairCad){
                System.exit(0);
            }
        }
    }
}

