package lk.ijse.posbackendspring.dao;

import lk.ijse.posbackendspring.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailEntity,String> {
}
