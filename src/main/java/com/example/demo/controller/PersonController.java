package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private List<Person> personList = new ArrayList<Person>();

    @Autowired
    PersonService personService;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @Value("${person.list.header}")
    private String headerMessage;

    @GetMapping(value = {"/", "/home"})
    public String index(Model model) {
        model.addAttribute("message",welcomeMessage);
        return "home";
    }

    @GetMapping(value = "/testRetrieveAllPerson")
    public @ResponseBody List<Person> getAllPersons() {
        personList = personService.getPersons();
        return personList;
    }

    @GetMapping(value = "/list")
    public String personList(Model model) {
        personList = personService.getPersons();
        model.addAttribute("persons", personList);
        model.addAttribute("listofPersons", headerMessage);
        return "personList";
    }

    @GetMapping(value = "/add")
    public String addPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addPerson";
    }
    
    @PostMapping(value = "/add")
    public String savePerson(@ModelAttribute(value = "person") Person p) {
        personService.addPerson(p);
        return "redirect:/persons/list";
    }

    @PostMapping(value = "/update")
    public String updatePerson(@ModelAttribute(value = "per") Person p, Model model) {
        model.addAttribute("per", p);
        return "personEdit";
    }

    @PostMapping(value = "/updatePerson")
    public String updatePersonRecord(@ModelAttribute(value = "person") Person p) {
        personService.updatePerson(p);
        return "redirect:/persons/list";
    }

    @PostMapping(value = "/deletePerson")
    public String deletePerson(@ModelAttribute(value = "person") Person p) {
        personService.removePerson(p);
        return "redirect:/persons/list";
    }

}
