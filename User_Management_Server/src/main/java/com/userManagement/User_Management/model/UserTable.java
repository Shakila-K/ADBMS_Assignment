package com.userManagement.User_Management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "user_table")
public class UserTable {

    @Id
    @Column (length = 5)
    private Long userID;

    @Column (length = 20)
    private String userName;

    @Column
    private String fullName;

    @Column (length = 12)
    private String nicNumber;

    private String address;

    @Column (length = 10)
    private String mobile;

}
