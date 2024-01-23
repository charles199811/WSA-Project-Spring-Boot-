package com.wsa.academy.service;

import com.wsa.academy.dto.paginated.PaginatedGetAllItemDto;
import com.wsa.academy.dto.request.ItemSaveRequestDTO;
import com.wsa.academy.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {

    String saveItem(ItemSaveRequestDTO itemSaveRequestDTO);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemsByActiveState(boolean activeState);

    PaginatedGetAllItemDto getItemByActiveStateWithPaginated(boolean activeState, int page, int size);
}
