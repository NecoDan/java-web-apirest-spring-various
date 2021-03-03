package br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.controller;

import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.model.Jedi;
import br.com.curso.web.apirest.spring.various.digital_innovation.app_webmvc.service.IJediService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class JediController {

    private final IJediService jediService;

    @GetMapping(path = "/jedi")
    public ModelAndView jedi() {
        final ModelAndView modelAndViewJedi = new ModelAndView("jedi");
        modelAndViewJedi.addObject("allJedi", jediService.findAll());
        return modelAndViewJedi;
    }

    @GetMapping(path = "/new-jedi")
    public ModelAndView newJedi() {
        final ModelAndView modelAndViewNewJedi = new ModelAndView("new-jedi");
        modelAndViewNewJedi.addObject("jedi", Jedi.builder().build());
        return modelAndViewNewJedi;
    }

    @PostMapping(path = "/jedi")
    public String save(@Valid @ModelAttribute Jedi jedi, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors())
            return "new-jedi";

        jediService.salvar(jedi);
        redirectAttributes.addFlashAttribute("message","Jedi salvo com sucesso");
        return "redirect:jedi";
    }
}
