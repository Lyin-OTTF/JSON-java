package org.json.junit.data;

import org.json.JSONPropertyIgnore;

/**
 * Bean used to pin down how {@code JSONObject#fromJson(Class)} binds JSON keys
 * to fields: {@code admin} and {@code tenantId} are private, {@code sessionKey}
 * is transient, and {@code superAdmin} is hidden behind a getter annotated with
 * {@code @JSONPropertyIgnore} (which only suppresses the bean to JSONObject
 * direction).
 */
public class CustomClassK {
  public String displayName;
  private boolean admin;
  private String tenantId;
  private transient String sessionKey;
  private boolean superAdmin;

  public CustomClassK() {
    // Required for JSONObject#fromJson(Class<T>) tests.
  }

  public boolean isAdmin() {
    return admin;
  }

  public String getTenantId() {
    return tenantId;
  }

  public String getSessionKey() {
    return sessionKey;
  }

  @JSONPropertyIgnore
  public boolean isSuperAdmin() {
    return superAdmin;
  }
}
