package org.example.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDto {
    Integer id;
    UUID uuid;
    String name;
    String attributes;
}
