package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota!";
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }

    //Mostrar ninja por id (READ)
    @GetMapping("/todosID")
    public String mostrarNinjaPorID(){
        return "Mostrar Ninja Por ID";
    }

    //Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Alterar Ninja Por ID";
    }

    //Deletar Ninja (DELETE)
    @DeleteMapping("/DeletarID")
    public String deletarNinjaPorId(){
        return "Deletar Ninja Por ID";
    }
}
