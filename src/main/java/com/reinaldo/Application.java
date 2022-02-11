package com.reinaldo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reinaldo.domain.Categoria;
import com.reinaldo.domain.Cidade;
import com.reinaldo.domain.Estado;
import com.reinaldo.domain.Produto;
import com.reinaldo.repositories.CategoriaRepository;
import com.reinaldo.repositories.CidadeRepository;
import com.reinaldo.repositories.EstadoRepository;
import com.reinaldo.repositories.ProdutoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Consoles");
		Produto prod1 = new Produto(null, "PS5", 5000.00);
		Produto prod2 = new Produto(null, "XBOX ONE", 4000.00);
		Produto prod3 = new Produto(null, "PS4", 4200.00);
		
		cat1.getProdutos().addAll(Arrays.asList(prod1,prod2,prod3));
		prod1.getCategorias().add(cat1);
		prod2.getCategorias().add(cat1);
		prod3.getCategorias().add(cat1);
		
		categoriaRepository.save(cat1);
		produtoRepository.saveAll(Arrays.asList(prod1,prod2,prod3));
		
		
		Estado e1 = new Estado(null, "Goiás");
		Cidade c1 = new Cidade(null, "Goiânia", e1);
		
		e1.getCidades().add(c1);
		
		cidadeRepository.save(c1);
		estadoRepository.save(e1);
		
		
		
	}

}
