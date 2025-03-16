package com.example.api.mapper;

import com.example.api.model.Address;
import com.example.api.model.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDTO(Address address);

    Address toAddress(AddressDTO addressDTO);
}
