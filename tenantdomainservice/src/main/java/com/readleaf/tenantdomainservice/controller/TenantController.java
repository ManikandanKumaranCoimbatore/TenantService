package com.readleaf.tenantdomainservice.controller;

import com.readleaf.tenantdomainservice.dto.Tenant;
import com.readleaf.tenantdomainservice.exception.IdNotFoundException;
import com.readleaf.tenantdomainservice.service.TenantDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/domain")
public class TenantController {

    @Autowired
    TenantDomainService tenantDomainService;

    @PutMapping("/addtenant")
    public ResponseEntity<Tenant> addtenant(@RequestPart Tenant tenant,@RequestPart MultipartFile brandLogo) throws IOException {
        tenant.setBrandLogo(brandLogo.getBytes());
        tenantDomainService.saveOrUpdateTenant(tenant);
        return ResponseEntity.ok().body(tenant);
    }

    @PostMapping("/updatetenant")
    public ResponseEntity<Tenant> updatetenant(@RequestPart Tenant tenant,@RequestPart MultipartFile brandLogo) throws  IOException {
        tenant.setBrandLogo(brandLogo.getBytes());
        tenantDomainService.saveOrUpdateTenant(tenant);
        return ResponseEntity.ok().body(tenant);
    }

    @DeleteMapping("/removetenant/{phoneNumber}")
    public ResponseEntity<String> removetenant(@PathVariable Long phoneNumber) throws IdNotFoundException {
        return ResponseEntity.ok().body(tenantDomainService.deleteTenant(phoneNumber));
    }

    @GetMapping("/tenantdetails/{phoneNumber}")
    public ResponseEntity<Tenant> tenantdetails(@PathVariable Long phoneNumber) throws IdNotFoundException {
        return ResponseEntity.ok().body(tenantDomainService.getTenantDetailsById(phoneNumber));
    }


}
