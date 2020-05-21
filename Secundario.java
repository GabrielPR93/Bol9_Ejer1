import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Secundario extends JDialog implements ActionListener, ItemListener {

    JTextField txtTitulo;
    JLabel lbl;
    JComboBox cb;

    String[] colores = { "Rojo", "Verde", "Azul", "Amarillo" };

    public Secundario(Formulario s) {
        super(s, true);
        setLayout(new FlowLayout());
        setTitle("Formulario Secundario");

        lbl = new JLabel("Introduce titulo estandar");
        add(lbl);

        txtTitulo = new JTextField(10);
        txtTitulo.addActionListener(this);
        add(txtTitulo);

        cb = new JComboBox<String>(colores);
        cb.setMaximumRowCount(4);
        cb.setSelectedIndex(0);
        cb.addItemListener(this);
        add(cb);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Formulario s = (Formulario) this.getOwner();
        s.setTitle(txtTitulo.getText());

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Formulario s = (Formulario) this.getOwner();

        if (cb.getSelectedIndex() == 0) {
            s.btn1.setBackground(Color.RED);
            s.btn2.setBackground(Color.RED);
        } else if (cb.getSelectedIndex() == 1) {
            s.btn1.setBackground(Color.GREEN);
            s.btn2.setBackground(Color.GREEN);
        } else if (cb.getSelectedIndex() == 2) {
            s.btn1.setBackground(Color.BLUE);
            s.btn2.setBackground(Color.BLUE);
        } else if (cb.getSelectedIndex() == 3) {
            s.btn1.setBackground(Color.YELLOW);
            s.btn2.setBackground(Color.YELLOW);
        }

    }
}