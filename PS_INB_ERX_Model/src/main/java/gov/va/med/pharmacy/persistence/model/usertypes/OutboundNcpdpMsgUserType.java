package gov.va.med.pharmacy.persistence.model.usertypes;

import static java.nio.charset.StandardCharsets.UTF_8;
import static javax.xml.bind.Marshaller.JAXB_ENCODING;

import java.io.Serializable;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.jdbc.support.nativejdbc.NativeJdbcExtractor;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;

import gov.va.med.pharmacy.ncpdpmsgs.MessageType;
import oracle.xdb.XMLType;


public class OutboundNcpdpMsgUserType implements UserType {

	
    private static JAXBContext jaxbContext;

    {
        try {
            jaxbContext = JAXBContext.newInstance(MessageType.class);
        } catch (Exception e){
            throw new RuntimeException("Cannot initialize JAXBContext", e);
        }
    }

    @Override
    public int[] sqlTypes() {
        return new int[]{XMLType._SQL_TYPECODE};
    }

    @Override
    public Class returnedClass() {
        return MessageType.class;
    }

    @Override
    public boolean equals(Object x,  Object y) throws HibernateException {
    	return (x != null) && x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
    	return (x != null) ? x.hashCode() : 0;
    }

    @Override
    public Object nullSafeGet(final ResultSet resultSet,
            String[] names,
            SharedSessionContractImplementor session,
            Object owner) throws SQLException {
        XMLType xmlType = (XMLType) resultSet.getObject(names[0]);

        MessageType document = null;
        
        if (xmlType != null) {
            try {
            	
            	final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            	
            	document = unmarshaller.unmarshal(xmlType.getDocument(), MessageType.class).getValue();
            	
            } catch (JAXBException e) {
                throw new SQLException("Exception while unmarshalling OutboundNcpdpMsg", e);
            }
            finally{
            	
            }
        }

        return document;
    }

    @Override
    public void nullSafeSet(PreparedStatement statement,
            Object value,
            int index,
            SharedSessionContractImplementor session) throws SQLException {
        try {
            XMLType xmlType = null;
            if (value != null) {
                NativeJdbcExtractor extractor = new OracleJdbc4NativeJdbcExtractor();
                Connection connection = extractor.getNativeConnection(statement.getConnection());

            	xmlType = XMLType.createXML(connection, jaxbToString(value));
            }

          
            statement.setObject(index, xmlType);
        } catch (Exception e) {
            throw new SQLException("Could not marshal OutboundNcpdpMsg", e);
        }
    }

    @Override
    public Object deepCopy(Object value) {
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

    protected String jaxbToString(Object value) throws JAXBException {
        final Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(JAXB_ENCODING, UTF_8.name());

        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(value, stringWriter);

        return stringWriter.toString();
    }
    
    
}
