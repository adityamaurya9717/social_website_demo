package com.management.jpa.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_address")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fk_user_id",unique = true,nullable = false)
    String userId;

    @Column(name="address")
    String address;

    @Column(name = "state")
    String state;

    @Column(name = "country")
    String country;

    @Column(name="country_code")
    Integer countryCode;


}
