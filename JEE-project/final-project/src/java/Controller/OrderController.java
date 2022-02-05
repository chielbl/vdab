package ehb.be.eindproject.Controller;

import ehb.be.eindproject.model.Artikel;
import ehb.be.eindproject.model.ArtikelRepository;
import ehb.be.eindproject.model.Klant;
import ehb.be.eindproject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class OrderController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String showCart(ModelMap map) {
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        map.addAttribute("klant", new Klant());
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String showCart(@ModelAttribute(value = "klant") @Valid Klant klant, BindingResult bindingResult, ModelMap map) {
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        if (bindingResult.hasErrors()){
            return "order";
        }
        return "confirm";
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public  String addItem(ModelMap map, @PathVariable(name="id") int id){
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        Artikel addArtikel = artikelRepository.findById(id).get();
        Order.INSTANCE.addItem(addArtikel);

        return "redirect:/home";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public  String deleteItem(ModelMap map, @PathVariable(name="id") int id){
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        Artikel delArtikel = artikelRepository.findById(id).get();
        Order.INSTANCE.deleteItem(delArtikel);

        if (Order.INSTANCE.getShoppingCar().isEmpty()){
            return "redirect:/home";
        }

        return "redirect:/order";
    }

}
