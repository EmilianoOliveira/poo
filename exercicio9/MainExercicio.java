package br.ufpb.agenda;

import java.io.IOException;
import java.util.Iterator;

import javax.swing.*;

public class MainExercicio{

	public static void main(String [] args){
		AgendaIf agendas;
		String entrada = JOptionPane.showInputDialog("Que tipo de Agenda? 1- Map, 2- List");
		int compara = Integer.parseInt(entrada);
		
		if(compara == 1){
			agendas = new AgendaMap();
		}
		else{
			agendas = new Agenda();	
		}
		int menu = Integer.parseInt(JOptionPane.showInputDialog("Opção (1) Adicionar, (2) Remover, (3) Consultar, (4) Mostrar Todos, (5) Sair "));
		do{
			switch(menu){
				case 1:
						agendas.adicionarContato(JOptionPane.showInputDialog("Digite seu nome: "),JOptionPane.showInputDialog("Digite seu telefone:"));
						Iterator<Contato>contato = agendas.getContatosOrdenados();
						break;
				case 2:
						try{
							agendas.removerContato(JOptionPane.showInputDialog("Qual contato deseja remover? (Digite o nome do Contato)"));
						}catch(ContatoInexistenteException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
				case 3:
						try{
							Contato aux = agendas.pesquisarContato(JOptionPane.showInputDialog("Qual contato desesa procurar? (Digite o nome do Contato)"));
							JOptionPane.showMessageDialog(null, "Nome: " + aux.getNome() + "\nTelefone: " + aux.getTel());
						}catch(ContatoInexistenteException e){
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						break;
				case 4:
				Iterator<Contato>contatos = agendas.getContatosOrdenados();
				while(contatos.hasNext()){
					JOptionPane.showMessageDialog(null, contatos.next());
					
				}
						break;
						
			}
			menu = Integer.parseInt(JOptionPane.showInputDialog("Opção (1) Adicionar, (2) Remover, (3) Consultar, (4) Mostrar Todos, (5) Sair "));
		
		}while(menu<5);
	}
}