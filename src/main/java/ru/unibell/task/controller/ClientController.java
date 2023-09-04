package ru.unibell.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.unibell.task.domain.Client;
import ru.unibell.task.domain.Contact;
import ru.unibell.task.service.ClientService;

import java.util.List;

@RestController()
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Client client) {
        return new ResponseEntity<>("Client created successfully. Id = " + service.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/contacts")
    public ResponseEntity<String> addContact(@PathVariable long id, @RequestBody Contact contact) {
        if (service.exists(id)) {
            return new ResponseEntity<>("Client " + service.update(id, contact) + " updated successfully",
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Client " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientInfo(@PathVariable long id) {
        return ResponseEntity.of(service.get(id));
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable long id) {
        if (service.exists(id)) {
            return new ResponseEntity<>(service.getContacts(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/contacts/{type}")
    public ResponseEntity<List<Contact>> getClientContactsByType(@PathVariable long id, @PathVariable String type) {
        if (service.exists(id)) {
            return new ResponseEntity<>(service.getContactsByType(id, type), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}