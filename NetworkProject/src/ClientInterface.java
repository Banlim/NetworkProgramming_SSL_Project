import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientInterface extends JFrame {
	
	static final int LayoutWidth = 800;
	static final int LayoutHeight = 600;
	
	private Container contentPane;
	protected JPanel startPane = new JPanel();
	protected JPanel searchPane = new JPanel();
	
	private JTextField serverAddressField;
	private JTextField sslUploadField;
	
	private ButtonEventListener serverInputListener;
	private ButtonEventListener sslUploadListener;
	
	private JSplitPane jsp;
	
	
	public ClientInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(LayoutWidth, LayoutHeight);
		contentPane = getContentPane();
		createButton();
		
		jsp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, startPane, searchPane);
		jsp.setDividerLocation(LayoutWidth/5);
		this.add(jsp);
		
		setVisible(true);
		
	}
	void createButton() {
		
		JPanel panel = new JPanel();
		//GridLayout grd = new GridLayout(2,2);
		//grd.setVgap(20);
		//panel.setLayout(grd);
		
		JButton serverAddressBtn = new JButton();
		serverAddressBtn.setText("����");
		serverAddressBtn.setName("Access");
		serverAddressBtn.setPreferredSize(new Dimension(70,20));
		serverAddressBtn.setBorderPainted(false);
		
		serverAddressField = new JTextField(25);
		serverAddressField.setText("�����ּ� �Է�");
		serverAddressField.setSize(80,20);
		
		JButton sslUploadBtn = new JButton();
		sslUploadBtn.setText("���ε�");
		sslUploadBtn.setName("Upload");
		sslUploadBtn.setPreferredSize(new Dimension(70, 20));
		sslUploadBtn.setBorderPainted(false);
		
		sslUploadField = new JTextField(25);
		sslUploadField.setText("ssl ���� ���� ���ε�");
		sslUploadField.setSize(80, 20);
		
		serverInputListener = new ButtonEventListener(searchPane, serverAddressField);
		sslUploadListener = new ButtonEventListener(searchPane, sslUploadField);

		
		serverAddressBtn.addActionListener(serverInputListener);
		sslUploadBtn.addActionListener(sslUploadListener);
		
		panel.add(sslUploadField);
		panel.add(sslUploadBtn);
		panel.add(serverAddressField);
		panel.add(serverAddressBtn);
		
		startPane.add(panel, BorderLayout.CENTER);
		
		contentPane.add(startPane);
	}
	

	public static void main(String[] args) {
		new ClientInterface();
		

	}

}
