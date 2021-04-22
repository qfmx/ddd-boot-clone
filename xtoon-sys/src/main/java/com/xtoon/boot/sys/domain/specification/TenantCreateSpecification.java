package com.xtoon.boot.sys.domain.specification;

import com.xtoon.boot.common.domain.AbstractSpecification;
import com.xtoon.boot.sys.domain.model.Tenant;
import com.xtoon.boot.sys.domain.repository.TenantRepository;

/**
 * 租户创建Specification
 *
 * @author haoxin
 * @date 2021-03-29
 **/
public class TenantCreateSpecification extends AbstractSpecification<Tenant> {

    private TenantRepository tenantRepository;

    public TenantCreateSpecification(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public boolean isSatisfiedBy(Tenant tenant) {
        if(tenantRepository.find(tenant.getTenantName()) != null) {
            throw new IllegalArgumentException("租户名称已存在");
        }
        if(tenantRepository.find(tenant.getTenantCode()) != null) {
            throw new IllegalArgumentException("租户编码已存在");
        }
        return true;
    }
}