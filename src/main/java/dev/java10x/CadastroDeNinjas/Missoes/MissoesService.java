package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    //Cria missão com entrada de missão do controller
    public MissoesModel criaMissoes(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    //Lista todas as missões ao bater no endpoint
    public List<MissoesModel> listarMissoes(){
        return missoesRepository.findAll();
    }

    //Lista missão pelo id passado na controller
    public MissoesModel listaMissoesPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    //Deleta missão pelo id passado na controller
    public void deletarMissaoPorId(Long id){
        missoesRepository.deleteById(id);
    }

    //Atualiza missão

}
