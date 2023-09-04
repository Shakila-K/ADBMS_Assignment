package com.userManagement.User_Management.repository;

import com.userManagement.User_Management.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTable, Long> {
}
