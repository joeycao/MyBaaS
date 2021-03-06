package com.maxleap.pandora.data.support.lasdata;

import com.maxleap.domain.auth.LASPrincipal;
import com.maxleap.pandora.config.mgo.MgoDatabase;
import com.maxleap.pandora.core.lasdata.LASClassSchema;
import com.maxleap.pandora.core.lasdata.LASQuery;
import com.maxleap.pandora.data.support.utils.LASIncludes;

/**
 * @author sneaky
 * @since 2.0.0
 */
public class AppFindOneRequest extends AppRequest {
  LASQuery query;
  LASIncludes lasIncludes;

  public AppFindOneRequest() {

  }

  public AppFindOneRequest(MgoDatabase mgoDatabase, LASClassSchema classSchema, LASQuery query, LASPrincipal principal) {
    this.mgoDatabase = mgoDatabase;
    this.classSchema = classSchema;
    this.query = query;
    this.principal = principal;
    String includes = query.getIncludes();
    if (includes != null && !"".equals(includes)) {
      lasIncludes = new LASIncludes(includes);
    }
  }

  public LASQuery getQuery() {
    return query;
  }

  public void setQuery(LASQuery query) {
    this.query = query;
  }

  public LASIncludes getLasIncludes() {
    return lasIncludes;
  }

  public void setLasIncludes(LASIncludes lasIncludes) {
    this.lasIncludes = lasIncludes;
  }

  @Override
  public String toString() {
    return "{" +
        ", query=" + query +
        ", classSchema=" + classSchema +
        '}';
  }
}
