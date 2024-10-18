package qreol.project.crm.service;

import qreol.project.crm.model.Client;
import qreol.project.crm.model.Contact;
import qreol.project.crm.model.ContactType;

import java.util.List;

public interface ClientService {

    Client addClient(Client client);

    Contact addContactByClientId(Long clientId, Contact contact);

    List<Client> getAllClients();

    Client getClientById(Long clientId);

    List<Contact> getClientContactsById(Long clientId);

    List<Contact> getClientContactsByIdAndType(Long clientId, String type);

}
