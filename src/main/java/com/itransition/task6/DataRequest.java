package com.itransition.task6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Abdulqodir Ganiev 6/10/2022 1:27 AM
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataRequest {
    private String country;
    private String error;
    private String seed;
    private String dataLength;
}
