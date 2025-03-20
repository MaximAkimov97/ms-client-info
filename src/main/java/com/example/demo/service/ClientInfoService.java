package com.example.demo.service;

import com.example.demo.domain.Client;
import com.example.demo.entity.ClientEntity;
import com.example.demo.mapper.ClientInfoMapper;
import com.example.demo.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientInfoService {

    private final ClientRepository clientRepository;
    private final ClientInfoMapper clientInfoMapper;


    public Client createClient(Client client) throws ClientRegistrationBanException {
        if ("ведро".equalsIgnoreCase(client.getFirstName()) &&
                "помоев".equalsIgnoreCase(client.getLastName())) {
            throw new ClientRegistrationBanException("Ошибка в имени и фамилии");
        }
        else {
            return clientInfoMapper.clientEntityToClient(clientRepository.save(clientInfoMapper.clientToClientEntity(client)));
        }
    }

    public Client getClient(Long clientId) {

        //добавить проверку что из базы нашли клиента, если нет выкинуть ошибку
        return clientInfoMapper.clientEntityToClient(clientRepository.findById(clientId).get());
    }

    public void updatePhoneByClientId(Long clientId, String phone) {
        Optional<ClientEntity> optionalClient = clientRepository.findById(clientId);
        // Проверяем, существует ли клиент
        if (optionalClient.isPresent()) {
            ClientEntity client = optionalClient.get();
            // Обновляем телефон клиента
            client.setPhone(phone);
            // Сохраняем изменения в базе данных
            clientRepository.save(client);
        } else {
            throw new ClientNotFoundException("клиент не найден");
        }
    }



    public void deleteClientId(Long clientId) {
        Optional<ClientEntity> optionalClient = clientRepository.findById(clientId);
        // Проверяем, существует ли клиент
        if (optionalClient.isPresent()) {
            ClientEntity client = optionalClient.get();
            clientRepository.delete(client);
        } else {
            throw new ClientNotFoundException("клиент не найден");
        }
    }
}
