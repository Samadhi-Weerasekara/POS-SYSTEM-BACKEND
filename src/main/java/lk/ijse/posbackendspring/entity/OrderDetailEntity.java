package lk.ijse.posbackendspring.entity;

import jakarta.persistence.*;
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
    private String orderId;
    private String itemName;
    private int qty;
    private double unitPrice;
    private double total;



}
