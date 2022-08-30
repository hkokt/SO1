package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class RedesController{

public void mostraos() {
	JOptionPane.showMessageDialog(null, sistema());
}
	
public void escolheip() {
	String sis = sistema();
	if (sis.contains("Windows")) {
		chamaproc("ipconfig");
	}else {
		chamaproc("ifconfig");
	}
}

public void escolheping() {
	String sis = sistema();
	if (sis.contains("Windows")) {
		chamaproc("PING -4 -n 10 www.google.com.br");
	}else {
		chamaproc("PING -4 -c 10 www.google.com.br");
	}
}

public void chamaproc (String proc) {
try {		
			Process roda = Runtime.getRuntime().exec(proc); 
			InputStream fluxo = roda.getInputStream();
			InputStreamReader ler = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(ler);
			String linha = buffer.readLine();
			
			while (linha != null) {

				if (linha.contains("Adaptad")) {
					
					JOptionPane.showMessageDialog(null, linha);
				
				}else if(linha.contains("IPv4.")) {
					
					JOptionPane.showMessageDialog(null, linha);
				
				}else if (linha.contains("dia = ")) {
				
					JOptionPane.showMessageDialog(null, linha);
				
				}	
					
					linha = buffer.readLine();
				
			}


}catch(Exception e) {
	System.out.println(e);
}
}

private String sistema() {
	String result = System.getProperty("os.name");	
	return result;
}
}