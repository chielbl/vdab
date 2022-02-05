package ehb.be.eindproject.Controller;

import ehb.be.eindproject.model.Artikel;
import ehb.be.eindproject.model.ArtikelRepository;
import ehb.be.eindproject.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoController {

    @Autowired
    private ArtikelRepository artikelRepository;

    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public String showInfo(ModelMap map, @PathVariable(value = "id") int id){
        map.addAttribute("cart", Order.INSTANCE.getShoppingCar());
        Artikel a = artikelRepository.findById(id).get();
        map.addAttribute("artikel", a);
        return "info";
    }
}
