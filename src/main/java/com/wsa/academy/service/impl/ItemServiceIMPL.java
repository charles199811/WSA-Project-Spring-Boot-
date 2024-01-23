package com.wsa.academy.service.impl;

import com.wsa.academy.dto.paginated.PaginatedGetAllItemDto;
import com.wsa.academy.dto.request.ItemSaveRequestDTO;
import com.wsa.academy.dto.response.ItemGetResponseDTO;
import com.wsa.academy.entity.Item;
import com.wsa.academy.exception.NotFoundException;
import com.wsa.academy.repo.ItemRepo;
import com.wsa.academy.service.ItemService;
import com.wsa.academy.util.mappers.ItemMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ItemMappers itemMappers;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
            /*In here we use model mapper to save data withot getting
          data one by one.*/
//        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        Item item = itemMappers.dtoToEntity(itemSaveRequestDTO);
        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return item.getItemName() + " saved";
        } else {
            throw new DuplicateKeyException("Already added");
        }
    }

    // 6 - 01.32.58
    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        boolean b = true;
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName, b);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMappers.entityListToDtoList(items);
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException(" No Item Found");
        }

    }


    @Override
    public List<ItemGetResponseDTO> getItemsByActiveState(boolean activeState) {
        List<Item> items = itemRepo.findAllItemsByActiveEquals(activeState);
        if (items.size() > 0) {
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMappers.entityListToDtoList(items);
            return itemGetResponseDTOS;
        } else {
            throw new NotFoundException("No Item Found");
        }

    }

    @Override
    public PaginatedGetAllItemDto getItemByActiveStateWithPaginated(boolean activeState, int page, int size) {
        Page<Item> items = itemRepo.findAllItemsByActiveEquals(activeState, PageRequest.of(page, size));
        if (items.getSize() < 1) {
            throw new NotFoundException("Item Not Found");
        }
        PaginatedGetAllItemDto paginatedGetAllItemDto = new PaginatedGetAllItemDto(
                itemMappers.ListDtoToPage(items),
                2
        );
        return  paginatedGetAllItemDto;
    }

}
