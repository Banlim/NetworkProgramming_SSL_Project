package RMI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HandleWordTextImpl extends UnicastRemoteObject implements HandleWordText {
	private static final long serialVersionUID = 1L;
	
	
	public HandleWordTextImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String dataParse(String FilePath) throws RemoteException {
		String path = FilePath;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			StringBuffer sb = new StringBuffer();
			String temp;
			while((temp = br.readLine()) != null) {
				sb.append(temp);
				sb.append("\n"); // �ܼ��� �ѹ��徿 �о "\n"�� ������� �ʴ´�.
			}
			br.close();
			String data = sb.toString();
			return data;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "hello";	
	}
	
	public void loadExcel() throws RemoteException{
		
	}
}
