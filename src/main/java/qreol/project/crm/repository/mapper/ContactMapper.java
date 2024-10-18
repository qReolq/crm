package qreol.project.crm.repository.mapper;

import org.springframework.stereotype.Component;
import qreol.project.crm.model.Contact;
import qreol.project.crm.model.ContactType;
import qreol.project.crm.model.exception.ResourceNotFoundException;
import qreol.project.crm.web.dto.ContactDto;

@Component
public class ContactMapper {

    public Contact toEntity(ContactDto dto) {
        return new Contact(getContactType(dto.getType()), dto.getValue());
    }

    // Duplicate in [/service/impl/ClientServiceImpl] 65
    private ContactType getContactType(String type) {
        try {
            return ContactType.valueOf(type);
        } catch (IllegalArgumentException e){
            throw new ResourceNotFoundException("Contact type is not found");
        }
    }

}
