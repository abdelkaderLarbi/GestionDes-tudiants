package com.Etude.Web;

import java.awt.PageAttributes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.Etude.Metier.ImetierEtude;
import com.Etude.dao.EtudiantRepo;
import com.Etude.dao.Etudiant;

@Controller
public class EtudeController {
   @Autowired
   private ImetierEtude metpers;
   @Autowired
   private EtudiantRepo etudiant;

   @GetMapping(path = "/index")
   public String index() {
	   return "gestetu";
   }
   @GetMapping(path = "/etudiannt")
   public String Affichage(Model model, @RequestParam(name = "page",defaultValue = "0")int page,
		   @RequestParam(name = "size",defaultValue = "5")int size,
		  @RequestParam(name = "mc",defaultValue = "")String mc) {
	   Page<Etudiant> lp=etudiant.findByNameContains(mc, PageRequest.of(page, size));
	   
	   //Page<Personne> lp=person.findAll(PageRequest.of(page, size));
	   model.addAttribute("Listp", lp);
	   model.addAttribute("pages",new int[lp.getTotalPages()]);
	   model.addAttribute("current", page);
	   model.addAttribute("size", size);
	   
	   return "etudiants";
   }
   @GetMapping(path = "/nouveau")
   public String AffichForm(Model model) {
	   
	   Etudiant pers=new Etudiant();
	   model.addAttribute("etudiant", pers);
	   
	   return "AddEtu";
   }
   
   @PostMapping("/nouveau")
   public String Addpers(Model model,@ModelAttribute("etudiant")Etudiant p) {
	   
	   metpers.ajouter(p);
	   return "redirect:/etudiannt";
	   
   }
   
   
   @GetMapping("/delperson")
   public String del(Long id,String page, String size, String mc) {
	   etudiant.deleteById(id);
	   return "redirect:/etudiannt?page="+page+"&size"+size+"&mc";
	   
   }
   
   @GetMapping("/update/edit/{id}")
   public String updateper(@PathVariable Long id, Model model) {
       // Fetch the person by ID
       Etudiant existingPerson = etudiant.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

       model.addAttribute("etudiant", existingPerson);
       return "MAJetu"; // Or the correct name of your update form
   }


 @PostMapping("/update/{id}")
 public String updateper(@PathVariable Long id, @ModelAttribute("etudiant") Etudiant updatedPerson) {
     // Fetch existing person by ID
     Etudiant existingPerson = etudiant.findById(id)
             .orElseThrow(() -> new IllegalArgumentException("Invalid person Id:" + id));

     // Update existing person's details
     existingPerson.setCode(updatedPerson.getCode());
     existingPerson.setName(updatedPerson.getName());
     existingPerson.setAdresse(updatedPerson.getAdresse());
     existingPerson.setMoyenne(updatedPerson.getMoyenne());
     // Set other properties as needed

     // Save the updated person
     etudiant.save(existingPerson);

     return "redirect:/etudiannt"; // Redirect to the list page
     
 }
 
 @GetMapping("/login")
 public String loginPage() {
     return "login"; // This will resolve to login.html in Thymeleaf
 }
 @GetMapping("/logout")
 public String logoutPage() {
     return "login"; // This will resolve to login.html in Thymeleaf
 }
 
 
 
}
   


