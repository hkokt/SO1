package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main{
	public static void main (String []  args ){

		RedesController cont = new RedesController();

		int opc = 0 ;
		while(opc !=9) {
			opc= Integer.parseInt(JOptionPane.showInputDialog("1- Informa SO \n 2- Informa adaptadores ipv4 \n 3- Informa média de ping (10s)"));
		switch (opc) {
		case 1: 
			cont.mostraos(); break;
		case 2:
			cont.escolheip(); break;
		case 3:
			cont.escolheping(); break;
		case 9:
			System.exit(0);break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inexistente");break;
			}
		}
		
	}
}