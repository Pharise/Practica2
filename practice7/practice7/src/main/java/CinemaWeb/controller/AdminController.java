package CinemaWeb.controller;

import CinemaWeb.dao.CinemaDAO;
import CinemaWeb.entities.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Administrator")
public class AdminController {
    private final CinemaDAO cinemaDAO;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public AdminController(CinemaDAO cinemaDAO, RabbitTemplate rabbitTemplate) {
        this.cinemaDAO = cinemaDAO;
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping()
    public String mainMenu() {
        return "Administrator/MainMenu";
    }

    @GetMapping("/get" )
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
        rabbitTemplate.convertAndSend("Queue", cinema.toString());
        cinemaDAO.add(cinema);
        return "redirect:/Administrator";
    }

    @DeleteMapping("/delete")
    public String delete(@ModelAttribute("cinema") Cinema cinema, Model model) {
        System.out.println("ID");
//        System.out.println(cinema.getPrice());
        if (cinemaDAO.findById(cinema.getPrice()) == null) {
            String message = "";
            model.addAttribute("message", message);
            return "Administrator/DeleteCinemaFromDb";
        }
        rabbitTemplate.convertAndSend("Queue", "Delete " + "ID: " + cinema.getPrice());
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
        rabbitTemplate.convertAndSend("Queue", "Update" + cinema);
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
        rabbitTemplate.convertAndSend("Queue", "" + foundF);
        return "Administrator/Cinema";
    }


    @GetMapping(value = "/cinemas", headers = {"Accept=application/json"})
    public ResponseEntity<List<Cinema>> allFurs() {
        return new ResponseEntity<>(cinemaDAO.allCinema(), HttpStatus.OK);
    }

    @PostMapping(value = "/cinemas/new", headers = {"Accept=application/json"})
    public ResponseEntity<Cinema> add(@RequestBody Cinema cinema) {
        cinemaDAO.add(cinema);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }

    @GetMapping(value = "/cinemas/find/{id}", headers = {"Accept=application/json"})
    public ResponseEntity<Cinema> find(@PathVariable("id") int id) {
        Cinema cinema = cinemaDAO.findById(id);

        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @PutMapping(value = "/cinemas/edit/{id}", headers = {"Accept=application/json"})
    public ResponseEntity<Cinema> edit(@PathVariable int id, @RequestBody Cinema cinema) {
        if (cinemaDAO.findById(id) == null) {
            return new ResponseEntity<>(cinema, HttpStatus.NOT_FOUND);
        }

        cinemaDAO.update(cinema);
        return new ResponseEntity<>(cinemaDAO.findById(cinema.getId()), HttpStatus.OK);
    }

    @DeleteMapping(value = "/cinemas/delete/{id}", headers = {"Accept=application/json"})
    public ResponseEntity<Cinema> delete(@PathVariable("id") int id) {
        Cinema deletedCinema = cinemaDAO.findById(id);

        if (deletedCinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cinemaDAO.delete(id);
        return new ResponseEntity<>(deletedCinema, HttpStatus.OK);
    }

}