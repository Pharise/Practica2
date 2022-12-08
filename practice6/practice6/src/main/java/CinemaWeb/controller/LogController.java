package CinemaWeb.controller;

import CinemaWeb.dao.UserDAO;
import CinemaWeb.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LogController {
    public final UserDAO userDAO;

    @Autowired
    public LogController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String redirectToPage(HttpServletRequest httpServletRequest){
        if(httpServletRequest.isUserInRole("ADMIN")){
            return "redirect:/Administrator";
        }else{
            return "redirect:/user";
        }
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "Registration/Login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "Registration/Registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if(result.hasErrors()){
            return "Registration/Registration";
        }

        if(userDAO.userExist(user.getUsername())){
            String message = "Это имя занято, придумайте новое";
            model.addAttribute("message", message);
            return "Registration/Registration";
        }

        user.setRole("ROLE_USER");
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.add(user);
        return "redirect:/login";
    }
}