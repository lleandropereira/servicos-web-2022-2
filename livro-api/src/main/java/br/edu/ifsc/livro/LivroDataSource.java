package br.edu.ifsc.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDataSource {
	
	private static List<Livro> listaLivros = new ArrayList<>();
	
	public static void criarLista() {
		listaLivros.add(new Livro(01, 101, "Titulo 1", "Autor 1", "Editora 1", 11.99));
		listaLivros.add(new Livro(02, 102, "Titulo 2", "Autor 2", "Editora 2", 15.90));
		listaLivros.add(new Livro(03, 103, "Titulo 3", "Autor 3", " Editora 3", 24.90));
		listaLivros.add(new Livro(04, 104, "Titulo 4", "Autor 4", "Editora 4", 45.35));
		listaLivros.add(new Livro(05, 105, "Titulo 5", "Autor 5", "Editora 5", 47.92));
	}
	
	public static List<Livro> getListaLivros() {
		return listaLivros;
	}
	
	public static void setListaLivros(List<Livro> listaLivros) {
		LivroDataSource.listaLivros = listaLivros;
	}
	
	public static void add(Livro livro) {
		listaLivros.add(livro);
	}
	
	public static Livro getPorIsbn(int isbn) {
		for(Livro livro: listaLivros) {
			if(livro.getIsbn() == isbn) {
				return livro;
			}
		}
		return null;
	}
	
	public static List<Livro> getPorAutor(String autor) {
		List<Livro> resultado = new ArrayList<>();
		
		for(Livro livro: listaLivros) {
			if(livro.getAutor().equalsIgnoreCase(autor)) {
				resultado.add(livro);
			}
		}
		return resultado;
	}
	
	public static Livro getPorTitulo(String titulo) {
		if(listaLivros != null) {
			for(Livro livro: listaLivros) {
				if(livro.getTitulo().equalsIgnoreCase(titulo)) {
					return livro;
					}
				}
			}
			return null;
	}
	
	public static LivroDTO getPorIsbnDTO(int isbn) {
		LivroDTO livroDTO = null;
		if(listaLivros != null) {
			for(Livro livro: listaLivros) {
				if(livro.getIsbn() == isbn) {
					livroDTO = new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
					return livroDTO;
				}
			}
		}
		return livroDTO;
	}
	
	public static List<LivroDTO> getAllDTO() {
		List<LivroDTO> listaLivrosDTO = new ArrayList<>();
		if(listaLivros != null) {
			for(Livro livro: listaLivros) {
				LivroDTO livroDTO = new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
				listaLivrosDTO.add(livroDTO);
			}
		}
		return listaLivrosDTO;
	}
	
	public static void reajustarPrecoPorId(int id, double taxa) {
		if(listaLivros != null) {
			for(Livro livro: listaLivros) {
				if(livro.getId() == id) {
					livro.reajustarPreco(taxa);
				}
			}
		}
	}
	
	public static void reajustarPreco(double taxa) {
		if(listaLivros != null) {
			for(Livro livro: listaLivros) {
				livro.reajustarPreco(taxa);
			}
		}
	}
}
