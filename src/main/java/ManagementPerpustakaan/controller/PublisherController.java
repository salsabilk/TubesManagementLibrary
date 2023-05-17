package ManagementPerpustakaan.controller;

import ManagementPerpustakaan.model.Publisher;
import ManagementPerpustakaan.service.PublisherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Controller
public class PublisherController {
    private final PublisherService publisherService;
    
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }    
        
    @RequestMapping("/publishers")
    public String getAllPublisher(Model model) {
	final List<Publisher> publishers = publisherService.getAllPublisher();
	model.addAttribute("publishers", publishers);
	return "list-publishers";
    }

    @RequestMapping("/publisher/{id}")
    public String findPublisherById(@PathVariable("id") String id, Model model) {
	final Publisher publisher = publisherService.getPublisherById(id);
    	model.addAttribute("publisher", publisher);
    	return "list-publisher";
    }
    
    @GetMapping("/addPublisher")
    public String showCreateForm(Publisher publisher,Model model) { //new
	return "add-publisher";
    }
    
    @RequestMapping("/add-publisher")
    public String createPublisher(Publisher publisher, BindingResult result, RedirectAttributes redirectAttrs) {
	if (result.hasErrors()) {
            return "add-publisher";
	}

        publisherService.addPublisher(publisher);
        redirectAttrs.addFlashAttribute("successMsg", "Data Penerbit Berhasil Ditambahkan.");
        return "redirect:/publishers";
    }
    
    @GetMapping("/updatePublisher/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
	final Publisher publisher = publisherService.getPublisherById(id);

	model.addAttribute("publisher", publisher);
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable("id") String id, Publisher publisher, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
	if (result.hasErrors()) {
            publisher.setId(id);
            return "update-publisher";
        }

        publisherService.updatePublisher(publisher);
        model.addAttribute("publisher", publisherService.getAllPublisher());
        redirectAttrs.addFlashAttribute("upSuccessMsg", "Data Penerbit Berhasil Diperbarui.");
        return "redirect:/publishers";
    }
    
    @RequestMapping("/remove-publisher/{id}")
    public String deletePublisher(@PathVariable("id") String id, RedirectAttributes redirectAttrs) {
        publisherService.deletePublisher(id);

	redirectAttrs.addFlashAttribute("delSuccessMsg", "Data Penerbit Berhasil Dihapus.");
	return "redirect:/publishers";
    }
}
