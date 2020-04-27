package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class AuthorController {

  @Resource
  private AuthorRepository authorRepository;

  @RequestMapping("/authors")
  public String authors(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors/list";
  }

}
