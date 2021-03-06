package com.gymManege.GymManage.controller;

import com.gymManege.GymManage.models.AlunoCadModels;
import com.gymManege.GymManage.repository.AlunoCadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoCadController {

    @Autowired
    private AlunoCadRepository ar;

    @GetMapping("/aluno_list")
    public ModelAndView list_alunos(Model model){
        ModelAndView mv = new ModelAndView("home/Aplication/listarAluno");
        Iterable<AlunoCadModels> alunoList= ar.findAll();
        mv.addObject("alunoList", alunoList);
        return mv;
    }

    @GetMapping("/aluno_cadastro")
    public ModelAndView cadastro_alunos(Model model){
        ModelAndView mv = new ModelAndView("home/Aplication/alunoCadastro");
        Iterable<AlunoCadModels> alunoList= ar.findAll();
        mv.addObject("alunoList", alunoList);
        return mv;
    }


    @RequestMapping(value = "/aluno_cadastro", method = RequestMethod.POST)
    public String form(AlunoCadModels alunoList){
        ar.save(alunoList);
        System.out.println(alunoList.getId());
        return  "redirect:/aluno_list";
    }

    @RequestMapping("/deletar")
    public String deletar (long id){
        ar.deleteById(id);
        return "redirect:/aluno_list";
    }



}


