package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class Vista extends JPanel {
	
	private JPanel panel1;
	private JButton buscar;
	private JPanel panel2;
	
	
	//atributos para el panel botones de radio
	private JPanel panelRadio;
	private JRadioButton rbProteinas;
	private JRadioButton rbSecuencias;
	private ButtonGroup botonElige;
	private JLabel tipoBusqEtiqueta;
	
	//atributos para el panel del combo box
	private JPanel panelCombo;
	private JComboBox<String> comboSecuencias;
	private JLabel comboEtiqueta;
	private JComboBox<String> cbFile;
	private JComboBox<String> cbIndex;
	
	//atributos para el porcentaje
	private JPanel panelPorcentaje;
	private JTextArea textoP;
	private JLabel porcentajeEtiqueta;
	
	
	//atributos para el panel de los resultados
	private JPanel panelResultados;
	private JLabel resulEtiqueta;
	private JTextArea tResult;
	private JScrollPane scrollResultados;
		
	
	
	
	
	public Vista(){
		//PANEL DE BOTONES DE RADIO
		panelRadio = new JPanel(); 
		panelRadio.setLayout(new FlowLayout()); 
		tipoBusqEtiqueta = new JLabel("Selecciona el tipo de busqueda: ");
		rbProteinas = new JRadioButton("Proteinas");
		rbSecuencias = new JRadioButton("Secuencias de proteinas");
		botonElige = new ButtonGroup();
		botonElige.add(rbProteinas);
		botonElige.add(rbSecuencias);
		
		rbProteinas.setSelected(true);
		panelRadio.add(tipoBusqEtiqueta, "WEST");
		panelRadio.add(rbProteinas, "CENTER");
		panelRadio.add(rbSecuencias, "EAST");
		panelRadio.setBackground(Color.WHITE);
		
		//PANEL DEL COMBO BOX
		panelCombo = new JPanel();
		panelCombo.setLayout(new BorderLayout());
		
		comboSecuencias= new JComboBox<String>();
		comboSecuencias.setEditable(true);
		comboEtiqueta = new JLabel("Escriba su secuencia: ");
		
		
		panelCombo.add(comboEtiqueta,BorderLayout.NORTH);
		panelCombo.add(comboSecuencias, BorderLayout.SOUTH);
		
		//PANEL DEL PORCENTAJE
		panelPorcentaje= new JPanel();
		panelPorcentaje.setLayout(new BorderLayout());
		textoP = new JTextArea(" ", 1 , 3);
		textoP.setEditable(true);
		porcentajeEtiqueta = new JLabel("Introduzca el porcentaje: ");
		
		panelPorcentaje.add(porcentajeEtiqueta, BorderLayout.NORTH);
		panelPorcentaje.add(textoP, BorderLayout.SOUTH);
		
		//PANEL DE RESULTADOS
		panelResultados = new JPanel();
		panelResultados.setLayout(new BorderLayout());
		tResult = new JTextArea(200,100);
		tResult.setEditable(false);
	
		scrollResultados= new JScrollPane(tResult);
		scrollResultados.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollResultados.setPreferredSize(new Dimension(500,600));
		resulEtiqueta = new JLabel();
		panelResultados.add(resulEtiqueta, BorderLayout.NORTH);
		panelResultados.add(resulEtiqueta, BorderLayout.CENTER);
		panelResultados.add(scrollResultados, BorderLayout.EAST);
		panelResultados.setSize(500,600);
		
		buscar= new JButton("Buscar");
		
		panel1= new JPanel();
		panel1.setLayout(new BorderLayout());
		panel2= new JPanel();
		panel2.setLayout(new FlowLayout());
		panel2.add(panelCombo,"WEST");
		panel2.add(panelPorcentaje,"EAST");
		panel1.add(panel2, BorderLayout.CENTER);
		panel1.add(panelRadio, BorderLayout.NORTH);
		panel1.add(buscar, BorderLayout.SOUTH);
		
		add(panel1,"North");
		add(panelResultados,"Center");
		setBackground(Color.ORANGE);
		
		
		
		
		
		}
		public JRadioButton getProteinas(){
			return rbProteinas;
		}
		public JRadioButton  getSecuencias(){
			return rbSecuencias;
		}
		public JComboBox<String> getCBsec(){
			return comboSecuencias;
			
		}
		public JComboBox<String> getCBdbfile(){
			return cbFile;
		}
		public JComboBox<String> getCBdbIndex(){
			return cbIndex;
		}
		public JButton getBuscar(){
			return buscar;
		}
		public JTextArea getPorcen(){
			return textoP;
		}
		public JTextArea getResultados(){
			return tResult;
		}
		public void controlador(ActionListener action){
			buscar.addActionListener(action);
		}
	
	
	

}
