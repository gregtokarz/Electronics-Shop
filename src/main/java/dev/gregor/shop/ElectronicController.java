package dev.gregor.shop;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/electronics")
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping
    public ResponseEntity<List<Electronic>> allElectronics(){
        return new ResponseEntity<List<Electronic>>(electronicService.allElectronics(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Electronic>> getSingleElectronic(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Electronic>>(electronicService.singleElectronic(id), HttpStatus.OK);
    }
}
