package com.in.inventory.Services;

import com.in.inventory.dto.NotificationDtoResponse;
import com.in.inventory.entities.productAvalibility;
import com.in.inventory.entities.products;

import java.util.List;

public interface productServices {

//    create user
    void saveUser(products product);

//    subtract
public void substractQty(productAvalibility product);

//    Get all user
    List<products> GetAllProducts();

//    Get single user
    products getUser(int id);

// Update
    public products updateUser(int id, products userDetails);

//    update value
//public void updateSelection(int id, String status);

//    Update status
public products updateStatus(int id, products productDetails);

//*********************************
    //    create user for avail
    void saveUserAvail(productAvalibility product);
//    all
    public List<productAvalibility> getAllProductsAvail();

//
//  productAvalibility updateQYT(int id,products productDetails);

     productAvalibility addItem(int id, productAvalibility productDetails);

    NotificationDtoResponse notificationMethod(int notID);
}
