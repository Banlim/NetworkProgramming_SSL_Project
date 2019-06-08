import java.awt.Dimension;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import RMI.HandleWordText;
import RMI.HandleWordTextImpl;

class HandleWordTextWindow extends JFrame {

	private String path;
	private int serverPort;
	private String serverName;
	private String username;
	private String wordFilePath;
	
	private SSL_Client client;
	
	private HandleWordText handleWordText;
	
	private ButtonEventListener wordFileUploadListener;
	private ButtonEventListener searchListener;
	public HandleWordTextWindow(String wordfilePath) {
		this.wordFilePath = wordfilePath;
	}
    
    public HandleWordTextWindow(int serverPort, String serverName, String path, String username) {
		this.serverPort = serverPort;
		this.serverName = serverName;
		this.path = path;
		this.username = username;
		
		client = new SSL_Client(serverPort, serverName, path, username);
		client.SSLconnection_Client();
		String strAccessLog = client.getAccessMessage();
		System.out.println(strAccessLog);
		System.out.println(client.isConnect());
//		if(client.isConnect()) {
//			client.run();
//		}
		if(client.isConnect())
			SearchWindow();
    }
    
    public void SearchWindow() {
    	
    	setTitle("새로 띄운 창");
        // 주의, 여기서 setDefaultCloseOperation() 정의를 하지 말아야 한다
        // 정의하게 되면 새 창을 닫으면 모든 창과 프로그램이 동시에 꺼진다
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        JLabel NewLabel = new JLabel("새 창을 띄우는데 성공!");
        JLabel NewLabe2 = new JLabel(path);
        
        JTextField wordFileField = new JTextField(30);
        wordFileField.setName("wordUploadField");
        wordFileField.setText("upload word file");
        
        JButton wordFileUpload = new JButton();
        wordFileUpload.setName("wordUpload");
        wordFileUpload.setText("upload");
        
        JTextArea wordTextArea = new JTextArea();
        wordTextArea.setName("textWord");
        wordTextArea.setText("hello");
        //wordTextArea.setSize(new Dimension(400, 300));

        JScrollPane sp = new JScrollPane(wordTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //sp.setBounds(20, 20, 400, 300);
        sp.setPreferredSize(new Dimension(400, 250));
        JTextField searchField = new JTextField(20);
        searchField.setName("searchField");
        
        JButton searchButton = new JButton();
        searchButton.setName("search");
        searchButton.setText("search");
      
        
        try {
			handleWordText = new HandleWordTextImpl();
			JLabel NewLabe3 = new JLabel("upload : ");
			//NewWindowContainer.add(NewLabel);
	        //NewWindowContainer.add(NewLabe2);
	        NewWindowContainer.add(NewLabe3);
	        NewWindowContainer.add(wordFileField);
	        NewWindowContainer.add(wordFileUpload);
	        
	        NewWindowContainer.add(searchField);
	        NewWindowContainer.add(searchButton);
	        
	        NewWindowContainer.add(sp);
	        
	        wordFileUploadListener = new ButtonEventListener(wordFileField, wordTextArea);
	        wordFileUpload.addActionListener(wordFileUploadListener);
	        
	       searchListener = new ButtonEventListener(searchField, wordTextArea);
	       searchButton.addActionListener(searchListener);
	        //System.out.println("호잇 : " + wordFilePath);
	        //wordTextArea.setText(handleWordText.dataParse(wordFilePath));
	        
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setSize(500,400);
        setResizable(false);
        setVisible(true);
    }
    
    
}