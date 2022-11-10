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
@RequestMapping("/Administrator")
public class AdminController {
    private final CinemaDAO cinemaDAO;

    @Autowired
    public AdminController(CinemaDAO cinemaDAO) {
        this.cinemaDAO = cinemaDAO;
    }

    @GetMapping()
    public String mainMenu() {
        return "Administrator/MainMenu";
    }

    @GetMapping("/get")
    public String CinemaDb(Model model) {
        model.addAttribute("cinemas", cinemaDAO.allCinema());
        return "CinemaDb";
    }

    @GetMapping("/new")
    public String addCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "Administrator/AddCinema";
    }

    @GetMapping("/edit")
    public String updateCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "Administrator/UpdateCinema";
    }

    @GetMapping("/delete")
    public String deleteCinema(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "Administrator/DeleteCinemaFromDb";
    }

    @GetMapping("/find")
    public String findById(Model model) {
        model.addAttribute("cinema", new Cinema());
        return "Administrator/FindId";
    }

    @PostMapping()
    public String add(@Valid @ModelAttribute("cinema") Cinema cinema, BindingResult result) {
        if (result.hasErrors()) {
            return "Administrator/AddCinema";
        }
        cinemaDAO.add(cinema);
        return "redirect:/Administrator";
    }

    @DeleteMapping("/delete")
    public String delete(@ModelAttribute("cinema") Cinema cinema, Model model) {
        System.out.println("ID");
        System.out.println(cinema.getPrice());
        if (cinemaDAO.findById(cinema.getPrice()) == null) {
            String message = "";
            model.addAttribute("message",message);
            return "Administrator/DeleteCinemaFromDb";
        }
        cinemaDAO.delete(cinema.getPrice());
        return "redirect:/Administrator";
    }

    @PutMapping("/update")
    public String edit(@Valid Cinema cinema, BindingResult result, Model model) {
        if (cinemaDAO.findById(cinema.getId()) == null) {
            String message = "Операция не выполнена";
            model.addAttribute("message", message);
            return "Administrator/UpdateCinema";
        }
        if (result.hasErrors()) {
            return "Administrator/UpdateCinema";
        }
        cinemaDAO.update(cinema);
        return "redirect:/Administrator";
    }

    @GetMapping("/find/cinema")
    public String find(@ModelAttribute("cinema") Cinema cinema, Model model) {
        if (cinemaDAO.findById(cinema.getPrice()) == null) {
            String message = "Операция не выполнена";
            model.addAttribute("message", message);
            return "Administrator/FindId";
        }
        Cinema foundF = cinemaDAO.findById(cinema.getPrice());
        model.addAttribute("cinema", foundF);
        return "Administrator/Cinema";
    }
}