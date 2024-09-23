package com.in.inventory.Services.ServiceImpls;

import com.in.inventory.Repos.productAvalibilityRepo;
import com.in.inventory.Repos.productRepo;
import com.in.inventory.Services.productServices;
import com.in.inventory.dto.NotificationDtoResponse;
import com.in.inventory.entities.productAvalibility;
import com.in.inventory.entities.products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class prodServceImpl implements productServices {

    @Autowired
    private productRepo ProductRepo;

    @Autowired
    private productAvalibilityRepo productAvalibilityRep;

    //addition and ENtiityt binded here update 2
    @Override
    public void saveUser(products product) {
        ProductRepo.save(product);
        productAvalibility productss = productAvalibilityRep.findByProductNameIgnoreCase(product.getProductName());

        if (product.getProductQty() == null) {
            product.setProductQty(0); // Default value
        }

        if (productss.getProductQty() == null) {
            productss.setProductQty(0); // Default value

        }

        productss.setProductQty(product.getProductQty() + productss.getProductQty());
        productAvalibilityRep.save(productss);

    }

    //    addition of prod qty
    @Override
    public void substractQty(productAvalibility product) {

//        productAvalibility productss = productAvalibilityRep.findByProductNameIgnoreCase(product.getProductName());
//
//        if (product.getProductQty() == null) {
//            product.setProductQty(0); // Default value
//        }
//
//        if (productss.getProductQty() == null) {
//            productss.setProductQty(0); // Default value
//
//        }

//        productss.setProductQty(productss.getProductQty()-product.getProductQty());
        productAvalibilityRep.save(product);
    }

    @Override
    public List<products> GetAllProducts() {
        return ProductRepo.findAll();
    }

    @Override
    public products getUser(int id) {
        return ProductRepo.findById(id).orElseThrow();
    }


    //    Update
    @Override
    public products updateUser(int id, products productDetails) {
        return ProductRepo.findById(id).map(prod -> {
            prod.setProductName(productDetails.getProductName());
            prod.setDate(productDetails.getDate());
            prod.setUnit(productDetails.getUnit());
            prod.setPrice(productDetails.getPrice());
            prod.setStatus(productDetails.getStatus());
            prod.setProductQty(productDetails.getProductQty());
            prod.setSuplierName(productDetails.getSuplierName());


            return ProductRepo.save(prod);
        }).orElseThrow();
    }

//    update value
//    @Override
//        public void updateSelection(int id, String status) {
//            // Check if the entity exists before updating
//            if (ProductRepo.existsById(id)) {
//                ProductRepo.updateValueById (id, status);
//            } else {
//                throw new ResourceNotFoundException();
//            }
//        }

    //    Update status
    @Override
    public products updateStatus(int id, products productDetails) {
        return ProductRepo.findById(id).map(prod -> {

            prod.setStatus(productDetails.getStatus());
            return ProductRepo.save(prod);
        }).orElseThrow();
    }


    @Override
    public void saveUserAvail(productAvalibility productt) {
        productAvalibilityRep.save(productt);
    }

    @Override
    public List<productAvalibility> getAllProductsAvail() {

        return productAvalibilityRep.findAll();
    }

//    @Override
//    public productAvalibility updateQYT(int id, products productDetails) {
//        return productAvalibilityRep.findById(id).map(prod -> {
//
//            prod.setProductQty(5);
//            return productAvalibilityRep.save(prod);
//        }).orElseThrow();
//
//    }

    //
    @Override
    public productAvalibility addItem(int id, productAvalibility productDetails) {
        Optional<productAvalibility> productAvalibility = productAvalibilityRep.findById(id);
        if (productAvalibility.isPresent()) {

            productAvalibility avalibility = productAvalibility.get();
//            avalibility.setProductQty(productDetails.getProductQty());
//            return productAvalibilityRep.save(avalibility);

            avalibility.setProductQty(avalibility.getProductQty() - productDetails.getProductQty());
            return productAvalibilityRep.save(avalibility);


        }

        return null;
    }

    //    notification
//@Override
    public List<productAvalibility> notification() {

        return productAvalibilityRep.findAll();
    }

    //    notification post
    @Override
    public NotificationDtoResponse notificationMethod(int notID) {
    Optional<productAvalibility> productAvalibility=  productAvalibilityRep.findById(notID);
        return productAvalibility.map(avalibility -> new NotificationDtoResponse(avalibility.getProductQty())).orElse(null);
    }

}
