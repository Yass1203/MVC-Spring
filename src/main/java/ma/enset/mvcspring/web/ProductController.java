package ma.enset.mvcspring.web;

import ma.enset.mvcspring.entities.Product;
import ma.enset.mvcspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired // injection des dependance via autowired
    private ProductRepository productRepository;

    //Pour acceder a cette methode on utilisant ann getmapping
    // quand cette methode va s'executer il va retourner une
    // vue qui s'appele product

    @GetMapping("/index")

    //injection des dépendance via constructeur
    // public ProductController(ProductRepository productRepository) {
    //   this.productRepository = productRepository;
    //}

    //Creer une methode qui retourne une vue quelconque
    public String index(Model model){
        // recuperer la liste des produit à partir de la BD
        List<Product> products = productRepository.findAll();
        model.addAttribute("ListProducts",products);
        return "products";
    }
    //Ajouter la methode delete qui va etre executer avec un getmapping avec /delete
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id){
            productRepository.deleteById(id);
            return "redirect:/index";
    }
}
