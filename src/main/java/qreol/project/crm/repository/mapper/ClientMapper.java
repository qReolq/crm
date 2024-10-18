package qreol.project.crm.repository.mapper;

import org.springframework.stereotype.Component;
import qreol.project.crm.model.Client;
import qreol.project.crm.web.dto.ClientDto;

@Component
public class ClientMapper {

    public Client toEntity(ClientDto dto) {
        return new Client(dto.getName());
    }

}
