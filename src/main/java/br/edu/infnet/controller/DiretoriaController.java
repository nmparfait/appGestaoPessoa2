package br.edu.infnet.controller;


import br.edu.infnet.model.negocio.Diretoria;
import br.edu.infnet.model.negocio.Usuario;
import br.edu.infnet.model.service.DiretoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Optional;

@Controller
public class DiretoriaController {

    @Autowired
    private DiretoriaService diretoriaService;

    @GetMapping(value = "/diretoria")
    public String tela() {
        return "/diretoria/cadastro";
    }

    @GetMapping(value="/diretoria/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario){

        model.addAttribute("lista", diretoriaService.obterLista(usuario));

        return "/diretoria/lista";
    }

    @PostMapping(value = "/diretoria/incluir")
    public String incluir(Model model, Diretoria diretoria, @SessionAttribute("user") Usuario usuario) {

        diretoria.setUsuario(usuario);

        diretoriaService.incluir(diretoria);

        model.addAttribute("mensagem", diretoria.getNome() + " foi cadastrado com sucesso!");

        return telaLista(model, usuario);
    }

    @GetMapping(value = "/diretoria/{id}/excluir")
    public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario){

        Optional<Diretoria> diretoriaExcluido = diretoriaService.obterPorId(id);

        String msg = null;

        try {
            if(diretoriaExcluido.isPresent()){
                diretoriaService.excluir(id);
                Diretoria diretoria = diretoriaExcluido.get();
                msg = "O(A) diretoria " + diretoria.getNome() + " foi excluído(a) com sucesso!";
            }

        } catch(Exception e){
            msg = "O diretoria não pode ser excluído!!";
        }
        model.addAttribute("mensagem", msg);

        return telaLista(model, usuario);

    }


}
