package qreol.project.crm.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ContactDto {

    @Schema(description = "Contact type", example = "EMAIL")
    private String type;

    @Schema(description = "Contact value", example = "stim@gmail.com")
    private String value;

}
