package org.bphc.RideShare.repository;

import org.bphc.RideShare.dto.user.DriverSignInDto;
import org.bphc.RideShare.entity.Drivers;
import org.bphc.RideShare.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriversRepository extends JpaRepository<Drivers,Long> {
    @Query(value = "select * from drivers u where u.phone_no=?1 AND u.password=?2",nativeQuery = true)
    public Drivers findByUserName(String phoneNo, String password);

    @Query(value = "select * from drivers d where d.id=?1",nativeQuery = true)
    public Drivers findByDriverId(Long id);
}
