package com.readleaf.tenantdomainservice.repository;

import com.readleaf.tenantdomainservice.dto.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {

}
