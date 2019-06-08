//import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
//import javax.swing.filechooser.FileNameExtensionFilter;

public class openFilePath {
	
	private JFileChooser fileChooser;
	private String returnOpenPath;
	private String bufferText;
	//private FileOutputStream fs;
	
	public openFilePath() {
		fileOpen();
	}
	public openFilePath(String bufferText) {
		this.bufferText = bufferText;
		fileOpen();
	}
	public void fileOpen() {
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		int ret = fileChooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.");
			return;
		}
		returnOpenPath = fileChooser.getSelectedFile().getPath();
	}
	public String PathReturn() {
		return returnOpenPath;
	}
}
