package com.in.inventory.Controllers;


import com.in.inventory.Services.productServices;
import com.in.inventory.dto.NotificationDtoResponse;
import com.in.inventory.entities.productAvalibility;
import com.in.inventory.entities.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private productServices ProductServices;

//    creat
    @PostMapping
    public void createProduct(@RequestBody products products){
       ProductServices.saveUser(products);
    }

//



    @PostMapping({"/substract"})
    public void substractQty(productAvalibility productss){

         ProductServices.substractQty(productss) ;
    }

    @GetMapping("/{userId}")
    public  ResponseEntity<products> getSingleProduct(@PathVariable int userId){
        products prod1=ProductServices.getUser(userId);
        return  ResponseEntity.ok(prod1);
    }

    @GetMapping
    public  ResponseEntity<List<products>> getAllProducts(){
        List<products> allProds=ProductServices.GetAllProducts();
        return ResponseEntity.ok(allProds);
    }

//    updtate
    @PutMapping("/{userId}")
    public products updateUser(@PathVariable int userId, @RequestBody products prod) {

     return ProductServices.updateUser(userId, prod);

    }

//    Update status
//    @PutMapping("/updateSelection")
//    public String updateSelection(@RequestBody products request) {
//        ProductServices.updateSelection(request.getId(), request.getStatus());
//        return "Selection updated successfully";
//    }

    @PutMapping("status/{userId}")
    public products updateStatus(@PathVariable int userId, @RequestBody products prod) {
        return ProductServices.updateStatus(userId, prod);
    }

    @PostMapping({"/productsAdd"})
    public void saveUserAvail(@RequestBody productAvalibility productss){
         ProductServices.saveUserAvail(productss);
    }

    @GetMapping({"/allProdsAvail"})
    public  ResponseEntity<List<productAvalibility>> getAllProductsAvail(){
        List<productAvalibility> allProds=ProductServices.getAllProductsAvail();
        return ResponseEntity.ok(allProds);
    }



//    @PutMapping("qty/{userId}")
//    public productAvalibility updateQYTt(@PathVariable int userId, @RequestBody products prod) {
//        return productServices.updateQYT(userId, prod);
//
//    }


//    Updating QTY
    @PutMapping("updateItem/{userId}")
    public ResponseEntity<?> updateItem(@PathVariable int userId, @RequestBody productAvalibility prod) {
        return  new ResponseEntity<>(ProductServices.addItem(userId, prod),HttpStatus.CREATED) ;
    }


//


    @GetMapping( "notification/{notID}")
    public NotificationDtoResponse notificationMethod(@PathVariable int notID){
      return   ProductServices.notificationMethod(notID);
    }



}
