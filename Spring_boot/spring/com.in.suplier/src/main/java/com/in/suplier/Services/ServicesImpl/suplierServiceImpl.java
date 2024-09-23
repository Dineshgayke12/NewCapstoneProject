package com.in.suplier.Services.ServicesImpl;


import com.in.suplier.Entities.suplier;
import com.in.suplier.Repos.suplierRepo;
import com.in.suplier.Services.suplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class suplierServiceImpl implements suplierServices {

    @Autowired
    private suplierRepo SuplierRepo;

    @Override
    public suplier saveSuplier(suplier Suplier) {
        return SuplierRepo.save(Suplier);
    }

    @Override
    public List<suplier> GetAllSupliuers() {

        return SuplierRepo.findAll();
    }

    @Override
    public suplier getSuplier(int id){
        return SuplierRepo.findById(id).orElseThrow();
    }


    //    Update
    @Override
    public suplier updateSuplier(int id, suplier productDetails) {
        return SuplierRepo.findById(id).map(prod -> {
            prod.setSuplierName(productDetails.getSuplierName());
            prod.setContact(productDetails.getContact());
            prod.setAddress(productDetails.getAddress());


            return SuplierRepo.save(prod);
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

    //    Update Name
    @Override
    public suplier updateName(int id, suplier suplierDetails) {
        return SuplierRepo.findById(id).map(prod -> {

            prod.setSuplierName(suplierDetails.getSuplierName());
            return SuplierRepo.save(prod);
        }).orElseThrow();
    }

//    delete
public void deleteProduct(int id) {
    if (SuplierRepo.existsById(id)) {
        SuplierRepo.deleteById(id);
    } else {
        throw new RuntimeException("Product not found with id " + id);
    }
}

}
