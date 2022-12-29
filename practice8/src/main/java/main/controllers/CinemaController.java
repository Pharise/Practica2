package main.controllers;

import javax.validation.Valid;

import main.Cinema;
import main.CinemaDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CinemaController {

    private final CinemaDao cinemaDao;

    private double filterCost = 0;

    @Autowired
    public CinemaController(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @GetMapping("/add_cinema")
    public String newPerson(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "add_cinema";
    }

    @PostMapping("/add_cinema")
    public String createCinema(@ModelAttribute("cinema") @Valid Cinema cinema, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/add_cinema";
        }
        for (Cinema cinema_i : cinemaDao.findAll()) {
            if (cinema_i.getId() == cinema.getId())
                return "redirect:/add_cinema";
        }
        this.cinemaDao.insert(cinema);
        return "redirect:/";
    }

    @GetMapping("/show_all")
    public String findAll(Model model) {
        model.addAttribute("cinemas", cinemaDao.findAll());
        return "show_all";
    }

    @GetMapping("/edit_cinema")
    public String edit(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "edit_cinema";
    }

    @PatchMapping("/edit_cinema")
    public String update(@ModelAttribute("cinema") @Valid Cinema cinema, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit_cinema";
        }
        cinemaDao.update(cinema);
        return "redirect:/";
    }

    @GetMapping("/delete_cinema")
    public String delete_get(Model model) {
        int id = 0;
        model.addAttribute("id", id);
        return "delete_cinema";
    }

    @DeleteMapping("/delete_cinema")
    public String delete(@RequestParam("id") int id) {
        cinemaDao.delete(id);
        return "redirect:/";
    }

    @GetMapping("/filter_show")
    public String filter_form(Model model) {
        double cost = filterCost;
        model.addAttribute("cost", cost);
        model.addAttribute("cinemas", cinemaDao.findAllCostIncreaseThan(filterCost));
        filterCost = 0;
        return "filter_show";
    }

    @PostMapping("/filter_show")
    public String filter_post(@RequestParam("cost") double cost, Model model) {
        filterCost = cost;
        return "redirect:/filter_show";
    }
}