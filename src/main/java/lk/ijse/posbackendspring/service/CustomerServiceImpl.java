package lk.ijse.posbackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.posbackendspring.customObj.CustomerErrorResponse;
import lk.ijse.posbackendspring.customObj.CustomerResponse;
import lk.ijse.posbackendspring.dao.CustomerDao;
import lk.ijse.posbackendspring.dto.CustomerDTO;
import lk.ijse.posbackendspring.entity.CustomerEntity;
import lk.ijse.posbackendspring.exception.CustomerNotFoundException;
import lk.ijse.posbackendspring.exception.DataPersistFailedException;
import lk.ijse.posbackendspring.util.AppUtil;
import lk.ijse.posbackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private Mapping mapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setCustomerId(AppUtil.createCustomerId());
        CustomerEntity save = customerDao.save(mapping.convertCustomerDTOToCustomerEntity(customerDTO));
        if (save == null){
            throw new DataPersistFailedException("cannot save customer");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertCustomerEntityListToCustomerDTOList(customerDao.findAll());
    }

    @Override
    public CustomerResponse getSelectedCustomer(String id) {
        if (customerDao.existsById(id)) {
            return mapping.convertToDTO(customerDao.getReferenceById(id));
        }else {
            return new CustomerErrorResponse(0,"Customer not found");
        }
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmp = customerDao.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            tmp.get().setCustomerName(customerDTO.getCustomerName());
            tmp.get().setCustomerAddress(customerDTO.getCustomerAddress());
            tmp.get().setContactNumber(customerDTO.getContactNumber());
        }

    }

    @Override
    public void deleteCustomer(String id) {
        Optional<CustomerEntity> tmp = customerDao.findById(id);
        if (!tmp.isPresent()) {
            throw new CustomerNotFoundException("Customer not found");
        }else {
            customerDao.deleteById(id);
        }
    }
}
