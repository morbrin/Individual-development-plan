package org.example.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    Long id;
    String name;
    UUID uuid;
    List<AttributeDto> attributes;
}
