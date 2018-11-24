package com.jakub.firstSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/form")
    public String form(Model model){
        CreditForm creditForm = new CreditForm();
        model.addAttribute("creditObject", creditForm);
        return "creditForm";
    }

    @PostMapping("/form")
    public String form(@ModelAttribute CreditForm creditForm, Model model){
        model.addAttribute("getCredit",(creditForm.getMonthlyEarnings() - creditForm.getExpenses() > creditForm.getCreditAmount() / creditForm.getCreditTime() * 1.3));
    return "creditForm";
    }
}
