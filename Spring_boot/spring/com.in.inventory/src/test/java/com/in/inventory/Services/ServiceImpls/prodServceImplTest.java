package com.in.inventory.Services.ServiceImpls;

import com.in.inventory.Repos.productAvalibilityRepo;
import com.in.inventory.Repos.productRepo;
import com.in.inventory.dto.NotificationDtoResponse;
import com.in.inventory.entities.productAvalibility;
import com.in.inventory.entities.products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class prodServceImplTest {

    @InjectMocks
    private prodServceImpl productService;

    @Mock
    private productRepo productRepo;

    @Mock
    private productAvalibilityRepo productAvalibilityRepo;

    private products testProduct;
    private productAvalibility testAvalibility;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testProduct = new products(1, "Test Product", "10.00", 5, "2024-09-22", "Test Supplier", "Available", "Unit");
        testAvalibility = new productAvalibility(1, "Test Product", "10.00", 5, "Unit");
    }

    @Test
    public void testSaveUser() {
        when(productRepo.save(testProduct)).thenReturn(testProduct);
        when(productAvalibilityRepo.findByProductNameIgnoreCase(testProduct.getProductName())).thenReturn(testAvalibility);
        productService.saveUser(testProduct);

        verify(productRepo, times(1)).save(testProduct);
        assertEquals(10, testAvalibility.getProductQty()); // 5 + 5
    }

    @Test
    public void testGetAllProducts() {
        when(productRepo.findAll()).thenReturn(Arrays.asList(testProduct));

        List<products> result = productService.GetAllProducts();
        assertEquals(1, result.size());
        assertEquals(testProduct, result.get(0));
    }

    @Test
    public void testGetUser() {
        when(productRepo.findById(1)).thenReturn(Optional.of(testProduct));

        products result = productService.getUser(1);
        assertEquals(testProduct, result);
    }

    @Test
    public void testUpdateUser() {
        when(productRepo.findById(1)).thenReturn(Optional.of(testProduct));
        when(productRepo.save(testProduct)).thenReturn(testProduct);

        products updatedProduct = new products(1, "Updated Product", "15.00", 10, "2024-09-22", "Updated Supplier", "Available", "Unit");
        products result = productService.updateUser(1, updatedProduct);

        assertEquals("Updated Product", result.getProductName());
        verify(productRepo, times(1)).save(testProduct);
    }

    @Test
    public void testUpdateStatus() {
        when(productRepo.findById(1)).thenReturn(Optional.of(testProduct));

        products updatedProduct = new products();
        updatedProduct.setStatus("Unavailable");
        products result = productService.updateStatus(1, updatedProduct);

        assertEquals("Unavailable", result.getStatus());
        verify(productRepo, times(1)).save(testProduct);
    }

    @Test
    public void testSaveUserAvail() {
        when(productAvalibilityRepo.save(testAvalibility)).thenReturn(testAvalibility);
        productService.saveUserAvail(testAvalibility);
        verify(productAvalibilityRepo, times(1)).save(testAvalibility);
    }

    @Test
    public void testGetAllProductsAvail() {
        when(productAvalibilityRepo.findAll()).thenReturn(Arrays.asList(testAvalibility));

        List<productAvalibility> result = productService.getAllProductsAvail();
        assertEquals(1, result.size());
        assertEquals(testAvalibility, result.get(0));
    }

    @Test
    public void testNotificationMethod() {
        when(productAvalibilityRepo.findById(1)).thenReturn(Optional.of(testAvalibility));

        NotificationDtoResponse result = productService.notificationMethod(1);
        assertEquals(5, result.getQty());
    }
}
