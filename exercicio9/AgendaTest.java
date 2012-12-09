package br.ufpb.agenda;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgendaTest {

	Agenda agenda;

	@Before
	public void setUp() throws Exception {
		agenda = new Agenda();
	}

	@After
	public void tearDown() throws Exception {
		File primeiro = new File("contatos.txt");
		File segundo = new File("contatosMap.txt");
		if (primeiro.exists()) {
			primeiro.delete();
		}
		if (segundo.exists()){
			segundo.delete();
		}
	}

	@Test
	public void testaAdicionaContato() {
		try {
			agenda.pesquisarContato("Fulano");
			fail("Não lançou a exceção que deveria.");
		} catch (ContatoInexistenteException e) {
			// OK
		}
		agenda.adicionarContato("José", "5555");
		try {
			Contato c = agenda.pesquisarContato("José");
			assertTrue(c.getTel().equals("5555")&& c.getNome().equals("José"));
		} catch (ContatoInexistenteException e) {
			fail("Não era pra lançar a exceção");
		}

	}

	@Test
	public void testaAdicaoDuplicadaDoContato() {
		agenda.adicionarContato("Beltrano", "0000");
		agenda.adicionarContato("Beltrano", "1111");
		try {
			Contato c = agenda.pesquisarContato("Beltrano");
			assertEquals("Beltrano", c.getNome());
			assertEquals("1111", c.getTel());
			assertTrue(c.getNome().equals("Beltrano")
					&& c.getTel().equals("1111"));

		} catch (ContatoInexistenteException e) {
			fail("Não era pra lançar a exceção.");
		}
	}

	@Test
	public void testaPesquisa() {
		agenda.adicionarContato("José", "0000");
		agenda.adicionarContato("Kátia", "1111");
		try {
			Contato c1 = agenda.pesquisarContato("José");
			Contato c2 = agenda.pesquisarContato("Kátia");
			assertEquals("0000", c1.getTel());
			assertEquals("1111", c2.getTel());
		} catch (ContatoInexistenteException e) {
			fail("Não deveria lançar a exceção");
		}
		try {
			Contato c3 = agenda.pesquisarContato("Maria");
			fail("Deveria ter lançado a exceção pois Maria não existe");
		} catch (ContatoInexistenteException e) {
			// ok
		}

	}

	@Test
	public void testaContatosOrdenados() {
		Iterator<Contato> contatosIt = agenda.getContatosOrdenados();
		assertTrue(contatosIt.hasNext() == false);
		assertFalse(contatosIt.hasNext());
		agenda.adicionarContato("Emiliano", "9999");
		agenda.adicionarContato("Bruna", "8888");
		contatosIt = agenda.getContatosOrdenados();
		assertTrue(contatosIt.hasNext());
		Contato c1 = contatosIt.next();
		assertEquals("Bruna", c1.getNome());
		assertEquals("8888", c1.getTel());

		assertTrue(contatosIt.hasNext());
		Contato c2 = contatosIt.next();
		assertEquals("Emiliano", c2.getNome());
		assertEquals("9999", c2.getTel());

	}

}
