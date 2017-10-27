package presentacion;  

import aplicacion.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * @version ECI 2016
 */
public class GaleriaTICGUI extends JFrame{

    private static final int ANCHO_PREFERIDO = 450;
    private static final int ALTO_PREFERIDO= 450;
    private static final Dimension DIMENSION_PREFERIDA =
                         new Dimension(ANCHO_PREFERIDO,ALTO_PREFERIDO);

    private GaleriaTIC coleccion;

    /*Panel botonListar*/
    private JButton botonListar;
    private JButton botonReiniciarListar;
    private JTextArea textoInformacion;
    
    /*Panel botonAdicionar*/
    private JTextField textoNombreCorto;   
    private JTextField textoNombre;
    private JTextField textoEpoca;
    private JTextField textoProductos;
    private JTextArea  textoDescripcion;
    
    private JButton botonAdicionar;
    private JButton botonReiniciarAdicionar;
    
    /*Panel buscar*/
    private JTextField busquedaTexto;
    private JTextArea resultadosTexto;
    

    
    
    private GaleriaTICGUI(){
        coleccion=new GaleriaTIC();
        coleccion.adicione();
        prepareElementos();
        prepareAcciones();
    }


    private void prepareElementos(){
        setTitle("Personajes. TIC.");
        textoNombreCorto = new JTextField(50);
        textoNombre = new JTextField(50);
        textoEpoca = new JTextField(50);
        textoProductos = new JTextField(4);
        textoDescripcion = new JTextArea(10, 50);
        textoDescripcion.setLineWrap(true);
        textoDescripcion.setWrapStyleWord(true);
        JTabbedPane etiquetas = new JTabbedPane();
        etiquetas.add("Listar",   prepareListar());
        etiquetas.add("Adicionar",  prepareAdicionar());
        etiquetas.add("Buscar", prepareBuscar());
        getContentPane().add(etiquetas);
        setSize(DIMENSION_PREFERIDA);
        
    }


    /**
     * Prepara el panel para listar
     * @return
     */
    private JPanel prepareListar(){

        textoInformacion = new JTextArea(10, 50);
        textoInformacion.setEditable(false);
        textoInformacion.setLineWrap(true);
        textoInformacion.setWrapStyleWord(true);
        JScrollPane scrollArea =
                new JScrollPane(textoInformacion,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                                
        JPanel  botones = new JPanel();
        botonListar = new JButton("Listar");
        botonReiniciarListar = new JButton("Limpiar");
        botones.add(botonListar);
        botones.add(botonReiniciarListar);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollArea, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);

        return panel;
     }
     
    /**
     * Prepara el area de adición
     * @return El area de adición
     */
    private JPanel prepareAdicionar(){
        
        Box textoNombreCortoArea = Box.createHorizontalBox();
        textoNombreCortoArea.add(new JLabel("Nombre corto", JLabel.LEFT));
        textoNombreCortoArea.add(Box.createGlue());
        Box NombreCortoArea = Box.createVerticalBox();
        NombreCortoArea.add(textoNombreCortoArea);
        NombreCortoArea.add(textoNombreCorto);

        Box textoNombreArea = Box.createHorizontalBox();
        textoNombreArea.add(new JLabel("Nombre", JLabel.LEFT));
        textoNombreArea.add(Box.createGlue());
        Box NombreArea = Box.createVerticalBox();
        NombreArea.add(textoNombreArea);
        NombreArea.add(textoNombre);
        
        Box textoEpocaArea = Box.createHorizontalBox();
        textoEpocaArea.add(new JLabel("Epoca", JLabel.LEFT));
        textoEpocaArea.add(Box.createGlue());
        Box EpocaArea = Box.createVerticalBox();
        EpocaArea.add(textoEpocaArea);
        EpocaArea.add(textoEpoca);

        Box textoProductosArea = Box.createHorizontalBox();
        textoProductosArea.add(new JLabel("Productos", JLabel.LEFT));
        textoProductosArea.add(Box.createGlue());
        Box ProductosArea = Box.createVerticalBox();
        ProductosArea.add(textoProductosArea);
        ProductosArea.add(textoProductos);
        
        Box textoDescripcionArea = Box.createHorizontalBox();
        textoDescripcionArea.add(new JLabel("Descripción", JLabel.LEFT));
        textoDescripcionArea.add(Box.createGlue());
        Box descripcionArea = Box.createVerticalBox();
        descripcionArea.add(textoDescripcionArea);
        descripcionArea.add(textoDescripcion);
 
        Box singleLineFields = Box.createVerticalBox();
        singleLineFields.add(NombreCortoArea);
        singleLineFields.add(NombreArea);
        singleLineFields.add(EpocaArea);
        singleLineFields.add(ProductosArea);        

        JPanel textoInformacionPanel = new JPanel();
        textoInformacionPanel.setLayout(new BorderLayout());
        textoInformacionPanel.add(singleLineFields, BorderLayout.NORTH);
        textoInformacionPanel.add(descripcionArea, BorderLayout.CENTER);

        JPanel botones = new JPanel();
        botonAdicionar = new JButton("Adicionar");
        botonReiniciarAdicionar = new JButton("Limpiar");

        botones.add(botonAdicionar);
        botones.add(botonReiniciarAdicionar);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(textoInformacionPanel, BorderLayout.CENTER);
        panel.add(botones, BorderLayout.SOUTH);
        return panel;
    }

    



   /**
     * Prepara el area de liatar
     * @return El panel para buscar coleccions
     */
    private JPanel prepareBuscar(){

        Box busquedaEtiquetaArea = Box.createHorizontalBox();
        busquedaEtiquetaArea.add(new JLabel("Buscar", JLabel.LEFT));
        busquedaEtiquetaArea.add(Box.createGlue());
        busquedaTexto = new JTextField(50);
        Box busquedaArea = Box.createHorizontalBox();
        busquedaArea.add(busquedaEtiquetaArea);
        busquedaArea.add(busquedaTexto);
        
        resultadosTexto = new JTextArea(10,50);
        resultadosTexto.setEditable(false);
        resultadosTexto.setLineWrap(true);
        resultadosTexto.setWrapStyleWord(true);
        JScrollPane scrollArea = new JScrollPane(resultadosTexto,
                                     JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                     JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel botonListarArea = new JPanel();
        botonListarArea.setLayout(new BorderLayout());
        botonListarArea.add(busquedaArea, BorderLayout.NORTH);
        botonListarArea.add(scrollArea, BorderLayout.CENTER);

        return botonListarArea;
    }


    public void prepareAcciones(){
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev){
                setVisible(false);
                System.exit(0);
            }
        });
        
        /*Listar*/
        botonListar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                accionListar();
            }
        });

        botonReiniciarListar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                textoInformacion.setText("");
            }
        });
        
        /*Adicionar*/
        botonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                accionAdicionar();                    
            }
        });
        
        botonReiniciarAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev){
                textoNombreCorto.setText("");
                textoNombre.setText("");
                textoEpoca.setText("");
                textoProductos.setText("");
                textoDescripcion.setText("");
            }
        });
        
        /*Buscarr*/
        busquedaTexto.getDocument().addDocumentListener(new DocumentListener(){
            public void changedUpdate(DocumentEvent ev){
                accionBuscar();

            }
           
            public void insertUpdate(DocumentEvent ev){
                accionBuscar();
            }
            
            public void removeUpdate(DocumentEvent ev){
                accionBuscar();
            }
            

        });
    }    

    
    private void accionListar(){
        textoInformacion.setText(coleccion.toString());
    }
    
    private void  accionAdicionar(){
        try{
            coleccion.adicione(textoNombreCorto.getText(),textoNombre.getText(),textoEpoca.getText(), textoProductos.getText(),
        textoDescripcion.getText());
        }catch (GaleriaTICExcepcion e){}
        
    }

    private void accionBuscar(){
        String patronBusqueda=busquedaTexto.getText();
        StringBuffer buffer = new StringBuffer();
        if(patronBusqueda.length() > 0) {
            ArrayList <Personaje> results = coleccion.busque(patronBusqueda);
            for(int i = 0; i < results.size(); i++) {
                buffer.append(results.get(i).toString());
                buffer.append('\n');
                buffer.append('\n');
             }
        }
        resultadosTexto.setText(buffer.toString());
    } 
    
   public static void main(String args[]){
       GaleriaTICGUI gui=new GaleriaTICGUI();
       gui.setVisible(true);
   }    
}
