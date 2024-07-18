package org.bphc.RideShare.repository;

import org.bphc.RideShare.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query(value = "select * from Users u where u.phone_no=?1 AND u.password=?2",nativeQuery = true)
    public Users findByUserName(String phoneNo,String password);

    @Query(value = "select * from Users u where u.id=?1",nativeQuery = true)
    public Users findByUserId(Long id);
}
