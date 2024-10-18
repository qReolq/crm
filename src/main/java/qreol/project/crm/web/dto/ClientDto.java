package qreol.project.crm.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ClientDto {


    @Schema(description = "Client name", example = "John Doe")
    private String name;

}
