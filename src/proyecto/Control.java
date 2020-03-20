package proyecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import blast.BlastController;

public class Control implements ActionListener {
	private Vista vista;
	public Control(Vista v){
		vista = v;
	}
	public void actionPerformed(ActionEvent evento){
		if(evento.getSource().equals(vista.getBuscar())){
			if(busqRadio()=='s'){
				vista.getResultados().setText("No se puede realizar esta busqueda");
				
			} 
			else if(vista.getCBsec().getSelectedItem()==null){
				vista.getResultados().setText("Incorrecto");
			}
			
			else if ((vista.getPorcen().getText().equals(""))){
				vista.getResultados().setText("No hay porcentaje");
			}
			else if ((Float.parseFloat(vista.getPorcen().getText())>1.0) || (Float.parseFloat(vista.getPorcen().getText())<0.1)){
				vista.getResultados().setText("El porcentaje es incorrecto");
			}
			else{
				String s = vista.getCBsec().getSelectedItem().toString().toUpperCase();
				if(!busSeq(s)){
					vista.getCBsec().addItem(s);
					
				}
				
			}
			
				
		}
	}
	
	public char busqRadio(){
		char tipoBusqueda;
		if(vista.getProteinas().isSelected()){
			tipoBusqueda='p';
			
		}else{
			tipoBusqueda='s';
		}
		return tipoBusqueda;
	}
	
	public boolean busSeq(String sec){
		int secAparece=0;
		for(int i=0; i< vista.getCBsec().getItemCount(); i++){
			String secuenciaActual= vista.getCBsec().getItemAt(i).toString();
			if(secuenciaActual.equals(sec)){
				return true;
				
			}
			
		}
		return false;	
	}
	public String BlasGUI(float p, String seq, char busq){
		String dataBaseFile=vista.getCBdbfile().getSelectedItem().toString();
		String dataBaseIndexes=vista.getCBdbIndex().getSelectedItem().toString();
		BlastController bCnt = new BlastController();
		String result = null;
		try{
			result= bCnt.blastQuery(busq, dataBaseFile,dataBaseIndexes ,p, seq);
			System.out.println(result);
		} catch(Exception exc){
			System.out.println("Error en la llamada: " + exc.toString());
		}
		return result;
	}
	
	
	
}
