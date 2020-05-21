
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Formulario extends JFrame implements ActionListener {
    JButton btn1, btn2;
    JLabel lbl;

    public Formulario() {
        super("Control de Raton");
        this.setLayout(null);

        btn1 = new JButton("Izquierda");
        btn1.setSize(90, 20);
        btn1.setLocation(150, 0);
        btn1.addActionListener(this);
        btn1.addMouseListener(new cordenadas());
        btn1.addMouseMotionListener(new cordenadas());
        this.add(btn1);

        btn2 = new JButton("Derecha");
        btn2.setSize(90, 20);
        btn2.setLocation(250, 0);
        btn2.addActionListener(this);
        btn2.addMouseListener(new cordenadas());
        btn2.addMouseMotionListener(new cordenadas());
        this.add(btn2);

        lbl = new JLabel("Tecla Pulsada: Ninguna");
        lbl.setSize(250, 100);
        lbl.setLocation(150, 20);
        setFocusable(true);
        this.add(lbl);

        this.getContentPane().addMouseListener(new cordenadas());
        this.getContentPane().addMouseMotionListener(new cordenadas());
        addKeyListener(new teclado());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Deseas cerrar el programa?", "Salir",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (res == JOptionPane.OK_OPTION)
                    System.exit(0);
            }
        });

    }

    private class cordenadas extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {

            setTitle(((String.format("Control de ratón - (X:%d Y:%d) ", e.getX(), e.getY()))));
            if (e.getSource() == btn1) {
                setTitle(((String.format("Control de ratón - (X:%d Y:%d) ", e.getX() + 149, e.getY()))));
            }
            if (e.getSource() == btn2) {
                setTitle(((String.format("Control de ratón - (X:%d Y:%d) ", e.getX() + 249, e.getY()))));

            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle("Control de Raton");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btn1.setBackground(Color.RED);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                btn2.setBackground(Color.GREEN);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                btn1.setBackground(null);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                btn2.setBackground(null);
            }
        }

    }

    private class teclado extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            lbl.setText("Codigo tecla: " + e.getKeyCode() + " y unicode: " + e.getKeyChar());

            if (e.isControlDown() && e.getKeyCode() == e.VK_C) {

                Secundario s = new Secundario(Formulario.this);
                s.pack();
                s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                s.setVisible(true);

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}