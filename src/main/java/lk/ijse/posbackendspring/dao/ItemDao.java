package lk.ijse.posbackendspring.dao;

import lk.ijse.posbackendspring.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   //manage the persistence logic, allows for exception handling, and makes the class eligible for dependency injection.
public interface ItemDao extends JpaRepository<ItemEntity,String> {
}
