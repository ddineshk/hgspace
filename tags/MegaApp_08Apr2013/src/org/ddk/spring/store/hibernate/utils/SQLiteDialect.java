package org.ddk.spring.store.hibernate.utils;

import org.hibernate.Hibernate;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;

public class SQLiteDialect extends Dialect {

	public SQLiteDialect() {
		registerColumnType(-7, "integer");
		registerColumnType(-6, "tinyint");
		registerColumnType(5, "smallint");
		registerColumnType(4, "integer");
		registerColumnType(-5, "bigint");
		registerColumnType(6, "float");
		registerColumnType(7, "real");
		registerColumnType(8, "double");
		registerColumnType(2, "numeric");
		registerColumnType(3, "decimal");
		registerColumnType(1, "char");
		registerColumnType(12, "varchar");
		registerColumnType(-1, "longvarchar");
		registerColumnType(91, "date");
		registerColumnType(92, "time");
		registerColumnType(93, "timestamp");
		registerColumnType(-2, "blob");
		registerColumnType(-3, "blob");
		registerColumnType(-4, "blob");
		registerColumnType(2004, "blob");
		registerColumnType(2005, "clob");
		registerColumnType(16, "integer");
		registerFunction("concat", new VarArgsSQLFunction(Hibernate.STRING, "","||", ""));
		registerFunction("mod", new SQLFunctionTemplate(Hibernate.INTEGER,"?1 % ?2"));
		registerFunction("substr", new StandardSQLFunction("substr",Hibernate.STRING));
		registerFunction("substring", new StandardSQLFunction("substr",Hibernate.STRING));
	}

	public boolean supportsIdentityColumns() {
		return true;
	}

	public boolean hasDataTypeInIdentityColumn() {
		return false;
	}

	public String getIdentityColumnString() {
		return "integer";
	}

	public String getIdentitySelectString() {
		return "select last_insert_rowid()";
	}

	public boolean supportsLimit() {
		return true;
	}

	public String getLimitString(String query, boolean hasOffset) {
		return (new StringBuffer(query.length() + 20)).append(query).append(hasOffset ? " limit ? offset ?" : " limit ?").toString();
	}

	public boolean supportsTemporaryTables() {
		return true;
	}

	public String getCreateTemporaryTableString() {
		return "create temporary table if not exists";
	}

	public boolean dropTemporaryTableAfterUse() {
		return false;
	}

	public boolean supportsCurrentTimestampSelection() {
		return true;
	}

	public boolean isCurrentTimestampSelectStringCallable() {
		return false;
	}

	public String getCurrentTimestampSelectString() {
		return "select current_timestamp";
	}

	public boolean supportsUnionAll() {
		return true;
	}

	public boolean hasAlterTable() {
		return false;
	}

	public boolean dropConstraints() {
		return false;
	}

	public String getAddColumnString() {
		return "add column";
	}

	public String getForUpdateString() {
		return "";
	}

	public boolean supportsOuterJoinForUpdate() {
		return false;
	}

	public String getDropForeignKeyString() {
		throw new UnsupportedOperationException("No drop foreign key syntax supported by SQLiteDialect");
	}

	public String getAddForeignKeyConstraintString(String constraintName,
			String foreignKey[], String referencedTable, String primaryKey[],
			boolean referencesPrimaryKey) {
		throw new UnsupportedOperationException("No add foreign key syntax supported by SQLiteDialect");
	}

	public String getAddPrimaryKeyConstraintString(String constraintName) {
		throw new UnsupportedOperationException("No add primary key syntax supported by SQLiteDialect");
	}

	public boolean supportsIfExistsBeforeTableName() {
		return true;
	}

	public boolean supportsCascadeDelete() {
		return false;
	}
}
