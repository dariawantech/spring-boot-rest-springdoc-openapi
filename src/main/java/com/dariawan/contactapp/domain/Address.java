package com.dariawan.contactapp.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address implements Serializable {

    @Schema(description = "Address line 1 of the contact.", 
            example = "888 Constantine Ave, #54", required = false)
    @Size(max = 50)
    private String address1;
    
    @Schema(description = "Address line 2 of the contact.", 
            example = "San Angeles", required = false)
    @Size(max = 50)
    private String address2;
    
    @Schema(description = "Address line 3 of the contact.", 
            example = "Florida", required = false)
    @Size(max = 50)
    private String address3;
    
    @Schema(description = "Postal code of the contact.", 
            example = "32106", required = false)
    @Size(max = 20)
    private String postalCode;    
}
