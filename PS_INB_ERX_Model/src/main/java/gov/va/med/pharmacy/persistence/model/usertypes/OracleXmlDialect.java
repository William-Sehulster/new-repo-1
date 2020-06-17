package gov.va.med.pharmacy.persistence.model.usertypes;

import org.hibernate.dialect.Oracle10gDialect;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.service.ServiceRegistry;

import oracle.xdb.XMLType;

public class OracleXmlDialect extends Oracle10gDialect {

	
    public OracleXmlDialect() {
        registerColumnType(XMLType._SQL_TYPECODE, "XMLTYPE");
    }

    @Override
    public void contributeTypes(final TypeContributions typeContributions,
                                final ServiceRegistry serviceRegistry) {
        super.contributeTypes(typeContributions, serviceRegistry);
        registerTypes(typeContributions);
    }

    private void registerTypes(final TypeContributions typeContributions) {
        typeContributions.contributeType(new InboundNcpdpMsgUserType(), new String[]{"InboundNcpdpMsg"});
        typeContributions.contributeType(new OutboundNcpdpMsgUserType(), new String[]{"OutboundNcpdpMsg"});
    }
    
    

}
