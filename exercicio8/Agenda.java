package br.ufpb.agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class Agenda implements AgendaIf {

    private List<Contato> contatos;
    private GravadorList gravadorList = new GravadorList();
    
    
    
    public Agenda(){
		gravadorList = new GravadorList();
		carregaContatos();
	}

	private void gravaContatos(){
		try{
			gravadorList.gravaContatos(contatos);
		}
		catch(IOException e){
			System.err.println(e.getMessage());
		}
		
		
	}
	private void carregaContatos(){
		try{
			contatos = gravadorList.leContatos();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			this.contatos = new ArrayList<Contato>();
		}
	}
    
    public void adicionarContato(String nome, String tel) {
        
        this.contatos.add(new Contato(nome,tel));
        gravaContatos();
		return;
    }

    public void removerContato(String nomeContato) throws ContatoInexistenteException {
        for(Contato aux: contatos){
            if(aux.getNome().equals(nomeContato)){
                contatos.remove(aux);
                gravaContatos();
				return;
            }
        }
        throw new ContatoInexistenteException("Contato não Cadastrado : " + nomeContato);
    }

   
    public Contato pesquisarContato(String nomeContato) throws ContatoInexistenteException {
        
        for(Contato aux: contatos){
            if(aux.getNome().equals(nomeContato)){
                return aux;
            }
        }
        throw new ContatoInexistenteException("Contato não Cadastrado : " + nomeContato);
    }
    
	public Collection<Contato> getContatos() {
		Collection<Contato> contato = new ArrayList<>();
		contato.addAll(this.contatos);
		return contato;
	}

	public Iterator<Contato> getContatosOrdenados() {
		Collections.sort(this.contatos);
		return this.contatos.iterator();
	}
    
}
