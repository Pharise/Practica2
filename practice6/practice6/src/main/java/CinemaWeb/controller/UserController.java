package CinemaWeb.controller;

import CinemaWeb.dao.CinemaDAO;
import CinemaWeb.entities.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final CinemaDAO cinemaDAO;

    @Autowired
    public UserController(CinemaDAO cinemaDAO) {
        this.cinemaDAO = cinemaDAO;
    }

    @GetMapping()
    public String userPage(){
        return "User/MainUser";
    }

    @GetMapping("/cinemas")
    public String FurnDatabase(Model model){
        model.addAttribute("cinemas", cinemaDAO.allCinema());
        return "CinemaDb";
    }

    @GetMapping("/find")
    public String findById(Model model){
        model.addAttribute("cinema", new Cinema());
        return "User/FindId";
    }

    @GetMapping("/find/fur")
    public String find(@ModelAttribute("cinema") Cinema cinema, Model model) {
        if (cinemaDAO.findById(cinema.getPrice()) == null) {
            String message = "В базе нет данной записи";
            model.addAttribute("message", message);
            return "User/FindId";
        }
        Cinema foundF = cinemaDAO.findById(cinema.getPrice());
        model.addAttribute("cinema", foundF);
        return "User/Cinema";
    }

}