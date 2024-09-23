package com.in.suplier.Controllers;


import com.in.suplier.Entities.suplier;
import com.in.suplier.Services.suplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/suplier")
public class suplierControlller {

    @Autowired
    private suplierServices SuplierService;

    //    creat
    @PostMapping
    public ResponseEntity<suplier> createProduct(@RequestBody suplier Suplier) {
        suplier prod = SuplierService.saveSuplier(Suplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<suplier> getSingleProduct(@PathVariable int userId) {
        suplier prod1 = SuplierService.getSuplier(userId);
        return ResponseEntity.ok(prod1);
    }

    @GetMapping
    public ResponseEntity<List<suplier>> GetAllSupliuers() {
        List<suplier> allProds = SuplierService.GetAllSupliuers();
        return ResponseEntity.ok(allProds);
    }

    //    updtate
    @PutMapping("/{userId}")
    public suplier updateSuplier(@PathVariable int userId, @RequestBody suplier prod) {

        return SuplierService.updateSuplier(userId, prod);

    }


    @PutMapping("status/{userId}")
    public suplier updateName(@PathVariable int userId, @RequestBody suplier prod) {

        return SuplierService.updateName(userId, prod);

    }

    //    Delete APT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        try {
            SuplierService.deleteProduct(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
