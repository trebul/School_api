package com.example.api.controller;

import com.example.api.model.Address;
import com.example.api.model.Teacher;
import com.example.api.service.AddressService;
import com.example.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable int id) {
        return addressService.getAddressById(id);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable int id, @RequestBody Address address) {
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id){
        addressService.deleteAddress(id);
    }
}
