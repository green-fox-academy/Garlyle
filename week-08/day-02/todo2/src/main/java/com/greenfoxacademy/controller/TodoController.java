package com.greenfoxacademy.controller;

import com.greenfoxacademy.model.Todo;
import com.greenfoxacademy.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {
  @Autowired
  TodoRepository repository;

  @RequestMapping(value="/list")
  public String list(Model model) {
    model.addAttribute("todos", repository.findAll());
    return "todo";
  }

  @RequestMapping(value="/", method = RequestMethod.GET)
  public String listToDo(@RequestParam(required = false) String isActive, Model model) {
    if (isActive != null) {
      model.addAttribute("todos", repository.findByIsDoneEquals(Boolean.parseBoolean(isActive)));
    } else {
      model.addAttribute("todos", repository.findAll());
    }
    return "todo";
  }

  @RequestMapping("/add")
  public String add(Model model) {
    return "add";
  }

  @RequestMapping("/addNew")
  public String addNew(String title) {
    repository.save(new Todo(title));

    return "redirect:/todo/";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable long id) {
    repository.delete(id);
    return("redirect:/todo/");
  }

  @GetMapping("/{id}/edit")
  public String editItem(@PathVariable long id, Model model) {
    model.addAttribute("todo", repository.findOne(id));

    return("edit");
  }

  @PostMapping("/save")
  public String save(@ModelAttribute Todo item) {
    repository.save(item);
    return("redirect:/todo/");
  }
}
