package org.wso2.intcloud.tenant.initializer.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceExceptionException;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;

import java.rmi.RemoteException;

/**
 * @scr.component name="tenant.initializer.component" immediate="true"
 * @scr.reference name="tenant.mgt.component"
 * interface="org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub"
 * cardinality="1..1" policy="dynamic" bind="setTenantMgtAdminService"
 * unbind="unsetTenantMgtAdminService"
 */

public class TenantInitializerComponent {

    private static final Log log = LogFactory.getLog(TenantInitializerComponent.class);

    protected void activate(ComponentContext ctx) throws RemoteException, TenantMgtAdminServiceExceptionException {
        if (log.isDebugEnabled()) {
            log.debug("Starting TenantInitializerComponent");
        }
        log.info("********************Starting TenantInitializerComponent");

        TenantMgtAdminServiceStub tenantMgtAdminServiceStub =
                TenantInitializerDataHolder.getInstance().getTenantMgtAdminServiceStub();

        TenantInfoBean tenantInfoBean = new TenantInfoBean();
        tenantInfoBean.setActive(false);
        tenantInfoBean.setAdmin("admin");
        tenantInfoBean.setAdminPassword("admin123");
        tenantInfoBean.setFirstname("Maheeka");
        tenantInfoBean.setEmail("admin@maheeka.com");
        tenantInfoBean.setTenantDomain("maheeka.com");
        tenantInfoBean.setTenantId(250);
        tenantInfoBean.setUsagePlan("Demo");
        tenantMgtAdminServiceStub.addTenant(tenantInfoBean);

    }

    protected void setTenantMgtAdminService(TenantMgtAdminServiceStub tenantMgtAdminServiceStub) {
        TenantInitializerDataHolder.getInstance().setTenantMgtAdminServiceStub(tenantMgtAdminServiceStub);

    }

    protected void unsetTenantMgtAdminService(TenantMgtAdminServiceStub tenantMgtAdminServiceStub) {
        TenantInitializerDataHolder.getInstance().setTenantMgtAdminServiceStub(null);
    }

}


