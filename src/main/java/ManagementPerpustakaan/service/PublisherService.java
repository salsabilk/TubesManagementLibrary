package ManagementPerpustakaan.service;

import ManagementPerpustakaan.Exception.NotFoundException;
import ManagementPerpustakaan.model.Publisher;
import ManagementPerpustakaan.repository.PublisherRepository;
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
public class PublisherService {
    private final PublisherRepository publisherRepository;
    
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
    
    public List<Publisher> getAllPublisher(){  
        return publisherRepository.findAll();
    }
    
    public void addPublisher(Publisher publisher){
        publisherRepository.save(publisher);
    }
       
    public void updatePublisher(Publisher publisher){
        Publisher savedPublisher = publisherRepository.findById(publisher.getId()).orElseThrow(()->new RuntimeException(
          String.format("Cannot Find Publisher by ID %s", publisher.getId())));
        
        savedPublisher.setId(publisher.getId());
        savedPublisher.setPublisherName(publisher.getPublisherName());
        savedPublisher.setPublisherCategory(publisher.getPublisherCategory());;
        
        publisherRepository.save(publisher);
    }
 
    public Publisher getPublisherById(String id) {
	return publisherRepository.findById(id).orElseThrow(() -> new NotFoundException(
              String.format("Publisher not found  with ID %d", id)));
    } 
        
//    public Publisher getPublisherById(String id){
//        return publisherRepository.findById(id).orElseThrow(()->new RuntimeException(
//         String.format("Cannot Find Publisher by Id %s", id)));
//    }
   
    public void deletePublisher(String id) {
        final Publisher publisher = publisherRepository.findById(id)
                	.orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));

                        publisherRepository.deleteById(publisher.getId());
	}
    
//    public void deletePublisher(String id){
//        publisherRepository.deleteById(id);
//    }
}

