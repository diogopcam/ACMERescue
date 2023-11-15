import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaEvento extends JFrame {
    private JTextField codigo, data, latitude, longitude;
    private JButton criarEvento;

    private JTextArea area;

    public JanelaEvento() {
        super();
        this.setTitle("Eventos T32");
        this.setSize(800, 600);

        codigo = new JTextField();
        data = new JTextField();
        latitude = new JTextField();
        longitude = new JTextField();
        criarEvento = new JButton("Criar evento");
        area = new JTextArea();


        JPanel container = new JPanel();
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        container.add(codigo);
        container.add(data);
        container.add(latitude);
        container.add(longitude);
        container.add(criarEvento);
        container.add(area);

        this.add(container);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.pack();

        TratadorEventos tratador = new TratadorEventos();
        criarEvento.addActionListener(tratador);

        this.setVisible(true);
    }

    class TratadorEventos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == criarEvento ) {
                double latitudeDoub = Double.parseDouble(latitude.getText());
                double longitudeDoub = Double.parseDouble(longitude.getText());
                Evento evento = new Evento(codigo.getText(), data.getText(),latitudeDoub, longitudeDoub);
                area.setText("Funcionou!\nCódigo do evento: "+evento.getCodigo()+"\nData do evento: "+evento.getData());
            }
        }
    }
}
