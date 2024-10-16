package lk.ijse.posbackendspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity {

    @Id
    @Column(name = "itemCode", nullable = false, length = 255)
    private String itemCode;

    @Column(columnDefinition = "LONGTEXT")
    private String itemImage;

    @Column(name = "itemName", nullable = false, length = 255)
    private String itemName;

    @Column(name = "itemQtyOnHand", nullable = false)
    private int itemQtyOnHand;

    @Column(name = "unitPrice", nullable = false)
    private double unitPrice;
}
