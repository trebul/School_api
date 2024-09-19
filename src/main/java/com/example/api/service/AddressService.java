package com.example.api.service;

import com.example.api.model.Address;
import com.example.api.model.Student;
import com.example.api.repository.AddressRepository;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress (Address address) {
        return addressRepository.save(address);
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    public Address getAddressById(int id){
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(int id, Address address) {
        address.setId(id);
        return addressRepository.save(address);
    }

    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }
}
