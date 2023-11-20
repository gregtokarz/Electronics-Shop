package dev.gregor.shop;

import org.bson.types.ObjectId;
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


    public Optional<Electronic> singleElectronic(ObjectId id) {
        return electronicRepository.findById(id);
    }
}
