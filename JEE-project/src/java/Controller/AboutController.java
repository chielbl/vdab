package ehb.be.eindproject.Controller;

import ehb.be.eindproject.model.ArtikelRepository;
import ehb.be.eindproject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String showAbout(ModelMap map){
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        return "about";
    }
}
