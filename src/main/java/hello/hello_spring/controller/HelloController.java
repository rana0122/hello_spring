package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return  "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 에서 바디부에 이데이터를 직접 넣어주겠다는 뜻. view가 없음
    public  String helloString(@RequestParam("name") String name){
        return "hello~ "+name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody //http에서 바디부에 데이터를 직접 넣어주므로 view 가 없음.  이방식  json으로 출력한다. {"name":"kim!!soo!!!"}
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello=new Hello();
        hello.setName(name);
        return hello; // 반환타입이 객체이면 json 방식으로 출력하는게 기본 정책
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