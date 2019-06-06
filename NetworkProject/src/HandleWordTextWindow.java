import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import RMI.HandleWordText;
import RMI.HandleWordTextImpl;

class HandleWordTextWindow extends JFrame {

	private String path;
	private int serverPort;
	private String serverName;
	private String username;
	
	private SSL_Client client;
	
	private HandleWordText handleWordText;
    
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
    	
    	setTitle("���� ��� â");
        // ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
        // �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        JLabel NewLabel = new JLabel("�� â�� ���µ� ����!");
        JLabel NewLabe2 = new JLabel(path);
        
        try {
			handleWordText = new HandleWordTextImpl();
			JLabel NewLabe3 = new JLabel("test : " + handleWordText.dataParse());
			NewWindowContainer.add(NewLabel);
	        NewWindowContainer.add(NewLabe2);
	        NewWindowContainer.add(NewLabe3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        setSize(500,400);
        setResizable(false);
        setVisible(true);
    }
    
    
}