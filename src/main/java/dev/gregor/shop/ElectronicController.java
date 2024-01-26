package dev.gregor.shop;

import io.swagger.v3.oas.annotations.Operation;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping
    @Operation(summary = "Returns list of all electronics")
    public ResponseEntity<List<Electronic>> allElectronics(){
        return new ResponseEntity<List<Electronic>>(electronicService.allElectronics(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete product by ID")
    public ResponseEntity<String> deleteObjectById(@PathVariable("id") String electronicId) {
        boolean deleted = electronicService.deleteObjectById(electronicId);

        if (deleted) {
            return new ResponseEntity<>("Object deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Object not found or could not be deleted", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{electronicId}")
    @Operation(summary = "Return one product by ID")
    public ResponseEntity<Optional<Electronic>> getSingleElectronic(@PathVariable String electronicId){
        return new ResponseEntity<Optional<Electronic>>(electronicService.singleElectronic(electronicId), HttpStatus.OK);
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new electronic")
    public ResponseEntity<String> addElectronic(@RequestBody Electronic electronic) {
        try {
            // Przekazanie obiektu do serwisu do zapisania w bazie danych
            electronicService.saveElectronic(electronic);

            return new ResponseEntity<>("Electronic added successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding electronic: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
