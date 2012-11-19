import java.util.ArrayList;
import java.util.List;


public class Agenda implements AgendaIf {
	
	private List <Contato> contatos;
	
	public Agenda(){
		this.contatos = new ArrayList <Contato>();
	}
	public void adicionaContato(String nome, String telefone){
		this.contatos.add(new Contato(nome,telefone));
	}
	public void removeContato(String nome) throws ContatoInexistenteException{
		boolean achou = false;
		for(Contato c : this.contatos){
			if(c.getNome().equals(nome)){
				this.contatos.remove(c);
				achou = true;
			}
		}
		if(achou == false){
			throw new ContatoInexistenteException("Contato não cadastrado" + " " + nome);
		}
	}
	public Contato pesquisaContato(String nome) throws ContatoInexistenteException{
		for(Contato c : this.contatos){
			if(c.getNome().equals(nome)){
				return c;
			}
		}
		throw new ContatoInexistenteException("Contato não cadastrado" + " " + nome);
	}
	
}
