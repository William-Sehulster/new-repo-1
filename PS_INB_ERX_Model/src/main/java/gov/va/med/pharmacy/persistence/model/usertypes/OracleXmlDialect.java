package gov.va.med.pharmacy.persistence.model.usertypes;

import org.hibernate.dialect.Oracle12cDialect;

import java.sql.Types;

import org.hibernate.boot.model.TypeContributions;
import org.hibernate.service.ServiceRegistry;

//import oracle.xdb.XMLType;

public class OracleXmlDialect extends Oracle12cDialect {

	
    public OracleXmlDialect() {
        registerColumnType(Types.SQLXML, "XMLTYPE");
    }

	
	  @Override public void contributeTypes(final TypeContributions
	  typeContributions, final ServiceRegistry serviceRegistry) {
	  super.contributeTypes(typeContributions, serviceRegistry);
	  registerTypes(typeContributions); }
	 

	
	  private void registerTypes(final TypeContributions typeContributions) {
	  //typeContributions.contributeType(type, keys);
	  
	  typeContributions.contributeType(new InboundNcpdpMsgUserType(), new String[]{"InboundNcpdpMsg"});
      typeContributions.contributeType(new OutboundNcpdpMsgUserType(), new String[]{"OutboundNcpdpMsg"});
      
	  }
	 
    
    

}
