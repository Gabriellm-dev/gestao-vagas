package br.com.glm.gestao_vagas.modules.candidates.useCases;

import br.com.glm.gestao_vagas.exceptions.UserFoundException;
import br.com.glm.gestao_vagas.modules.candidates.CandidateEntity;
import br.com.glm.gestao_vagas.modules.candidates.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;


    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}
