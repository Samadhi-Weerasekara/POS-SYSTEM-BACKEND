package lk.ijse.posbackendspring.dao;

import lk.ijse.posbackendspring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity,String> {
}
