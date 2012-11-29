package poo;

public class ContatoInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;
	public ContatoInexistenteException(){
        this("Contato inexistente");
    }
    public ContatoInexistenteException(String message){
        super(message);
    }
    
}
