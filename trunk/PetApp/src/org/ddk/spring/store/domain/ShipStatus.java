
package org.ddk.spring.store.domain;

public enum ShipStatus {
    PENDING("PENDING"),
    AGREED("AGREED"),
    PAYED("PAYED"), 
    IN_TRANSIT("IN_TRANSIT"),
    ACCEPTED("ACCEPTED"),
    COMPLETE("COMPLETE");
    
    private final String state;
    
    private ShipStatus(String state) {
      this.state = state;
    }
    
    public String value() {
      return state;
    }
    
    public String toString() {
      return state;
    }
}
