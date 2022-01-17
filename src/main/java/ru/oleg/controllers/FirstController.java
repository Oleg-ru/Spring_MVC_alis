package ru.oleg.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/first")
public class FirstController {


    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

//        System.out.println("Hello my dear " + name + " " + surname);
        model.addAttribute("message", "Hello my dear " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("operation") String operation,
                             Model model) {
        int result = 0;
        switch (operation) {
            case "multi": {
                result = a * b;
                break;
            }
            case "add": {
                result = a + b;
                break;
            }
            case "sub": {
                result = a - b;
                break;
            }
            case "div": {
                result = a / b;
                break;
            }
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
