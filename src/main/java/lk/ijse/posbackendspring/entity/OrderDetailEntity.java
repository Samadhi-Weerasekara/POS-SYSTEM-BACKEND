package lk.ijse.posbackendspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_details")
@Entity
public class OrderDetailEntity implements Serializable {
    @Id
    private String itemId;
    private String itemName;
    private int itemQty;
    private double unitPrice;
    private String itemImage;
}
