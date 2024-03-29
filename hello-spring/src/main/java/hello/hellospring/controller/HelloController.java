package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("date","hello!!");
        return "hello";     //hello.html return
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("nam  e", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //http응답 body에 return 값을 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name;
    }

    @GetMapping("hello-api")
    @ResponseBody   //객체를 넘길 시 JSON형태로 표시됨
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
