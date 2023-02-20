package JasonTieu.Assignment01.controller;


import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import JasonTieu.Assignment01.model.Item;
import JasonTieu.Assignment01.model.Item.Brand;
import JasonTieu.Assignment01.repository.impl.JdbcItemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/Additem")
public class AddItemController {
    @Autowired
    private JdbcItemRepository itemRepository;

    @GetMapping
    public String addItem(){
        return "addPage";
    }

    @ModelAttribute
    public void brands(Model model){
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("Brands Converted to String: {}", brands);
    }

    @ModelAttribute
    public Item item(){
        return Item
                .builder()
                .build();
    }

    @PostMapping
    public String processItemAddition (@Valid Item item, BindingResult result){
        if (result.hasErrors()){
            return "addItem";
        }
        log.info("Procedssing item: {}", item);
        itemRepository.save(item);
        return "redirect:/";
    }
}
