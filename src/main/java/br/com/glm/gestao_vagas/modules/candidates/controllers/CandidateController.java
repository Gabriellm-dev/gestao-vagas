package br.com.glm.gestao_vagas.modules.candidates.controllers;

import br.com.glm.gestao_vagas.exceptions.UserFoundException;
import br.com.glm.gestao_vagas.modules.candidates.CandidateEntity;
import br.com.glm.gestao_vagas.modules.candidates.CandidateRepository;
import br.com.glm.gestao_vagas.modules.candidates.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){

        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
