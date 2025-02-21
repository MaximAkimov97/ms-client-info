package com.example.demo.mapper;

import com.example.demo.domain.Client;
import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientInfoMapper {

    @Mapping(target = "phoneNumber", source = "phone")
    ClientDTO clientToClientDTO(Client client);

    @Mapping(target = "phone", source = "phoneNumber")
    Client clientDTOToClient(ClientDTO clientDTO);

    ClientEntity clientToClientEntity(Client client);

    Client clientEntityToClient(ClientEntity clientEntity);
}
