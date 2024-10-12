package lk.ijse.posbackendspring.service;

import lk.ijse.posbackendspring.customObj.CustomerResponse;
import lk.ijse.posbackendspring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerResponse getSelectedCustomer(String id);

    void updateCustomer(String id, CustomerDTO customerDTO);

    void deleteCustomer(String id);
}
