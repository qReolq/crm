package qreol.project.crm.service.imlp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qreol.project.crm.model.Client;
import qreol.project.crm.model.Contact;
import qreol.project.crm.model.ContactType;
import qreol.project.crm.model.exception.ResourceNotFoundException;
import qreol.project.crm.repository.ClientRepository;
import qreol.project.crm.repository.ContactRepository;
import qreol.project.crm.service.ClientService;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ContactRepository contactRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Contact addContactByClientId(Long clientId, Contact contact) {
        Client client = getClientById(clientId);
        contact.setClient(client);

        return contactRepository.save(contact);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Client is not found")
                );
    }

    @Override
    public List<Contact> getClientContactsById(Long clientId) {
        getClientById(clientId); // check client
        return contactRepository.findAllByClientId(clientId);
    }

    @Override
    public List<Contact> getClientContactsByIdAndType(Long clientId, String type) {
        getClientById(clientId);

        return contactRepository.findAllByClientIdAndType(
                clientId,
                getContactType(type)
        );
    }

    private ContactType getContactType(String type) {
        try {
            return ContactType.valueOf(type);
        } catch (IllegalArgumentException e){
            throw new ResourceNotFoundException("Contact type is not found");
        }
    }

}
