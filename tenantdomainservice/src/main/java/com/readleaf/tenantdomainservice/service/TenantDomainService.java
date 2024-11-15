package com.readleaf.tenantdomainservice.service;

import com.readleaf.tenantdomainservice.dto.Tenant;
import com.readleaf.tenantdomainservice.exception.IdNotFoundException;


public interface TenantDomainService {
    Tenant saveOrUpdateTenant(Tenant tenant);
    String deleteTenant(Long phoneNumber) throws IdNotFoundException;
    Tenant getTenantDetailsById(Long phoneNumber) throws IdNotFoundException;
}