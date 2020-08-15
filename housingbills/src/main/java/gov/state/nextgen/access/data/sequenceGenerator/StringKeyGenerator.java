package gov.state.nextgen.access.data.sequenceGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class StringKeyGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object collection) throws HibernateException {
        Connection connection = session.connection();
        PreparedStatement ps = null;
        String result = "";

        try {
            // Oracle-specific code to query a sequence
            ps = connection.prepareStatement("SELECT CP_APP_SCREENER_1SQ.nextval AS app_screener_num FROM dual");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int pk = rs.getInt("app_screener_num");

                // Convert to a String
                result = Integer.toString(pk);
            }
        } catch (SQLException e) {
            throw new HibernateException("Unable to generate Primary Key");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new HibernateException("Unable to close prepared statement.");
                }
            }
        }

        return result;
    }

}
