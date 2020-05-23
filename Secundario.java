import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Secundario extends JDialog implements ActionListener, ItemListener {

    JTextField txtTitulo;
    JLabel lbl;
    JComboBox cb;

    String[] color = { "Rojo", "Verde", "Azul", "Amarillo" };
    Color[] colores = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW };

    Formulario s = (Formulario) this.getOwner();

    public Secundario(Formulario s) {
        super(s, true);
        setLayout(new FlowLayout());
        setTitle("Formulario Secundario ");

        lbl = new JLabel("Introduce titulo estandar");
        add(lbl);

        txtTitulo = new JTextField(10);
        txtTitulo.addActionListener(this);
        add(txtTitulo);

        cb = new JComboBox<String>(color);
        cb.setMaximumRowCount(4);
        cb.setSelectedIndex(0);
        cb.addItemListener(this);
        add(cb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        s.titulo = txtTitulo.getText();
        s.setTitle(s.titulo);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        s.primerColor = colores[cb.getSelectedIndex()];
        s.segundoColor = colores[cb.getSelectedIndex()];

    }
}