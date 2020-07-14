package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form method='get' action='message'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option language=''>Choose a language</option>" +
                "<option language='1'>Hawaiian</option>" +
                "<option language='2'>Korean</option>" +
                "<option language='3'>Spanish</option>" +
                "<option language='4'>French</option>" +
                "<option language='5'>Portuguese</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</select>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @GetMapping("message")
    public static String createMessage(@RequestParam String name, String language){
        if(language.equals("Hawaiian")){
            return "Aloha, " + name + "!";
        } else if (language.equals("Korean")){
            return "여보세요, " + name + "!";
        } else if (language.equals("Spanish")){
            return "Hola, " + name + "!";
        } else if(language.equals("French")){
            return "Bonjour, " + name + "!";
        } else if(language.equals("Portuguese")) {
            return "Olá, " + name + "!";
        } else {
            return "Hello, " + name + "!";
        }
    }
}
