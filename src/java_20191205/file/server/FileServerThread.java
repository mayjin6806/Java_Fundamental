package java_20191205.file.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class FileServerThread implements Runnable {
	private Socket socket;
	public FileServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		OutputStream out = null;
		FileInputStream fis = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader( 
					new InputStreamReader(socket.getInputStream()));
			String fileName = br.readLine();
			
			System.out.println("fileName : "+fileName);
			fis = new FileInputStream("C:\\dev\\io\\2019\\12\\"+fileName);
			
			byte[] readBytes = new byte[1024*8];
			int readByteCount = 0;
			out = socket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(out);
			while((readByteCount = fis.read(readBytes)) != -1){
				out.write(readBytes,0,readByteCount);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
				if(out != null) out.close();
				if(fis != null) fis.close();
				if(socket != null) socket.close();
				
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}

	}

}









