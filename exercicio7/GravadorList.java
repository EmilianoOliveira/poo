package poo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class GravadorList {
	public List<Contato>leContatos() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream (new FileInputStream("contatos.txt"));
			return (List<Contato>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontrado", e);
		}catch(IOException e){
			throw e;
		}catch(ClassNotFoundException e){
			throw new IOException("Esta classe não foi encontrada", e);
		}finally{
			if (in!=null){
				in.close();
			}
		}
	}
	public void gravaContatos(List<Contato>contatos) throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("contatos.txt"));
			out.writeObject(contatos);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo não encontrado", e);
		}catch(IOException e){
			throw e;
		}finally{
			if (out!=null){
				out.close();
			}
		}	
	}
}
