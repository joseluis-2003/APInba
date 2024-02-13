package com.joseluisgonzalezalamo.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PlayerDTO {
    public String name;
    public String position;
    public String clubName;
}
