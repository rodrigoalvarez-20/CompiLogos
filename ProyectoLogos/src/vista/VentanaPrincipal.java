package vista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import modelo.Configuracion;
import modelo.Linea;
import modelo.compilador.Parser;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

    JTextArea areaDeCodigo;
    JScrollPane scrollCodigo;
    PanelDeDibujo panelDeDibujo;
    JButton ejecutar;
    JButton debug;
    JButton siguiente;
    Parser parser;
    boolean modoDebug;
    
    public VentanaPrincipal(){
        
        super("Logos");
        
        modoDebug = false;
        
        parser = new Parser();
        parser.insertarInstrucciones();
        
        areaDeCodigo = new JTextArea(20,20);
        scrollCodigo = new JScrollPane (areaDeCodigo);
        scrollCodigo.setBounds(10,10,250,250);
        add(scrollCodigo);
        
        JButton btnTriangulo = new JButton("Dibujar Triangulo");
        btnTriangulo.setBounds(10, 265, 250, 30);
        add(btnTriangulo);
        
        JButton btnPentagono = new JButton("Dibujar Pentagono");
        btnPentagono.setBounds(10, 300, 250, 30);
        add(btnPentagono);
        
        panelDeDibujo = new PanelDeDibujo();
        panelDeDibujo.setBackground(new Color(255,230,230));
        panelDeDibujo.setBounds(270,10,Propiedades.PANEL_DE_DIBUJO_ANCHO,Propiedades.PANEL_DE_DIBUJO_LARGO);
        
        add(panelDeDibujo);
        
        ejecutar = new JButton(new ImageIcon(System.getProperty("user.dir") + "/Play.png"));
        ejecutar.setBounds(10,570,50,40);
        ejecutar.setOpaque(false);
        ejecutar.setContentAreaFilled(false);
        ejecutar.setBorderPainted(false);
        ejecutar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                parser.limpiar();
                if(parser.compilar(areaDeCodigo.getText()))
                    panelDeDibujo.setConfiguracion(parser.ejecutar());
                else{
                    parser = new Parser();
                    parser.insertarInstrucciones();
                    panelDeDibujo.setConfiguracion(parser.getConfiguracion());
                }
                panelDeDibujo.repaint();
            }
        });
        add(ejecutar);
        
        
        setLayout(null);
        setBounds(50,50,1000,700);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }

}
