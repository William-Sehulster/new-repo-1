/*
 *
 *  Spring jdbc extract which is removed from version 5.0.
 */

package gov.va.med.pharmacy.persistence.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A {@link Jdbc4NativeJdbcExtractor} which comes pre-configured for Oracle's JDBC driver,
 * specifying the following vendor-specific API types for unwrapping:
 * <ul>
 * <li>{@code oracle.jdbc.OracleConnection}
 * <li>{@code oracle.jdbc.OracleStatement}
 * <li>{@code oracle.jdbc.OraclePreparedStatement}
 * <li>{@code oracle.jdbc.OracleCallableStatement}
 * <li>{@code oracle.jdbc.OracleResultSet}
 * </ul>
 *
 * <p>Note: This will work with any JDBC 4.0 compliant connection pool, without a need for
 * connection pool specific setup. In other words, as of JDBC 4.0, NativeJdbcExtractors
 * will typically be implemented for specific drivers instead of for specific pools.
 *
 */
public class OracleJdbc4NativeJdbcExtractor extends Jdbc4NativeJdbcExtractor {

	@SuppressWarnings("unchecked")
	public OracleJdbc4NativeJdbcExtractor() {
		try {
			setConnectionType((Class<Connection>) getClass().getClassLoader().loadClass("oracle.jdbc.OracleConnection"));
			setStatementType((Class<Statement>) getClass().getClassLoader().loadClass("oracle.jdbc.OracleStatement"));
			setPreparedStatementType((Class<PreparedStatement>) getClass().getClassLoader().loadClass("oracle.jdbc.OraclePreparedStatement"));
			setCallableStatementType((Class<CallableStatement>) getClass().getClassLoader().loadClass("oracle.jdbc.OracleCallableStatement"));
			setResultSetType((Class<ResultSet>) getClass().getClassLoader().loadClass("oracle.jdbc.OracleResultSet"));
		}
		catch (Exception ex) {
			throw new IllegalStateException(
					"Could not initialize OracleJdbc4NativeJdbcExtractor because Oracle API classes are not available: " + ex);
		}
	}

}
