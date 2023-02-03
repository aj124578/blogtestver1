package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.model.UserRepository;
import shop.mtcoding.blog.util.script;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/joinForm")
    public String joinForm() {
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/updateForm")
    public String updateForm() {
        return "user/updateForm";
    }

    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String username, String password){
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user == null){
            return "redirect:/loginForm";
        }
        session.setAttribute("prinsipal", user);
        return "redirect:/";
        
    }

    @PostMapping("/join")
    public String join(String username, String password, String passwordCheck, String email){
        int result = userRepository.insert(username, password, passwordCheck, email);

        if (result != 1) {
            return "redirect:/joinForm";
        }
        return "redirect:/loginForm";
    }

}
