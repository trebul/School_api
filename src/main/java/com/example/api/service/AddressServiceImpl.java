package com.example.api.service;

import com.example.api.model.Address;
import com.example.api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address createAddress (Address address) {
        Optional<Address> foundObject = addressRepository.findById(address.getId());
        if(foundObject.isEmpty()) {
            return addressRepository.save(address);
        }
        else {
            throw new IllegalStateException("Address already exists");
        }
    }

    @Override
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    @Override
    public Address getAddressById(int id){
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address updateAddress(int id, Address address) {
        Optional<Address> foundID = addressRepository.findById(id);
        if(foundID.isPresent()) {
            address.setId(id);
            return addressRepository.save(address);
        }
        else {
            throw new IllegalStateException("Address not found");
        }
    }

    @Override
    public void deleteAddress(int id){
        addressRepository.deleteById(id);
    }
}
