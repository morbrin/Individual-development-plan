package org.example.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeEntity {
    Integer id;
    UUID uuid;
    String name;
    String attributes;
}
