package com.clive.framework.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class SqlDuplicateException extends Exception {
    public SqlDuplicateException(String message) {
        super(message);
    }
}
