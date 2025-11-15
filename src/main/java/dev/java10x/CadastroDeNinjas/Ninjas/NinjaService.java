package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Lista os ninjas por ID
    public NinjaDTO listaNinjasPorID(Long ID){
        Optional<NinjaModel> ninja =  ninjaRepository.findById(ID);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        //return ninjaRepository.save(ninja);
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar o ninja - Tem que ser um método void
    public void deletarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaDeletado = ninjaRepository.findById(id);
        if (ninjaDeletado.isPresent()) {
            ninjaRepository.deleteById(id);
        }
    }

    //Atualizar Ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente =  ninjaRepository.findById(id);

        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        } return null;
    }

}
