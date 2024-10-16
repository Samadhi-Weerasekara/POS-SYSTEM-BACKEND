package lk.ijse.posbackendspring.controller;

import lk.ijse.posbackendspring.customObj.ItemResponse;
import lk.ijse.posbackendspring.dto.ItemDTO;
import lk.ijse.posbackendspring.exception.DataPersistFailedException;
import lk.ijse.posbackendspring.exception.ItemNotFoundException;
import lk.ijse.posbackendspring.service.ItemService;
import lk.ijse.posbackendspring.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private final ItemService itemService;

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveItem(
            @RequestPart("itemImage") MultipartFile itemImage,
            @RequestPart("itemName") String itemName,
            @RequestPart("itemQtyOnHand") int itemQtyOnHand,
            @RequestPart("unitPrice") double unitPrice)
            {
        try {

            byte[] imageBytes = itemImage.getBytes();
            String base64Image = AppUtil.toBase64ProfilePic(imageBytes);

            // Build the DTO and send to the service
            ItemDTO itemDTO = new ItemDTO();
            itemDTO.setItemImage(base64Image);
            itemDTO.setItemName(itemName);
            itemDTO.setItemQty(itemQtyOnHand);
            itemDTO.setUnitPrice(unitPrice);


            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable("id") String id){
        try {
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ItemNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getSelectedItem(@PathVariable("id") String id){
        return itemService.getSelectedItem(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateItem(@PathVariable("itemCode") String itemCode,
                                           @RequestPart("itemName") String updatedItemName,
                                           @RequestPart("itemQtyOnHand") int updatedItemQtyOnHand,
                                           @RequestPart("unitPrice") double updatedUnitPrice,
                                           @RequestPart("itemImage") MultipartFile updatedItemImage)
    {
        try {
            byte[] imageByteCollection=updatedItemImage.getBytes();
            String updateItemImage2 = AppUtil.toBase64ProfilePic(imageByteCollection);
            var updateItem = new ItemDTO();
            updateItem.setItemCode(itemCode);
            updateItem.setItemName(updatedItemName);
            updateItem.setItemQty(updatedItemQtyOnHand);
            updateItem.setUnitPrice(updatedUnitPrice);
            updateItem.setItemImage(updateItemImage2);
            itemService.updateItem(updateItem);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
