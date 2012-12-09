package br.ufpb.agenda;

import java.util.*;
import java.io.*;


public class AgendaMap implements AgendaIf{

	
	private Map<String, Contato> contatos;
	private GravadorMap gravadorMap;

	public AgendaMap(){
		gravadorMap = new GravadorMap();
		carregaContatos();
	}

	private void gravaContatos(){
		try{
			gravadorMap.gravaContatos(contatos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
		
	}
	private void carregaContatos(){
		try{
			contatos = gravadorMap.leContato();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			this.contatos = new HashMap<String, Contato>();
		}
	}

	public void adicionarContato(String nome, String telefone){
		this.contatos.put(nome, new Contato(nome,telefone) );
		System.out.println("Contato adicionado com êxito"  + nome  );
		gravaContatos();
	}

	public void removerContato(String nome)throws ContatoInexistenteException{
		if( !(this.contatos.containsKey(nome)) ){
			throw new ContatoInexistenteException("Contato nao encontrado." + nome );
		}
		this.contatos.remove(nome);
		System.out.println("Contato nao encontrado." + nome );
		gravaContatos();
	}

	public Contato pesquisarContato(String nome)throws ContatoInexistenteException{
		if( (this.contatos.containsKey(nome))== false ){
			throw new ContatoInexistenteException("Contato nao encontrado." + nome );
		}
		return this.contatos.get(nome);
	}

	
	public Collection<Contato> getContatos() {
		List<Contato> c = new ArrayList<Contato>();
		c.addAll(this.contatos.values());
		return c;
	}

	public Iterator<Contato> getContatosOrdenados() {
		List<Contato> c = new ArrayList<Contato>();
		c.addAll(this.contatos.values());
		Collections.sort(c);
		return c.iterator();
	}
}