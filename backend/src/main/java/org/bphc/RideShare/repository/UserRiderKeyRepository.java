package org.bphc.RideShare.repository;

import org.bphc.RideShare.entity.UserRideKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRiderKeyRepository extends JpaRepository<UserRideKey,Long> {
    @Query(value = "select * from UserRideKey urk where urk.user_id=?1",nativeQuery = true)
    public List<UserRideKey> getRidesByUser(Long userId);

    @Query(value = "select count(*) from UserRideKey urk where urk.user_id=?1 AND urk.ride_id=?2",nativeQuery = true)
    public Long checkIfUserIsInRide(Long userId,Long rideId);
}
