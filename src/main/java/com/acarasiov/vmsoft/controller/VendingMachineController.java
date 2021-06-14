package com.acarasiov.vmsoft.controller;


import com.acarasiov.vmsoft.service.VendingMachineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;



@Controller
public class VendingMachineController {

    VendingMachineService service;

    @Inject
    public VendingMachineController(VendingMachineService service){
        this.service = service;
    }

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("balance", service.getBalance());
        model.addAttribute("itemChoice", service.getItemChoice());
        model.addAttribute("change", service.getChange());
        model.addAttribute("items", service.getAllItems());
        model.addAttribute("textMessage", service.getTextMessage());
        return "index";
    }


    @RequestMapping(value = "/addMoney/{amount}", method = RequestMethod.GET) //by adding the Path Variable, it helps with cutting down repeated code
    public String addMoney(@PathVariable String amount){
        service.addMoney(amount);
        return "redirect:/";
    }

    @RequestMapping(value = "/vendItem", method = RequestMethod.GET)
    public String vendItem(){
        service.vendItem();
        return "redirect:/";
    }

    @RequestMapping(value="/returnChange", method = RequestMethod.GET)
    public String returnChange(){
        service.returnChange();
        return "redirect:/";
    }

    @RequestMapping(value ="/itemChoice/{id}", method = RequestMethod.GET)
    public String itemChoice(@PathVariable("id") int id){ // we are binding the request URL template path variable to the method variable
        service.setItemChoice(id);
        return "redirect:/";
    }


}
