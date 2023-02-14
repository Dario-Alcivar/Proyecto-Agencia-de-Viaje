package interfaz;

import dominio.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


public class VentanaGestion extends JFrame implements ActionListener{
     
     //private JPanel panelInicio = null;
     private HandlerClientes panelClientes = null;
     private HandlerTrabajadores panelTrabajadores = null;
     private HandlerAlojamientos panelAlojamientos = null;
     private HandlerDestinos panelDestinos = null;
     private HandlerPaquetesTuristicos panelPaquetesTuristicos = null;
     private JMenu menuArchivo = null;
     private JMenu menuOpciones = null;
     private JMenu menuAyuda = null;
     private JMenuBar barra = null;
     private JMenu subMenuGestion = null;
     private JMenu subMenuViajes = null;
     private Sistema sistema = null;
     
     
    public VentanaGestion(Sistema sistemaP){
          
        super();
        this.setTitle("Gestion");
        this.setSize(1024,750);
        //this.setContentPane(getPanelInicio());
        this.setResizable(false);
        //El menú esta comentado porque aun no esta disponible
        //this.setJMenuBar(getMenuBarra());
        this.sistema = sistemaP;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //uso Adapter para no implementar todos los métodos del Listener
        this.addWindowListener(new java.awt.event.WindowAdapter(){
             public void windowClosing(WindowEvent evento){
                  int respuesta = JOptionPane.showConfirmDialog(null, " �Desea salir?", "Confirmaci�n", JOptionPane.WARNING_MESSAGE);
                  if (respuesta == JOptionPane.YES_OPTION){
                       System.exit(0);
                    }
                }
            }
        );
     }   

    @Override
    public void actionPerformed(ActionEvent e) {    }           
}
     
    

