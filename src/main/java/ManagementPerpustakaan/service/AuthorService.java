package ManagementPerpustakaan.service;

import ManagementPerpustakaan.Exception.NotFoundException;
import ManagementPerpustakaan.model.Author;
import ManagementPerpustakaan.repository.AuthorRepository;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
        
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public List<Author> getAllAuthor(){  
        return authorRepository.findAll();
    }
    
    public void addAuthor(Author author){
        authorRepository.save(author);
    }
    
    public void updateAuthor(Author author){
        Author savedAuthor = authorRepository
                .findById(author.getId()).orElseThrow(()->new RuntimeException(String.format("Cannot Find Author by ID %s", author.getId())));
        
        savedAuthor.setId(author.getId());
        savedAuthor.setAuthorName(author.getAuthorName());
        savedAuthor.setAuthorBiografi(author.getAuthorBiografi());

        
        authorRepository.save(author);
    }
    
    public Author getAuthorById(String id){
        return authorRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Cannot Find Author by Name %s", id)));
    }
    public void deleteAuthor(String id) {
	final Author author = authorRepository.findById(id)
		.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));

                authorRepository.deleteById(author.getId());
    }

}
