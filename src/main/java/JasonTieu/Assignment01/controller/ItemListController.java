package JasonTieu.Assignment01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import JasonTieu.Assignment01.model.dto.ItemSearchByYearDto;
import JasonTieu.Assignment01.repository.ItemRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/Itemlist")
public class ItemListController {
    
    private ItemRepository itemRepository;
    
    public ItemListController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String showItem(Model model) {
        return "itemListPage";
    }

    @ModelAttribute
    public void items(Model model){
        model.addAttribute("items", itemRepository.findAll());
    }
    
    // @PostMapping
    // public String searchItembyYear(@ModelAttribute ItemSearchByYearDto itemSearchByYearDto, Model model){
    //     model.addAttribute("items", itemRepository.findByBrandAndYear(
    //         itemSearchByYearDto.getName(), itemSearchByYearDto.getYear()));
    //     return "itemListPage";
    // }


}
