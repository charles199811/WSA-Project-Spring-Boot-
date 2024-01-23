package com.wsa.academy.dto.paginated;

import com.wsa.academy.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedGetAllItemDto {
    List<ItemGetResponseDTO> List;
    private long dataCount;
}
