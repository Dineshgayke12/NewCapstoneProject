package com.in.suplier.Services;

import com.in.suplier.Entities.suplier;

import java.util.List;

public interface suplierServices {


    //    create user
    suplier saveSuplier(suplier Suplier);

    //    Get all user
    List<suplier> GetAllSupliuers();

    //    Get single user
    suplier getSuplier(int id);

    // Update
    public suplier updateSuplier(int id, suplier userDetails);

//    update value
//public void updateSelection(int id, String status);

    //    Update Name
    public suplier updateName(int id, suplier suplierDetails);

//    delete
public void deleteProduct(int id);
}
