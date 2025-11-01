package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET -- Mandar uma requisição para mostrar as missões
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missões Listadas com sucesso";
    }

    // POST - Mandar uma requisição para criar as missões
    @PostMapping("/criar")
    public String criarMissao() {
        return "Missão Criada com sucesso";
    }


    // PUT - Mandar uma requisição para alterar as missões
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missão alterada com sucesso";
    }

    // DELETE - Mandar uma requisição para deletar as missões
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missão deletada com sucesso";
    }
}
