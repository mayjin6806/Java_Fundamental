package java_20191205.file.client;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class FileClient {
	private String ip;
	private int port;
	
	public FileClient(String ip, int port){
		this.ip = ip;
		this.port = port;
	}
	
	public void run(){
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream in = null;
		FileOutputStream fos = null;
		try {
			socket = new Socket(ip,port);
			String fileName = "mariadb.pdf";
			bw = new BufferedWriter(
							new OutputStreamWriter(
									socket.getOutputStream()));
			bw.write(fileName);
			bw.newLine();
			bw.flush();
			
			
			in = socket.getInputStream();
			fos = new FileOutputStream("C:\\dev\\io\\"+fileName);
			
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			
			while((readByteCount = in.read(readBytes)) != -1){
				fos.write(readBytes,0,readByteCount);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (in != null) in.close();
				if (fos != null) fos.close();
				if (socket != null) socket.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		new FileClient("192.168.0.203",3033).run();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
