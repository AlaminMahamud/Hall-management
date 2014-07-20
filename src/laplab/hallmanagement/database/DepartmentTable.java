package laplab.hallmanagement.database;

import laplab.lib.tablecreator.Column;
import laplab.lib.tablecreator.ColumnList;
import laplab.lib.tablecreator.PrimaryKey;
import laplab.lib.tablecreator.TableStatementCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 * User: ahmed
 * Date: 7/2/14
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class DepartmentTable {
    private static final String TABLE_NAME = DataBaseConstant.DEPARTMENT_TABLE_NAME;

    public static final String DEPARTMENT_ID_COLUMN = "ID";
    public static final String DEPARTMENT_NAME_COLUMN = "DEPARTMENT_NAME";

    Connection connection;

    DepartmentTable(Connection connection) {
        this.connection = connection;
    }

    private ColumnList createColumns() {
        ColumnList columns = new ColumnList();

        columns.add(new Column(DepartmentTable.DEPARTMENT_ID_COLUMN, Column.COLUMN_TYPE_INTEGER, false));
        columns.add(new Column(DepartmentTable.DEPARTMENT_NAME_COLUMN, Column.setStringType(50), false));
        return columns;
    }


    public int create() {
        String statementQuery = new TableStatementCreator(DepartmentTable.TABLE_NAME,
                createColumns(),
                new PrimaryKey(DepartmentTable.DEPARTMENT_ID_COLUMN)).getStatement();

        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(statementQuery);
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return -1;
        }
    }

}