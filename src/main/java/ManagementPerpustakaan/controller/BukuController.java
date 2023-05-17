package ManagementPerpustakaan.controller;

import ManagementPerpustakaan.model.Buku;
import ManagementPerpustakaan.service.AuthorService;
import ManagementPerpustakaan.service.BukuService;
import ManagementPerpustakaan.service.PublisherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

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
import org.springframework.web.bind.annotation.RequestParam;
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
public class BukuController {
    private final BukuService bukuService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    
    public BukuController(BukuService bukuService,AuthorService authorService,PublisherService publisherService) {
        this.bukuService = bukuService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }
    
    @GetMapping("/books")
    public String getAllBuku(Model model){
        List<Buku> books = bukuService.getAllBuku();
        model.addAttribute("books", books);
        return "list-books";
    } 
    
    @RequestMapping("/searchBook")
    public String searchBook(@Param("keyword") String keyword, Model model) {
	final List<Buku> books = bukuService.searchBooks(keyword);

	model.addAttribute("books", books);
	model.addAttribute("keyword", keyword);
	return "list-books";
    }
    
    @RequestMapping("/book/{id}")
    public String findBukuById(@PathVariable("id") String id, Model model) {
	final Buku buku = bukuService.findBukuById(id);

	model.addAttribute("book", buku);
	return "list-book";
    }
    
    @GetMapping("/add")
    public String showCreateForm(Buku buku, Model model) {
	model.addAttribute("bukuName", bukuService.getAllBuku());
	model.addAttribute("bukuCategory", bukuService.getAllBuku());
        model.addAttribute("authors", authorService.getAllAuthor());
	model.addAttribute("publishers", publisherService.getAllPublisher());
	return "add-book";
    }
    
    @RequestMapping("/add-book")
    public String addBook(Buku buku, BindingResult result, RedirectAttributes redirectAttrs) {
	if (result.hasErrors()) {
            return "add-book";
	}
	bukuService.createBuku(buku);
        redirectAttrs.addFlashAttribute("successMsg", "Data Buku Berhasil Ditambahkan.");
	return "redirect:/books";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
	final Buku buku = bukuService.findBukuById(id);

	model.addAttribute("buku", buku);
        model.addAttribute("bukuCategory", bukuService.getAllBuku());
        model.addAttribute("authors", authorService.getAllAuthor());
	model.addAttribute("publishers", publisherService.getAllPublisher());
	return "update-book";
    }
        
    @RequestMapping("/update-book/{id}")
    public String updateBuku(@PathVariable("id") String id, Buku buku, BindingResult result, Model model, RedirectAttributes redirectAttrs) {
	if (result.hasErrors()) {
            buku.setId(id);
            return "update-book";
    } 
    	bukuService.updateBuku(buku);
	model.addAttribute("buku", bukuService.getAllBuku());
        redirectAttrs.addFlashAttribute("upSuccessMsg", "Data Buku Berhasil Diperbarui.");
	return "redirect:/books";
    }  
    
    @RequestMapping("/remove-book/{id}")
    public String deleteBook(@PathVariable("id") String id, RedirectAttributes redirectAttrs) {
	bukuService.deleteBuku(id);

	redirectAttrs.addFlashAttribute("delSuccessMsg", "Data Buku Berhasil Dihapus.");
	return "redirect:/books";
    }
}
    
