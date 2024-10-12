package lk.ijse.posbackendspring.dao;

import lk.ijse.posbackendspring.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity,String> {
}
