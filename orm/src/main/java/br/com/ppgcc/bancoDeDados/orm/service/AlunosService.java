package br.com.ppgcc.bancoDeDados.orm.service;

import br.com.ppgcc.bancoDeDados.orm.model.Aluno;
import br.com.ppgcc.bancoDeDados.orm.repository.AlunosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    Autor     : José Carlos de Freitas
    Criado em : 24/09/2018, 18:45:51
    Documento : AlunosService
 */
@Service
public class AlunosService {

    @Autowired
    private AlunosRepository alunosRepository;

    @Transactional(rollbackFor = Exception.class)
    public void salvar(Aluno aluno) {
        //Lógica de negócio antes de salvar o aluno
        alunosRepository.save(aluno);
        //Lógica de negócio depois de salvar o aluno
    }

    @Transactional(rollbackFor = Exception.class)
    public void editar(Aluno aluno) {
        //Lógica de negócio antes de editar o aluno
        alunosRepository.save(aluno);
        //Lógica de negócio depois de editar o aluno
    }

    public Iterable<Aluno> findAllByNome(String nome) {
        return alunosRepository.findAllByNomeOrderByNome(nome);
    }

    public Iterable<Aluno> findAll() {
        return alunosRepository.findAllByOrderByNome();
    }

    public Aluno find(Aluno aluno) {
        Optional<Aluno> alunoOptional = alunosRepository.findById(aluno.getId());

        if (alunoOptional.isPresent()) {
            return alunoOptional.get();
        }

        throw new RuntimeException("Aluno não encontrado");
    }

    public void remover(Aluno aluno) {
        alunosRepository.delete(aluno);
    }
}
