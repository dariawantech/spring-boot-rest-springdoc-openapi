/**
 * Documenting Spring Boot REST API with SpringDoc + OpenAPI 3 (https://www.dariawan.com)
 * Copyright (C) 2019 Dariawan <hello@dariawan.com>
 *
 * Creative Commons Attribution-ShareAlike 4.0 International License
 *
 * Under this license, you are free to:
 * # Share - copy and redistribute the material in any medium or format
 * # Adapt - remix, transform, and build upon the material for any purpose,
 *   even commercially.
 *
 * The licensor cannot revoke these freedoms
 * as long as you follow the license terms.
 *
 * License terms:
 * # Attribution - You must give appropriate credit, provide a link to the
 *   license, and indicate if changes were made. You may do so in any
 *   reasonable manner, but not in any way that suggests the licensor
 *   endorses you or your use.
 * # ShareAlike - If you remix, transform, or build upon the material, you must
 *   distribute your contributions under the same license as the original.
 * # No additional restrictions - You may not apply legal terms or
 *   technological measures that legally restrict others from doing anything the
 *   license permits.
 *
 * Notices:
 * # You do not have to comply with the license for elements of the material in
 *   the public domain or where your use is permitted by an applicable exception
 *   or limitation.
 * # No warranties are given. The license may not give you all of
 *   the permissions necessary for your intended use. For example, other rights
 *   such as publicity, privacy, or moral rights may limit how you use
 *   the material.
 *
 * You may obtain a copy of the License at
 *   https://creativecommons.org/licenses/by-sa/4.0/
 *   https://creativecommons.org/licenses/by-sa/4.0/legalcode
 */
package com.dariawan.contactapp.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "contact")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Getter
@Setter
public class Contact implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @Schema(description = "Unique identifier of the Contact.", 
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Schema(description = "Name of the contact.", 
            example = "Jessica Abigail", required = true)
    @NotBlank
    @Size(max = 100)
    private String name;
    
    @Schema(description = "Phone number of the contact.", 
            example = "62482211", required = false)
    @Pattern(regexp ="^\\+?[0-9. ()-]{7,25}$", message = "Phone number")
    @Size(max = 25)
    private String phone;
    
    @Schema(description = "Email address of the contact.", 
            example = "jessica@ngilang.com", required = false)
    @Email(message = "Email Address")
    @Size(max = 100)
    private String email;
    
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
    
    @Schema(description = "Notes about the contact.", 
            example = "Meet her at Spring Boot Conference", required = false)
    @Column(length = 4000)
    private String note;    
}
