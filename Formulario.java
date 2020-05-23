
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Formulario extends JFrame {
    JButton btn1, btn2;
    JLabel lbl;

    Color primerColor = Color.RED;
    Color segundoColor = Color.GREEN;
    String titulo = "Control de Raton";

    public Formulario() {
        super();
        this.setLayout(null);
        this.setTitle(titulo);

        btn1 = new JButton("Izquierda");
        btn1.setSize(90, 20);
        btn1.setLocation(150, 20);
        btn1.addMouseListener(new cordenadas());
        btn1.addMouseMotionListener(new cordenadas());
        this.add(btn1);

        btn2 = new JButton("Derecha");
        btn2.setSize(90, 20);
        btn2.setLocation(250, 20);
        btn2.addMouseListener(new cordenadas());
        btn2.addMouseMotionListener(new cordenadas());
        this.add(btn2);

        lbl = new JLabel("Tecla Pulsada: Ninguna ");
        lbl.setSize(250, 100);
        lbl.setLocation(150, 40);
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

            setTitle(((String.format(titulo + " - (X:%d Y:%d) ", e.getX(), e.getY()))));
            if (e.getSource().getClass() == JButton.class) {
                setTitle(((String.format(titulo + " - (X:%d Y:%d) ", e.getX() + ((JButton) e.getSource()).getX(),
                        e.getY() + ((JButton) e.getSource()).getY()))));
            }

        }

        @Override
        public void mouseExited(MouseEvent e) {
            setTitle(titulo);
        }

        @Override
        public void mousePressed(MouseEvent e) {

            if (e.getButton() == MouseEvent.BUTTON1) {
                btn1.setBackground(primerColor);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                btn2.setBackground(segundoColor);
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

}