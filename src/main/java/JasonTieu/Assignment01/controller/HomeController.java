package JasonTieu.Assignment01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import JasonTieu.Assignment01.repository.ItemRepositroy;

@Controller
public class HomeController {
    private ItemRepositroy itemRepositroy;

    public HomeController(ItemRepositroy itemRepositroy){
        this.itemRepositroy = itemRepositroy;
    }
    
    @GetMapping("/")
    public String home(){
        return "Homepage";
    }

    @ModelAttribute
    public void items(Model model){
        model.addAttribute("items", itemRepositroy.findAll());
    }
}
