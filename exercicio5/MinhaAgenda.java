
public class MinhaAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		agenda.adicionaContato("Emiliano","88888888");
		try{
			agenda.pesquisaContato("Emiliano");
			agenda.pesquisaContato("Maria");
		}
		catch(ContatoInexistenteException e){
			System.err.println(e.getMessage());
		}
	}

}
