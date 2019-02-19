package kz.github.igorz.controller;

import kz.github.igorz.model.Message;
import kz.github.igorz.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Jtahun on 16.02.2019.
 */
@Controller
@SessionAttributes("message")
public class MsgController {

    @Autowired
    private MsgService msgService;

    @RequestMapping(value = "/saw", method = RequestMethod.GET)
    public String saw(Model model){
        model.addAttribute("message",new Message());
        model.addAttribute("msg", msgService.getMessage(1));
        return "saw";
    }


}
