package soa.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.repository.CategorieRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")
public class CategorieRESTController {

    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping(value = "/index")
    public String accueil() {
        return "Bienvenue au service Web REST 'categories'.....";
    }

    @GetMapping(value = "/")
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorie getCategorie(@PathVariable Long id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Categorie updateCategorie(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie); 
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieRepository.deleteById(id);
    }
}