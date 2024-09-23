package com.in.suplier.Services.ServicesImpl;

import com.in.suplier.Entities.suplier;
import com.in.suplier.Repos.suplierRepo;
import com.in.suplier.Services.suplierServices;
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

public class suplierServiceImplTest {

    @InjectMocks
    private suplierServiceImpl suplierService;

    @Mock
    private suplierRepo suplierRepo;

    private suplier testSuplier;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        testSuplier = new suplier(1, "Test Supplier", "1234567890", "123 Test St.");
    }

    @Test
    public void testSaveSuplier() {
        when(suplierRepo.save(testSuplier)).thenReturn(testSuplier);

        suplier result = suplierService.saveSuplier(testSuplier);

        assertEquals(testSuplier, result);
        verify(suplierRepo, times(1)).save(testSuplier);
    }

    @Test
    public void testGetAllSupliuers() {
        when(suplierRepo.findAll()).thenReturn(Arrays.asList(testSuplier));

        List<suplier> result = suplierService.GetAllSupliuers();

        assertEquals(1, result.size());
        assertEquals(testSuplier, result.get(0));
    }

    @Test
    public void testGetSuplier() {
        when(suplierRepo.findById(1)).thenReturn(Optional.of(testSuplier));

        suplier result = suplierService.getSuplier(1);

        assertEquals(testSuplier, result);
    }

    @Test
    public void testUpdateSuplier() {
        when(suplierRepo.findById(1)).thenReturn(Optional.of(testSuplier));
        when(suplierRepo.save(testSuplier)).thenReturn(testSuplier);

        suplier updatedSuplier = new suplier(1, "Updated Supplier", "0987654321", "456 Updated St.");
        suplier result = suplierService.updateSuplier(1, updatedSuplier);

        assertEquals("Updated Supplier", result.getSuplierName());
        assertEquals("0987654321", result.getContact());
        verify(suplierRepo, times(1)).save(testSuplier);
    }

    @Test
    public void testUpdateName() {
        when(suplierRepo.findById(1)).thenReturn(Optional.of(testSuplier));
        when(suplierRepo.save(testSuplier)).thenReturn(testSuplier);

        suplier updatedSuplier = new suplier();
        updatedSuplier.setSuplierName("New Supplier Name");
        suplier result = suplierService.updateName(1, updatedSuplier);

        assertEquals("New Supplier Name", result.getSuplierName());
        verify(suplierRepo, times(1)).save(testSuplier);
    }

    @Test
    public void testDeleteProduct() {
        when(suplierRepo.existsById(1)).thenReturn(true);

        assertDoesNotThrow(() -> suplierService.deleteProduct(1));
        verify(suplierRepo, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteProductNotFound() {
        when(suplierRepo.existsById(1)).thenReturn(false);

        Exception exception = assertThrows(RuntimeException.class, () -> suplierService.deleteProduct(1));
        assertEquals("Product not found with id 1", exception.getMessage());
    }
}
