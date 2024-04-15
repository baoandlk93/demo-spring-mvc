package org.example.demospringmvc.controller;

import org.example.demospringmvc.entity.User;
import org.example.demospringmvc.service.AuthService;
import org.example.demospringmvc.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
@Service
@Repository
@Component
@Controller
@RestController
@Configuration
- Đánh dấu 1 class là Bean !
@Bean -> Đánh dấu phương thức đó là 1 bean !

@Controller -> 1 class thuộc 1 Controller
@RestController -> 1 class thuộc 1 Controller + 1 phương thức trả về JSON

@RequestParam
@PathVariable
 */
@Controller
@RequestMapping
public class HelloController {
    private final IAuthService authService = new AuthService();


    @GetMapping("/hello{name}")
    public String index(HttpServletRequest request, @PathVariable String name, Model model) {
        request.getCookies();
        model.addAttribute("name", name);
        return "/Home";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("/LoginForm");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(User user) {
        authService.login(user.getUsername(), user.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/LoginForm");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView("/RegisterForm");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView register(User user) {
        User user1 = authService.register(user.getUsername(), user.getPassword());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/Home");
        modelAndView.addObject("user", user1);
        return modelAndView;
    }
}
