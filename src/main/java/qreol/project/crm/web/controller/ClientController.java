package qreol.project.crm.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qreol.project.crm.model.Client;
import qreol.project.crm.model.Contact;
import qreol.project.crm.repository.mapper.ClientMapper;
import qreol.project.crm.repository.mapper.ContactMapper;
import qreol.project.crm.service.ClientService;
import qreol.project.crm.web.dto.ClientDto;
import qreol.project.crm.web.dto.ContactDto;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
@Tag(name = "client", description = "Client API")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final ContactMapper contactMapper;

    @GetMapping
    @Operation(summary = "Get all clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{clientId}")
    @Operation(summary = "Get client by id")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getClientById(clientId));
    }

    @GetMapping("/{clientId}/contacts")
    @Operation(summary = "Get all client contacts by id")
    public ResponseEntity<List<Contact>> getClientContacts(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.getClientContactsById(clientId));
    }

    @GetMapping("/{clientId}/contacts/{type}")
    @Operation(summary = "Get all client contacts by id and type[PHONE, EMAIL]")
    public ResponseEntity<List<Contact>> getClientContactsByType(
            @PathVariable Long clientId,
            @PathVariable String type
    ) {
        return ResponseEntity.ok(
                clientService.getClientContactsByIdAndType(
                        clientId,
                        type
                )
        );
    }

    @PostMapping
    @Operation(summary = "Add client")
    public ResponseEntity<Client> addClient(@RequestBody ClientDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientService.addClient(clientMapper.toEntity(dto))
        );
    }

    @PostMapping("/{clientId}/contacts")
    @Operation(summary = "Add contact")
    public ResponseEntity<Contact> addContact(
            @PathVariable Long clientId,
            @RequestBody ContactDto contact
    ) {
        return ResponseEntity.ok(
                clientService.addContactByClientId(
                        clientId,
                        contactMapper.toEntity(contact)
                )
        );
    }


}
