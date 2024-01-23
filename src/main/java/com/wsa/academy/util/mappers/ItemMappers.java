package com.wsa.academy.util.mappers;

import com.wsa.academy.dto.paginated.PaginatedGetAllItemDto;
import com.wsa.academy.dto.request.ItemSaveRequestDTO;
import com.wsa.academy.dto.response.ItemGetResponseDTO;
import com.wsa.academy.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMappers {
    //where we want to put is leftside---------------the object data available is in right side
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);
    Item dtoToEntity (ItemSaveRequestDTO itemSaveRequestDTO);
    List<ItemGetResponseDTO>ListDtoToPage( Page<Item> items);
}
