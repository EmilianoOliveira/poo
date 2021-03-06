package br.ufpb.sistemadepedidos;

import java.util.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GravadorDePedidos{

	public GravadorDePedidos(){
	}
	public List<Pedido> lePedido() throws IOException{
		ObjectInputStream in = null;
		try{
			in = new ObjectInputStream(new FileInputStream("pedidos.txt"));
			return (ArrayList<Pedido>)in.readObject();
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo inexistente.", e);
		}catch(ClassNotFoundException e){
			throw new IOException("Classe inexistente.", e);
		}catch(IOException e){
			throw e;
		}finally{
			if(in != null){
				in.close();
			}
		}
	}
	public void gravaPedido(List <Pedido> pedidos)throws IOException{
		ObjectOutputStream out = null;
		try{
			out = new ObjectOutputStream(new FileOutputStream("pedidos.txt"));
			out.writeObject(pedidos);
		}catch(FileNotFoundException e){
			throw new IOException("Arquivo Inexistente", e);
		}catch(IOException e){
			throw e;
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
}