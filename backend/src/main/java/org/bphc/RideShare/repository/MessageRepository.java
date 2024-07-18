package org.bphc.RideShare.repository;

import org.bphc.RideShare.entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages,Long> {
    @Query(value = "select message from Messages m where m.ride_id=?1",nativeQuery = true)
    public List<String> getMessagesByRide(Long id);
}
