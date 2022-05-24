package com.tuum.account.config;

import com.tuum.account.model.Balance;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@MappedTypes({List.class})
public class JsonbTypeHandler extends BaseTypeHandler<List<Balance>> {

    private static final PGobject JSONB = new PGobject();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Balance> parameter, JdbcType jdbcType) throws SQLException {
        if (ps != null) {
            JSONB.setType("jsonb");
            JSONB.setValue(parameter.toString());
            ps.setObject(i, JSONB);
        }
    }

    @Override
    public List<Balance> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getObject(columnName, List.class);
    }

    @Override
    public List<Balance> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getObject(columnIndex, List.class);
    }

    @Override
    public List<Balance> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getObject(columnIndex, List.class);
    }
}
