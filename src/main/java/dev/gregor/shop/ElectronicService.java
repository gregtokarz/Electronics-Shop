package dev.gregor.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ElectronicService {
    @Autowired
    private ElectronicRepository electronicRepository;
    public List<Electronic> allElectronics(){
        return electronicRepository.findAll();
    }


    public Optional<Electronic> singleElectronic(String electronicId) {

        return electronicRepository.findByElectronicId(electronicId);
    }

    public boolean deleteObjectById(String electronicId) {
        // Sprawdzanie, czy obiekt istnieje
        if (electronicRepository.findByElectronicId(electronicId).isPresent()) {
            electronicRepository.deleteByElectronicId(electronicId);
            return true; // Obiekt został usunięty pomyślnie
        } else {
            return false; // Obiekt o podanym id nie został znaleziony
        }
    }

    public void saveElectronic(Electronic electronic) {
        // Dodawanie nowego obiektu Electronic do bazy danych
        electronicRepository.save(electronic);
    }
}
