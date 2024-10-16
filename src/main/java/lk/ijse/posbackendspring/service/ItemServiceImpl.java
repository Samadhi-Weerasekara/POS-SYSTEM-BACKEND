package lk.ijse.posbackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendspring.customObj.ItemErrorResponse;
import lk.ijse.posbackendspring.customObj.ItemResponse;
import lk.ijse.posbackendspring.dao.ItemDao;
import lk.ijse.posbackendspring.dto.ItemDTO;
import lk.ijse.posbackendspring.entity.ItemEntity;
import lk.ijse.posbackendspring.exception.DataPersistFailedException;
import lk.ijse.posbackendspring.exception.ItemNotFoundException;
import lk.ijse.posbackendspring.util.AppUtil;
import lk.ijse.posbackendspring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemDao itemDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        //send data to the dao layer
        itemDTO.setItemCode(AppUtil.createItemId());
        ItemEntity savedItem = itemDao.save(mapping.convertToEntity(itemDTO));
        if(savedItem == null && savedItem.getItemCode() == null ) {
            throw new DataPersistFailedException("Cannot data saved");
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        //optional=>nullpoint exception handle kranna
        Optional<ItemEntity> tmpItem = itemDao.findById(itemDTO.getItemCode());
        if (!tmpItem.isPresent()) {
            throw new ItemNotFoundException("Item not Found");
        }else{
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setItemQtyOnHand(itemDTO.getItemQty());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
            tmpItem.get().setItemImage(itemDTO.getItemImage());
        }
    }
    @Override
    public void deleteItem(String id) {
        Optional<ItemEntity> selectedItemId = itemDao.findById(id);
        if (!selectedItemId.isPresent()) {
            throw new ItemNotFoundException("Item not Found");
        }else {
            itemDao.deleteById(id);
        }

    }

    @Override
    public ItemResponse getSelectedItem(String id) {
        if (itemDao.existsById(id)) {
            ItemEntity itemEntitybyItemId = itemDao.getItemEntityByItemCode(id);
            return mapping.convertToDTO(itemEntitybyItemId);
        }else {
            return new ItemErrorResponse(0,"Item not Found");
        }

    }


    @Override
    public List<ItemDTO> getAllItems() {
//        List<UserEntity> all = userDao.findAll();
//        return mapping.convertUserToDTO(all);

        return mapping.convertItemToDTOList(itemDao.findAll());
    }
}
