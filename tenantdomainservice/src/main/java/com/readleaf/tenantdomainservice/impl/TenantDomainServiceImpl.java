package com.readleaf.tenantdomainservice.impl;

import com.readleaf.tenantdomainservice.constants.TenantConstants;
import com.readleaf.tenantdomainservice.dto.Tenant;
import com.readleaf.tenantdomainservice.exception.IdNotFoundException;
import com.readleaf.tenantdomainservice.repository.TenantRepository;
import com.readleaf.tenantdomainservice.service.TenantDomainService;
import com.readleaf.tenantdomainservice.util.TenantDomainServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenantDomainServiceImpl implements TenantDomainService {

    @Autowired
    TenantRepository tenantRepository;

    @Autowired
    TenantDomainServiceUtil tenantDomainServiceUtil;

    @Override
    public Tenant saveOrUpdateTenant(Tenant tenant) {

        return tenantRepository.saveAndFlush(tenant);
    }

    @Override
    public String deleteTenant(Long phoneNumber) throws IdNotFoundException {
        if (tenantDomainServiceUtil.checkIdisPresent(phoneNumber)) {
            tenantRepository.deleteById(phoneNumber);
        } else {
            throw new IdNotFoundException(TenantConstants.ID_NOTFOUND);
        }
        return TenantConstants.SUCCESS_DELETEMSG;
    }

    @Override
    public Tenant getTenantDetailsById(Long phoneNumber) throws IdNotFoundException {
        if (tenantDomainServiceUtil.checkIdisPresent(phoneNumber)) {
            return tenantRepository.getReferenceById(phoneNumber);
        } else {
            throw new IdNotFoundException(TenantConstants.ID_NOTFOUND);
        }
    }
}
