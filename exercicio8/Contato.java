
package br.ufpb.agenda;

import java.io.Serializable;


public class Contato implements Serializable,Comparable<Contato> {
    
	private static final long serialVersionUID = 1L;
	private String nome;
	private String tel;

	public Contato(){
		this(" "," ");
	} 	
	public Contato(String nome, String tel) {
        this.nome = nome;
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
	public int compareTo(Contato o) {
		if(this.nome.compareTo(o.getNome()) == 0){
			return 0;
		}else if(this.nome.compareTo(o.getNome()) < 0){
			return -1;
		}else{
			return 1;
		}
	}
	public String toString(){
		return "Nome: " + this.nome + "\nTelefone: " + this.tel;
}
}