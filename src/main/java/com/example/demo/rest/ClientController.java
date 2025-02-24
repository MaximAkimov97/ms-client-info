package com.example.demo.rest;

import com.example.demo.domain.Client;
import com.example.demo.dto.ClientDTO;
import com.example.demo.mapper.ClientInfoMapper;
import com.example.demo.service.ClientInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientInfoService clientInfoService;
    private final ClientInfoMapper clientInfoMapper;


    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO client) {
        Client clientDomain = clientInfoService.createClient(clientInfoMapper.clientDTOToClient(client));
        return new ResponseEntity<>(clientInfoMapper.clientToClientDTO(clientDomain), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ClientDTO> getClient(@RequestParam(value = "clientId") Long clientId) {
        Client clientDomain = clientInfoService.getClient(clientId);
        return new ResponseEntity<>(clientInfoMapper.clientToClientDTO(clientDomain), HttpStatus.CREATED);
    }

    @PutMapping("/updatePhone")
    public ResponseEntity<Void> updatePhone(@RequestParam(value = "clientId") Long clientId,
                                            @RequestParam(value = "phone")
                                            @Valid @Pattern(regexp = "^\\+7[0-9]{10}$", message = "Номер телефона должен быть в формате +7xxxxxxxxxx") String  phone) {
        clientInfoService.updatePhoneByClientId(clientId, phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/v2/updatePhone")
    public ResponseEntity<Void> updatePhoneV2(@RequestParam(value = "clientId") Long clientId,
                                              @RequestParam(value = "phone") String phone) {
        clientInfoService.updatePhoneByClientIdV2(clientId, phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteClientsId")//удаляем клиента по его id
    public ResponseEntity<Void> deleteClient(@RequestParam(value = "clientId") Long clientId) {
        clientInfoService.deleteClientId(clientId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
