package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.ItemResponse;
import lk.ijse.posbackendspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO, ItemResponse {
 private String itemCode;
 private String itemName;
 private int itemQty;
 private double unitPrice;
 private String itemImage;

}
