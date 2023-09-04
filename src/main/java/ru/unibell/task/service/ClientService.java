package ru.unibell.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.unibell.task.domain.Client;
import ru.unibell.task.domain.Contact;
import ru.unibell.task.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public long create(Client client) {
        return repository.save(client).getId();
    }

    public long update(long id, Contact contact) {
        Client client = repository.findById(id).get();
        client.getContacts().add(contact);
        return repository.save(client).getId();
    }

    public Optional<Client> get(long clientId) {
        return repository.findById(clientId);
    }

    public List<Contact> getContacts(long clientId) {
        return repository.getAllContacts(clientId);
    }

    public List<Contact> getContactsByType(long clientId, String type) {
        return repository.getContactsByType(clientId, type);
    }

    public boolean exists(long clientId) {
        return repository.existsById(clientId);
    }

    public List<Client> getAll() {
        return repository.findAll();
    }
}