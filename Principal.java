import javax.swing.JFrame;

public class Principal {
    public static void main(String[] args) throws Exception {
        Formulario f = new Formulario();

        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);

    }
}
