package org.bphc.RideShare.repository;

import org.bphc.RideShare.dto.ride.SearchRideDto;
import org.bphc.RideShare.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride,Long> {
    @Query(value = "select * from ride r where r.id=?1",nativeQuery = true)
    public Ride getRideById(Long id);

    @Query(value = "select id from ride",nativeQuery = true)
    public List<Long> getAllRides();

    @Query(value = "select id from ride r where r.driver_id=?1",nativeQuery = true)
    public List<Long> getRidesByDriverId(Long id);

    @Query(value = "select id from ride r where r.source LIKE %?1% AND r.destination like %?2% AND r.date like %?3%",nativeQuery = true)
    public List<Long> getRidesBySearch(String source,String destination,String date);
}
