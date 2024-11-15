package com.readleaf.tenantdomainservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tenant_details")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tenant {

    @Id
    private String phone;
    @Column
    private String tenantName;
    @Lob
    private byte[] brandLogo;
    @Column
    private String category;
    @Column
    private String subCategory;
    @Column
    private String companyName;
    @Column
    private String contactName;
    @Column
    private boolean isActive=true;
    @Column
    private boolean isPopular;
    @Column
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_phone", referencedColumnName = "phone")
    private List<Floor> floor;

}
