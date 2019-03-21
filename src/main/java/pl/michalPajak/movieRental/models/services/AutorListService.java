package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.AutorRepository;
import pl.michalPajak.movieRental.models.entitys.AutorEntiti;

import java.util.Optional;

@Service
@Data
public class AutorListService {

    @Autowired
    private AutorRepository autorRepository;

    public Iterable<AutorEntiti> getAllAutors() {
        return autorRepository.findAll();
    }

    public AutorEntiti getAutorByName(String surname) {
        Optional<AutorEntiti> optionalAutorEntiti = autorRepository.findAurorBySurname(surname);
        if (optionalAutorEntiti.isPresent())
            return optionalAutorEntiti.get();
        throw new IllegalStateException();
    }

//    public void addNewAutor(){}
}
