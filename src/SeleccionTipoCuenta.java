import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.SQLOutput;

public class SeleccionTipoCuenta extends JFrame {

    public SeleccionTipoCuenta() {
        setTitle("Seleccionar tipo de cuenta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Usamos layout absoluto para ubicar los componentes con coordenadas

        // Título principal
        JLabel titulo = new JLabel("Elige tu tipo de cuenta");
        titulo.setFont(new Font("Arial", Font.PLAIN, 18));
        titulo.setBounds(310, 50, 200, 30);
        add(titulo);

        // Botón para Estudiante
        JButton btnEstudiante = crearBotonConImagen("Estudiante.png", "Estudiante");
        btnEstudiante.setBounds(120, 120, 120, 180);
        btnEstudiante.addActionListener(e -> {
            System.out.println("Ir a pantalla de Estudiante"); // Borrar esto cuando se haya conectado al siguiente apartado
            // =============================
            // AQUÍ VA LA LÓGICA PARA CAMBIAR A LA PANTALLA DEL ESTUDIANTE O INICIO DE SESIÓN
            // =============================
        });


        add(btnEstudiante);

        // Botón para Usuario
        JButton btnProfesor = crearBotonConImagen("Profesor.png", "Profesor");
        btnProfesor.setBounds(340, 120, 120, 180);
        btnProfesor.addActionListener(e -> {
            System.out.println("Ir a pantalla de Profesor"); // Borrar esto cuando se haya conectado al siguiente apartado
            // =============================
            // AQUÍ VA LA LÓGICA PARA CAMBIAR A LA PANTALLA DEL PROFESOR
            // =============================
        });
        add(btnProfesor);

        // Botón para Familia y Amigos
        JButton btnFamilia = crearBotonConImagen("Familia.jpg", "Familia y amigos");
        btnFamilia.setBounds(560, 120, 120, 180);
        btnFamilia.addActionListener(e -> {
            System.out.println("Ir a pantalla de Familia y amigos"); // Borrar esto cuando se haya conectado al siguiente apartado

            // =============================
            // AQUÍ VA LA LÓGICA PARA CAMBIAR A LA PANTALLA DE FAMILIA Y AMIGOS
            // =============================
        });
        add(btnFamilia);

        // Texto y enlace de inicio de sesión
        JLabel loginLabel = new JLabel("¿Ya tienes cuenta?");
        loginLabel.setBounds(300, 330, 130, 30);
        add(loginLabel);
        // Lógica del "link" clickeable
        JLabel loginLink = new JLabel("<html><a href=''>Inicia sesión aquí</a></html>");
        loginLink.setForeground(Color.BLUE);
        loginLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginLink.setBounds(420, 330, 150, 30);
        loginLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Ir a pantalla de inicio de sesión"); // Borrar esto cuando se haya conectado al siguiente apartado
                // =============================
                // AQUÍ VA LA LÓGICA PARA CAMBIAR A LA PANTALLA DE INICIO DE SESIÓN EN CASO DE TENER YA UNA CUENTA
                // =============================
            }
        });
        add(loginLink);
        setVisible(true);
    }
    private JButton crearBotonConImagen(String nombreArchivo, String texto) {
       URL url = getClass().getResource("/Img/" + nombreArchivo);
       if(url == null){
           System.out.println("No se encontro la imagen. " + nombreArchivo);
           return new JButton(texto);
       }

        ImageIcon iconoOriginal = new ImageIcon(url); // Cargar imagen
        Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Reescalamiento de la imagen extraida de la carpeta Img
        ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

        JButton boton = new JButton(texto, iconoEscalado);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setBorderPainted(false);
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);

        return boton;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeleccionTipoCuenta::new);
    }
}
