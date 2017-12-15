package com.dynamic.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

	@Override
	protected String determineCurrentLookupKey() {
		return DataSourceHolder.getDataSource();
	}

}
