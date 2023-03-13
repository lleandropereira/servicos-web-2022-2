package br.edu.ifsc.livro;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
	
	@RequestMapping(value = "adicionar_livro", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro adicionar(@RequestBody Livro livro) {
		LivroDataSource.add(livro);
		return livro;
	}

	@RequestMapping(value = "/listar_livros", method = RequestMethod.GET)
	public List<Livro> getLivros() {
		return LivroDataSource.getListaLivros();
	}
	
	@RequestMapping(value = "/novo/{id}/{isbn}/{titulo}/{autor}/{editora}/{preco}", method = RequestMethod.GET)
	public Livro novoLivro(
			@PathVariable("id") int id,
			@PathVariable("isbn") int isbn,
			@PathVariable("titulo") String titulo,
			@PathVariable("autor") String autor,
			@PathVariable("editora") String editora,
			@PathVariable("preco") double preco) {
		Livro livro = new Livro(id, isbn, titulo, autor, editora, preco);
		
		LivroDataSource.add(livro);
		
		return livro;
	}
	
	@RequestMapping(value = "/livro_por_isbn/{isbn}", method = RequestMethod.GET)
	public Livro getPorIsbn(
			@PathVariable(name = "isbn") int isbn) {
		return LivroDataSource.getPorIsbn(isbn);
	}
	
	@RequestMapping(value = "/livro_por_autor/{autor}", method = RequestMethod.GET)
	public List<Livro> getPorAutor(
			@PathVariable(name = "autor") String autor) {
		return LivroDataSource.getPorAutor(autor);
	}
	
	@RequestMapping(value = "/livro_por_titulo/{titulo}", method = RequestMethod.GET)
	public Livro getPorTitulo(
			@PathVariable(name = "titulo") String titulo) {
		return LivroDataSource.getPorTitulo(titulo);
	}
	
	@RequestMapping(value = "/livrodto_isbn/{isbn}", method = RequestMethod.GET)
	public LivroDTO getPorIsbnDTO(
			@PathVariable(name = "isbn") int isbn) {
		return LivroDataSource.getPorIsbnDTO(isbn);
	}
	
	@RequestMapping(value = "/livros_dto", method = RequestMethod.GET)
	public List<LivroDTO> getAllDTO() {
		return LivroDataSource.getAllDTO();
	}
	
	@RequestMapping(value = "/reajustar_preco/{id}/{taxa}", method = RequestMethod.GET)
	public void reajustarPreco(
			@PathVariable(name = "id") int id,
			@PathVariable(name = "taxa") double taxa) {
		LivroDataSource.reajustarPrecoPorId(id, taxa);
	}
	
	@RequestMapping(value = "/reajustar_preco/{taxa}", method = RequestMethod.GET)
	public void reajustarPreco(
			@PathVariable(name = "taxa") double taxa) {
		LivroDataSource.reajustarPreco(taxa);
	}
	
}
