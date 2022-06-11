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
        
        JButton btnStar = new JButton("Estrella - Ciclos");
        btnStar.setBounds(10, 265, 250, 30);
        btnStar.setBackground(new Color(240,213,252));
        btnStar.setBorderPainted(false);
        btnStar.addActionListener(l -> {
            areaDeCodigo.setText(Constants.ESTRELLA_COLORES());
        });
        add(btnStar);
        
        
        JButton btnSquare = new JButton("Cuadrado - Procedimiento");
        btnSquare.setBounds(10, 300, 250, 30);
        btnSquare.setBackground(new Color(240,213,252));
        btnSquare.setBorderPainted(false);
        btnSquare.addActionListener(l -> {
            areaDeCodigo.setText(Constants.CUADRADO_FUNCION());
        });
        add(btnSquare);
        
        JButton btnFlower = new JButton("Flor - Proc anidados");
        btnFlower.setBounds(10, 335, 250, 30);
        btnFlower.setBackground(new Color(240,213,252));
        btnFlower.setBorderPainted(false);
        btnFlower.addActionListener(l -> {
            areaDeCodigo.setText(Constants.FLOR_ANIDADA());
        });
        add(btnFlower);
        
        JButton btnRule = new JButton("Regla - Funcion");
        btnRule.setBounds(10, 370, 250, 30);
        btnRule.setBackground(new Color(240,213,252));
        btnRule.setBorderPainted(false);
        btnRule.addActionListener(l -> {
            areaDeCodigo.setText(Constants.REGLA_FUNC());
        });
        add(btnRule);
        
        JButton btnHilbert = new JButton("Hilbert");
        btnHilbert.setBounds(10, 405, 250, 30);
        btnHilbert.setBackground(new Color(240,213,252));
        btnHilbert.setBorderPainted(false);
        btnHilbert.addActionListener(l -> {
            areaDeCodigo.setText(Constants.HILBERT());
        });
        
        add(btnHilbert);
        
        JButton btnSpyroProc = new JButton("Espirografo - Proc");
        btnSpyroProc.setBounds(10, 440, 250, 30);
        btnSpyroProc.setBackground(new Color(240,213,252));
        btnSpyroProc.setBorderPainted(false);
        btnSpyroProc.addActionListener(l -> {
            areaDeCodigo.setText(Constants.SPYRO_PROC());
        });
        
        add(btnSpyroProc);
        
        JButton btnSpyroCiclo = new JButton("Espirografo - Ciclo");
        btnSpyroCiclo.setBounds(10, 475, 250, 30);
        btnSpyroCiclo.setBackground(new Color(240,213,252));
        btnSpyroCiclo.setBorderPainted(false);
        btnSpyroCiclo.addActionListener(l -> {
            areaDeCodigo.setText(Constants.SPYRO_CICLO());
        });
        
        add(btnSpyroCiclo);
        
        panelDeDibujo = new PanelDeDibujo();
        panelDeDibujo.setBackground(new Color(255,230,230));
        panelDeDibujo.setBounds(270,10,Propiedades.PANEL_DE_DIBUJO_ANCHO,Propiedades.PANEL_DE_DIBUJO_LARGO);
        
        add(panelDeDibujo);
        
        ejecutar = new JButton(new ImageIcon(System.getProperty("user.dir") + "/Play.png"));
        ejecutar.setBounds(10,600,50,40);
        ejecutar.setOpaque(false);
        ejecutar.setContentAreaFilled(false);
        ejecutar.setBorderPainted(false);
        ejecutar.addActionListener((ActionEvent ae) -> {
            parser.limpiar();
            if(parser.compilar(areaDeCodigo.getText()))
                panelDeDibujo.setConfiguracion(parser.ejecutar());
            else{
                parser = new Parser();
                parser.insertarInstrucciones();
                panelDeDibujo.setConfiguracion(parser.getConfiguracion());
            }
            panelDeDibujo.repaint();
        });
        add(ejecutar);
        
        JButton btnClean = new JButton(new ImageIcon(System.getProperty("user.dir") + "/TrashCan.png"));
        btnClean.setBounds(60,600,50,40);
        btnClean.setOpaque(false);
        btnClean.setContentAreaFilled(false);
        btnClean.setBorderPainted(false);
        btnClean.addActionListener(l -> {
            areaDeCodigo.setText("");
        });
        add(btnClean);
        
        setLayout(null);
        setBounds(50,50,1000,720);
        setVisible(true);
        setResizable(false);
        super.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    }

}
