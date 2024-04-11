package br.com.fiap.main.service;

import br.com.fiap.main.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository repository;

    @Autowired
    private AlunoService(AlunoRepository repository){
        this.repository = repository;
    }


}
