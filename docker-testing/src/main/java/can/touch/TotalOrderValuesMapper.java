package can.touch;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by paulg on 3/3/17.
 */
public class TotalOrderValuesMapper implements ResultSetMapper<TotalOrderValue> {
    @Override
    public TotalOrderValue map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new TotalOrderValue(r.getInt("customer_id"), r.getInt("total_order_value"));
    }

}
