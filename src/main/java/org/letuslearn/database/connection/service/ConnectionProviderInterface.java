// Copyright (c) 2017-2018 LetUs Learn Inc.
package org.letuslearn.database.connection.service;

import java.sql.Connection;

/**
 * 
 * @author aksharaaaa Connection Provider Interface
 *
 */
public interface ConnectionProviderInterface {
  Connection getConnection();
}
