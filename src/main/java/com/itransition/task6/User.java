package com.itransition.task6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abdulqodir Ganiev 6/9/2022 3:16 PM
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer id;

    private String fullName;

    private String fullAddress;

    private String phoneNumber;

    private int sequenceNumber;

}
