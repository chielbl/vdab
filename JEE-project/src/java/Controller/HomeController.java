package ehb.be.eindproject.Controller;

import ehb.be.eindproject.model.Artikel;
import ehb.be.eindproject.model.ArtikelRepository;
import ehb.be.eindproject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @ModelAttribute("all")
    public Iterable<Artikel> findAll(){
        return artikelRepository.findAll();
    }

    @RequestMapping(value = {"/","/home"},method = RequestMethod.GET)
    public String showHome(ModelMap map){
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        return "home";
    }

    @RequestMapping(value = "/home/{cat}", method = RequestMethod.GET)
    public  String showHomeByCategory(ModelMap map, @PathVariable(name="cat") String cat){
        map.addAttribute("all", artikelRepository.findByCat(cat));
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        return "home";
    }

}
