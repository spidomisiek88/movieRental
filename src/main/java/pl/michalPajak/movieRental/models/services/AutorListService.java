package pl.michalPajak.movieRental.models.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.movieRental.models.repositoris.AutorRepository;
import pl.michalPajak.movieRental.models.entitis.AutorEntity;

import java.util.Optional;

@Service
@Data
public class AutorListService {

    @Autowired
    private AutorRepository autorRepository;

    public Iterable<AutorEntity> getAllAutors() {
        return autorRepository.findAll();
    }

    public AutorEntity getAutorByName(String surname) {
        Optional<AutorEntity> optionalAutorEntiti = autorRepository.findAurorBySurname(surname);
        if (optionalAutorEntiti.isPresent())
            return optionalAutorEntiti.get();
        throw new IllegalStateException();
    }

//    public void addNewAutor(){}
}
