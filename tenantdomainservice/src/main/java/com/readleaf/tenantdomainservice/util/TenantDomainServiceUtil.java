package com.readleaf.tenantdomainservice.util;

import com.readleaf.tenantdomainservice.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantDomainServiceUtil {

    @Autowired
    TenantRepository tenantRepository;

    public boolean checkIdisPresent(Long id){
        return tenantRepository.findById(id).isPresent();
    }
}
