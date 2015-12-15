package curves;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import function.Functions;
import function.SyntaxErrorException;


public class DocumentWidget {
	private JTextField functionField;
	private JPanel widget;
	private JButton loader;
	private JButton saver;
	private File loadingFile;
	private File savingFile;
	private JFileChooser fileChooser = new JFileChooser();
	private FileWriter writer;
	
	public DocumentWidget(){
		widget = new JPanel(new GridLayout(2,2));

		functionField = new JTextField(3);
		widget.add(functionField);
		
		
		//Loader
		loader = new JButton("Importer à partir d'un fichier");
		loader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				fileChooser.showOpenDialog(loader);
				System.out.println(fileChooser.getSelectedFile()); //trace
				loadingFile = fileChooser.getSelectedFile();
				/*				try {
					;
				}
				catch (Exception e){}*/
			}
		});
		
		widget.add(loader);

		
		//Saver
		saver = new JButton("Sauvegarder");
		saver.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e){
				fileChooser.showSaveDialog(saver);
				savingFile = fileChooser.getSelectedFile();
				try {
					Functions.parse(functionField.getText());
					savingFile.createNewFile();
					writer = new FileWriter(savingFile);
					try {
						writer.write(functionField.getText() + "\n");
					}
					  finally{
						writer.close();
					}
				}
					catch (SyntaxErrorException | IOException ex){
						System.out.println("You shall not parse !");
						System.out.println(ex.getMessage());
						ex.printStackTrace();
					}
			}
		});
		

		widget.add(saver);

	}

	public JPanel getWidget() {
		return widget;
	}	
}
