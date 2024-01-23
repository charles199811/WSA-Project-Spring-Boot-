package com.wsa.academy.controller;

import com.wsa.academy.dto.paginated.PaginatedGetAllItemDto;
import com.wsa.academy.dto.request.ItemSaveRequestDTO;
import com.wsa.academy.dto.response.ItemGetResponseDTO;
import com.wsa.academy.service.ItemService;
import com.wsa.academy.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wsaItem")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveItem (ItemSaveRequestDTO itemSaveRequestDTO){
        String message = itemService.saveItem(itemSaveRequestDTO);

        //Standard Response part
        ResponseEntity<StandardResponse> sResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", message), HttpStatus.CREATED
        );
        return sResponse;
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndStatus (@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOs = itemService.getItemByNameAndStatus(itemName);
        ResponseEntity<StandardResponse> sResponse = new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", itemDTOs), HttpStatus.CREATED
        );
        return  sResponse;
    }

    @GetMapping(
            path = "/get-by-activeState-paginate",
            params = {"actvieState","page","size"}
    )
    public ResponseEntity<StandardResponse> getItemsByActiveState(
            @RequestParam (value = "actvieState") boolean activeState,
            @RequestParam (value = "page") int page,
            @RequestParam (value = "size") int size
    ){
        PaginatedGetAllItemDto paginatedGetAllItemDto = itemService.getItemByActiveStateWithPaginated(activeState,page,size);
        ResponseEntity<StandardResponse> sResponse =  new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", paginatedGetAllItemDto), HttpStatus.CREATED
        );
        return  sResponse;
    }
}

