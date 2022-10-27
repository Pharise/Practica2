package CinemaWeb.controller;

import CinemaWeb.dao.CinemaDAO;
import CinemaWeb.entities.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CinemaController {
    private final CinemaDAO cinemaDAO;

    @Autowired
    public CinemaController(CinemaDAO cinemaDAO) {
        this.cinemaDAO = cinemaDAO;
    }

    @GetMapping("/")
    public String mainMenu() {
        return "MainMenu";
    }

    @GetMapping("/cinema")
    public String CinemaDb(Model model) {
        model.addAttribute("cinema", cinemaDAO.allCinema());
        return "CinemaDb";
    }

    @GetMapping("/cinemas/new")
    public String addCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "AddCinema";
    }

    @GetMapping("/cinemas/edit")
    public String updateCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "UpdateCinema";
    }

    @GetMapping("/cinemas/delete")
    public String deleteCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "DeleteCinemaFromDb";
    }

    @GetMapping("/cinemas/find")
    public String findById(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "FindId";
    }

    @PostMapping("/cinemas")
    public String add(@Valid @ModelAttribute("cinema") Cinema cinema, BindingResult result) {
        if (result.hasErrors()) {
            return "AddCinema";
        }
        cinemaDAO.add(cinema);
        return "redirect:/";
    }

    @DeleteMapping("/cinemas/delete")
    public String delete(@ModelAttribute("cinema") Cinema cinema, Model model) {
        System.out.println("ID");
        System.out.println(cinema.getPrice());
        if (CinemaDAO.findById(furniture.getPrice()) == null) {
            String message = "";
            model.addAttribute("message",message);
            return "DeleteCinemaFromDb";
        }
        furnitureDAO.delete(furniture.getPrice());
        return "redirect:/";
    }

    @PutMapping("/cinemas/update")
    public String edit(@Valid FCinema cinema, BindingResult result, Model model) {
        if (cinemaDAO.findById(cinema.getId()) == null) {
            String message = "This id does not exist in the database";
            model.addAttribute("message", message);
            return "UpdateCinema";
        }
        if (result.hasErrors()) {
            return "UpdateFurniture";
        }
        cinemaDAO.update(cinema);
        return "redirect:/";
    }

    @GetMapping("/cinemas/find/cinema")
    public String find(@ModelAttribute("cinema") Cinema cinema, Model model) {
        if (cinemaDAO.findById(cinema.getPrice()) == null) {
            String message = "This id does not exist in the database";
            model.addAttribute("message", message);
            return "FindId";
        }
        Cinema foundF = cinemaDAO.findById(cinema.getPrice());
        model.addAttribute("cinema", foundF);
        return "Cinema";
    }
}
