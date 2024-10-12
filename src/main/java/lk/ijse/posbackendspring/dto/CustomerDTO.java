package lk.ijse.posbackendspring.dto;

import lk.ijse.posbackendspring.customObj.CustomerResponse;
import lk.ijse.posbackendspring.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO  implements SuperDTO, CustomerResponse {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerSalary;
}
