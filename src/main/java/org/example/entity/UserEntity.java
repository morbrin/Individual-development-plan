package org.example.entity;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    Long id;
    String name;
    UUID uuid;
    List<AttributeEntity> attributes;
}
