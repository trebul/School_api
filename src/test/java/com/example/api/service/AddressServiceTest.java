package com.example.api.service;

import com.example.api.model.Address;
import com.example.api.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void createAddress() throws Exception {
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);

        when(addressRepository.save(address)).thenReturn(address);

        Address result = addressService.createAddress(address);

        assertNotNull(result);
        assertEquals(address, result);
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void getAllAddresses() {
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);

        when(addressRepository.findAll()).thenReturn(Collections.singletonList(address));

        List<Address> addresses = addressService.getAllAddresses();
        assertNotNull(addresses);
        assertEquals(1, addresses.size());
        assertEquals(address, addresses.get(0));

        verify(addressRepository, times(1)).findAll();

    }

    @Test
    void getAddressById() {
        Address address = new Address();
        address.setId(1);
        address.setCity("Plzeň");
        address.setStreet("Moravská");
        address.setStreetNumber(154);

        when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        Address result = addressService.getAddressById(1);
        assertNotNull(result);
        assertEquals(address, result);
        verify(addressRepository).findById(1);
    }

    @Test
    void updateAddress() {
        Address existingAddress = new Address();
        existingAddress.setId(1);
        existingAddress.setCity("Plzeň");
        existingAddress.setStreet("Moravská");
        existingAddress.setStreetNumber(154);

        Address updatedAddress = new Address();
        updatedAddress.setId(1);
        updatedAddress.setCity("Brno");
        updatedAddress.setStreet("Česká");
        updatedAddress.setStreetNumber(42);

        when(addressRepository.findById(1)).thenReturn(Optional.of(existingAddress));

        when(addressRepository.save(updatedAddress)).thenReturn(updatedAddress);

        Address result = addressService.updateAddress(1, updatedAddress);

        assertNotNull(result);
        assertEquals(updatedAddress.getCity(), result.getCity());
        assertEquals(updatedAddress.getStreet(), result.getStreet());
        assertEquals(updatedAddress.getStreetNumber(), result.getStreetNumber());
        verify(addressRepository).save(updatedAddress);
    }

    @Test
    void deleteAddress() {
        int addressId = 1;
        addressService.deleteAddress(addressId);
        verify(addressRepository).deleteById(addressId);
    }
}