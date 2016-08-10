package org.wso2.intcloud.tenant.initializer.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub;

public class TenantInitializerDataHolder {

    private static final Log log = LogFactory.getLog(TenantInitializerDataHolder.class);
    private static TenantInitializerDataHolder dataHolder = new TenantInitializerDataHolder();
    private static TenantMgtAdminServiceStub tenantMgtAdminServiceStub;

    public static TenantInitializerDataHolder getInstance() {
        return dataHolder;
    }

    private TenantInitializerDataHolder() {
    }

    public void setTenantMgtAdminServiceStub(TenantMgtAdminServiceStub tenantMgtAdminServiceStub) {
          this.tenantMgtAdminServiceStub = tenantMgtAdminServiceStub;
    }

    public TenantMgtAdminServiceStub getTenantMgtAdminServiceStub() {
        return tenantMgtAdminServiceStub;
    }
}
