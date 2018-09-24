package br.com.ppgcc.bancoDeDados.orm.repository;

import br.com.ppgcc.bancoDeDados.orm.model.Aluno;
import org.springframework.data.repository.CrudRepository;

/*
    Autor     : José Carlos de Freitas
    Criado em : 24/09/2018, 18:46:24
    Documento : AlunosRepository
 */
public interface AlunosRepository extends CrudRepository<Aluno, Long> {

    public Iterable<Aluno> findAllByOrderByNome();

    public Iterable<Aluno> findAllByNomeOrderByNome(String nome);

}
