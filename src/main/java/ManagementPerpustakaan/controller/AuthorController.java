package ManagementPerpustakaan.controller;

import ManagementPerpustakaan.model.Author;
import ManagementPerpustakaan.model.Buku;
import ManagementPerpustakaan.service.AuthorService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Controller
public class AuthorController {
    private final AuthorService authorService;
    
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;

    }
    
    @RequestMapping("/authors")
    public String getAllAuthor(Model model) {
        List<Author> authors = authorService.getAllAuthor();
        model.addAttribute("authors", authors);
        return "list-authors";
    }
    
    @RequestMapping("/author/{id}")
    public String findAuthorById(@PathVariable("id") String id, Model model) {
	final Author author = authorService.getAuthorById(id);

	model.addAttribute("author", author);
	return "list-author";
    }
        
    @GetMapping("/addAuthor") //new
    public String showCreateForm(Author author) {
	return "add-author";
    }
        
    @RequestMapping("/add-author")
    public String addAuthor(Author author, BindingResult result, RedirectAttributes redirectAttrs) {
    	if (result.hasErrors()) {
        	return "add-author";
	}
    	authorService.addAuthor(author);
        redirectAttrs.addFlashAttribute("successMsg", "Data Penulis Berhasil Ditambahkan.");
    	return "redirect:/authors";
    }
    
    @GetMapping("/updateAuthor/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
	final Author author = authorService.getAuthorById(id);

	model.addAttribute("author", author);
	return "update-author";
    }
    
    @RequestMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable("id") String id, Author author, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
	if (result.hasErrors()) {
            author.setId(id);
            return "update-author";
        }
    	authorService.updateAuthor(author);
	model.addAttribute("author", authorService.getAllAuthor());
        redirectAttrs.addFlashAttribute("upSuccessMsg", "Data Penulis Berhasil Diperbarui.");
	return "redirect:/authors";
    }
    
	@RequestMapping("/remove-author/{id}")
	public String deleteAuthor(@PathVariable("id") String id, RedirectAttributes redirectAttrs) {
		authorService.deleteAuthor(id);

		redirectAttrs.addFlashAttribute("delSuccessMsg", "Data Penulis Berhasil Dihapus.");
		return "redirect:/authors";
	}        
}
