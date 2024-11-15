package com.readleaf.tenantdomainservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "floor_details")
public class Floor {

    @Id
    private String shopNumber;
    @Column
    private String floorName;
    @Column
    private String carpetArea;
    @Column
    private String landArea;

}
