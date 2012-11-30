
package br.ufpb.agenda;

import java.util.Collection;
import java.util.Iterator;

public interface AgendaIf  {
    
    public void adicionarContato(String nome, String tel);
    
    public void removerContato(String nomeContato) throws ContatoInexistenteException;
    
    public Contato pesquisarContato(String nomeContato) throws ContatoInexistenteException;
    
    public Iterator<Contato> getContatosOrdenados();
    
    public Collection<Contato> getContatos();
}
