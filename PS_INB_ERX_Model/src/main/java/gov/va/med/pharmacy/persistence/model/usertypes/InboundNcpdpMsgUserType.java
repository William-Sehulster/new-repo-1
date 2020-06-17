package gov.va.med.pharmacy.persistence.model.usertypes;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;
import org.w3c.dom.Document;

import gov.va.med.pharmacy.persistence.model.InboundNcpdpMsg;
import oracle.xdb.XMLType;


public class InboundNcpdpMsgUserType implements UserType {

	
  /*  private static JAXBContext jaxbContext;

    {
        try {
            jaxbContext = JAXBContext.newInstance(InboundNcpdpMsg.class);
        } catch (Exception e){
            throw new RuntimeException("Cannot initialize JAXBContext", e);
        }
    }*/

    @Override
    public int[] sqlTypes() {
        return new int[]{XMLType._SQL_TYPECODE};
    }

    @Override
    public Class returnedClass() {
        return InboundNcpdpMsg.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
    	
    	return (x != null) && x.equals(y);   	
        
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
    	
    	return (x != null) ? x.hashCode() : 0;
        
    }

    @Override
    public Object nullSafeGet(ResultSet resultSet,
            String[] names,
            SharedSessionContractImplementor session,
            Object owner) throws HibernateException,SQLException {
        XMLType xmlType = (XMLType) resultSet.getObject(names[0]);

        String returnValue = null;
        
        if (xmlType != null) {
            try {
            	returnValue = xmlType.getStringVal();
            } catch (Exception e) {
                throw new SQLException("Exception while converting InboundNcpdpMsg to string", e);
            }
            finally{
            	
            }
        }

        return returnValue;
    }

    @Override
    public void nullSafeSet(PreparedStatement statement,
            Object value,
            int index,
            SharedSessionContractImplementor session) throws HibernateException,SQLException {
        try {
            XMLType xmlType = null;
            if (value != null) {
                NativeJdbcExtractor extractor = new OracleJdbc4NativeJdbcExtractor();
                Connection connection = extractor.getNativeConnection(statement.getConnection());

            	xmlType = XMLType.createXML(connection, (String)value);
            }

          
            statement.setObject(index, xmlType);
        } catch (Exception e) {
            throw new SQLException("Could not convert String to XML for storage", e);
        }
    }

    @Override
    public Object deepCopy(Object value)  {
        return value;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) {
        return (Serializable) value;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) {
        return cached;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) {
        return original;
    }

   /* protected String jaxbToString(final Object value) throws JAXBException {
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(JAXB_ENCODING, UTF_8.name());

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(value, stringWriter);

        return stringWriter.toString();
    }
    */
    
}
