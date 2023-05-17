package ManagementPerpustakaan.service;

import ManagementPerpustakaan.Exception.NotFoundException;
import ManagementPerpustakaan.model.Buku;
import ManagementPerpustakaan.repository.BukuRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Service
public class BukuService {
    private final BukuRepository bukuRepository;
    
    public BukuService(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    public List<Buku> getAllBuku(){
        return bukuRepository.findAll();
    }
    
    public void createBuku(Buku buku){
        bukuRepository.save(buku);
    }
    
    public void updateBuku(Buku buku){
        Buku savedBuku = bukuRepository.findById(buku.getId())
                .orElseThrow(()->new RuntimeException(String.format("Cannot Find Buku by ID %s", buku.getId())));
        
        savedBuku.setIsbn(buku.getIsbn());
        savedBuku.setBukuName(buku.getBukuName());
        savedBuku.setBukuCategory(buku.getBukuCategory());
        savedBuku.setBukuAuthors(buku.getBukuAuthors());
        savedBuku.setBukuPublisher(buku.getBukuPublisher());
        
        bukuRepository.save(buku);
    } 
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Buku> searchBooks(String keyword) {
	if (keyword != null) {
            return bukuRepository.search(keyword);
	}
        return bukuRepository.findAll();
    }    
    
    public Buku findBukuById(String id) {
	return bukuRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
    }
    
    public void deleteBuku(String id) {
	final Buku buku = bukuRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

            bukuRepository.deleteById(buku.getId());
    }   
    
}

