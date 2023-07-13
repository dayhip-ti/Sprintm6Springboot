package cl.awakelab.sprint06.controller;

import jakarta.persistence.GeneratedValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Bienvenido");
        return "home";
    }
    @GetMapping("/registro.html")
    public String registro(Model model){
        model.addAttribute("title", "Registro");
        return "registro";
    }
    @GetMapping("/login.html")
    public String login(Model model){
        model.addAttribute("title", "Iniciar Sesión");
        return "login";
    }
}
