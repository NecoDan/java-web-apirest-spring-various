package br.com.curso.web.apirest.spring.various.codenation.biblioteca.repository;

import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Categoria;
import br.com.curso.web.apirest.spring.various.codenation.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    List<Livro> findByTitulo(String titulo);

    List<Livro> findByTituloContaining(String titulo);

    List<Livro> findByCategorias(Categoria categoria);

    @Query("from Livro livro where livro.categorias is not empty")
    List<Livro> findComCategoria();

    //        @Query(value = "select * from LIVRO as livro " +
//            "INNER JOIN LIVRO_CATEGORIA as cl ON livro.id = cl.id_livro " +
//            "INNER JOIN categoria as c ON c.id = cl.id_categoria " +
//            "where c.nome like ""%:nomeCategoria%"", nativeQuery = true)
//    List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);
}
