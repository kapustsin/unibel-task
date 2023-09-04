package ru.unibell.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.unibell.task.domain.Client;
import ru.unibell.task.domain.Contact;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT contact FROM Client client JOIN client.contacts contact WHERE client.id = :id")
    List<Contact> getAllContacts(@Param("id") long id);

    @Query("SELECT contact FROM Client client JOIN client.contacts contact WHERE client.id = :id AND contact.type = :type")
    List<Contact> getContactsByType(@Param("id") long id, @Param("type") String type);

}