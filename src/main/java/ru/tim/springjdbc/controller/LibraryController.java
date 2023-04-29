package ru.tim.springjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tim.springjdbc.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class LibraryController {
    private final PersonDAO personDAO;

    public LibraryController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/all")
    public String getPersons(Model model) {
        model.addAttribute("people", personDAO.getPersonsList());
        return "persons_view";
    }

    @GetMapping("/{id}")
    public String getPersons(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personDAO.getPerson(id));
        return "person_view";
    }
}
