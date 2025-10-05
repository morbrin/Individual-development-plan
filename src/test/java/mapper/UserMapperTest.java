package mapper;

import org.example.dto.AttributeDto;
import org.example.dto.UserDto;
import org.example.entity.AttributeEntity;
import org.example.entity.UserEntity;
import org.example.mapper.UserMapper;
import org.example.mapper.UserMapperImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test UserMapper")
public class UserMapperTest {

    private static final Long DUMMY_USER_ID = new Random().nextLong();
    private static final String DUMMY_USER_NAME = "name";
    private static final Integer DUMMY_ATTRIBUTE_ID = new Random().nextInt();
    private static final UUID DUMMY_UUID = UUID.randomUUID();
    private static final String DUMMY_ATTRIBUTE_NAME = "attributeName";
    private static final String DUMMY_ATTRIBUTE_VALUE = "value";

    private static final AttributeEntity DUMMY_ATTRIBUTE_ENTITY = AttributeEntity.builder()
            .id(DUMMY_ATTRIBUTE_ID)
            .uuid(DUMMY_UUID)
            .name(DUMMY_ATTRIBUTE_NAME)
            .attributes(DUMMY_ATTRIBUTE_VALUE)
            .build();

    private static final UserEntity DUMMY_USER_ENTITY = UserEntity.builder()
            .id(DUMMY_USER_ID)
            .name(DUMMY_USER_NAME)
            .uuid(DUMMY_UUID)
            .attributes(List.of(DUMMY_ATTRIBUTE_ENTITY))
            .build();

    private static final AttributeDto DUMMY_ATTRIBUTE_DTO = AttributeDto.builder()
            .id(DUMMY_ATTRIBUTE_ID)
            .uuid(DUMMY_UUID)
            .name(DUMMY_ATTRIBUTE_NAME)
            .attributes(DUMMY_ATTRIBUTE_VALUE)
            .build();

    private static final UserDto DUMMY_USER_DTO = UserDto.builder()
            .id(DUMMY_USER_ID)
            .name(DUMMY_USER_NAME)
            .uuid(DUMMY_UUID)
            .build();

    UserMapper userMapper = new UserMapperImpl();

    @Test
    void toDtoSuccess() {
        UserDto dto = userMapper.toDto(DUMMY_USER_ENTITY);

        assertNotNull(dto);
        assertEquals(DUMMY_USER_ID, dto.getId());
        assertEquals(DUMMY_USER_NAME, dto.getName());
        assertEquals(DUMMY_UUID, dto.getUuid());
        assertNotNull(dto.getAttributes());
        assertEquals(1, dto.getAttributes().size());
        assertEquals(DUMMY_ATTRIBUTE_NAME, dto.getAttributes().getFirst().getName());
        assertEquals(DUMMY_ATTRIBUTE_VALUE, dto.getAttributes().getFirst().getAttributes());
    }

    @Test
    void toEntitySuccess() {
        UserEntity entity = userMapper.toEntity(DUMMY_USER_DTO);

        assertNotNull(entity);
        assertEquals(DUMMY_USER_ID, entity.getId());
        assertEquals(DUMMY_UUID, entity.getUuid());
        assertEquals(DUMMY_USER_NAME, entity.getName());
        assertNull(entity.getAttributes());
    }

    @Test
    void toEntityAttributeSuccess() {
        AttributeEntity entity = userMapper.toEntity(DUMMY_ATTRIBUTE_DTO);

        assertNotNull(entity);
        assertEquals(DUMMY_UUID, entity.getUuid());
        assertEquals(DUMMY_ATTRIBUTE_ID, entity.getId());
        assertEquals(DUMMY_ATTRIBUTE_NAME, entity.getName());
        assertEquals(DUMMY_ATTRIBUTE_VALUE, entity.getAttributes());
    }

    @Test
    void toDtoAttributeSuccess() {
        AttributeDto dto = userMapper.toDto(DUMMY_ATTRIBUTE_ENTITY);

        assertNotNull(dto);
        assertEquals(DUMMY_UUID, dto.getUuid());
        assertEquals(DUMMY_ATTRIBUTE_ID, dto.getId());
        assertEquals(DUMMY_ATTRIBUTE_NAME, dto.getName());
        assertEquals(DUMMY_ATTRIBUTE_VALUE, dto.getAttributes());
    }
}
