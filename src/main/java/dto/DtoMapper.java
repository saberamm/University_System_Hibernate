package dto;

import entity.User;
import entity.dto.SimpleUser;

public interface DtoMapper {
    SimpleUser userDtoMapper(User user);
}
