package lk.ijse.posbackendspring.service;

import lk.ijse.posbackendspring.customObj.ItemResponse;
import lk.ijse.posbackendspring.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);

    void updateItem(ItemDTO itemDTO);

    void deleteItem(String id);

    ItemResponse getSelectedItem(String id);

    List<ItemDTO> getAllItems();
}
