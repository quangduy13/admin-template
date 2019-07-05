package quangduy.com.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import quangduy.com.admin.entity.UserBean;
import quangduy.com.admin.provider.GoogleProvider;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String viewLogin() {

        return "login";
    }

    @RequestMapping(value = "authorization")
    public String processAuth() {

        boolean flag = false;
        String url = "";
        return flag ? "redirect:" + url : "layout/home";
    }

    @Autowired
    GoogleProvider googleProvider;


    @RequestMapping(value = "/google", method = RequestMethod.GET)
    public String loginToGoogle(Model model) {
        googleProvider.getGoogleUserData(model);
        return "redirect:authorization";
    }
}
