package org.ddk.spring.store.hibernate.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ddk.spring.store.domain.Account;
import org.ddk.spring.store.domain.Address;
import org.ddk.spring.store.domain.Banner;
import org.ddk.spring.store.domain.Category;
import org.ddk.spring.store.domain.Product;
import org.ddk.spring.store.domain.Supplier;
import org.hibernate.Session;


public class HibernateDataPopulate {
  private static Log log = LogFactory.getLog(HibernateDataPopulate.class);
  
  public HibernateDataPopulate() {
  }
  
  public static void main(String[] args) {
    log.info("Start populate store database data ...");
    Session session = null;
    try {
     
      session = HibernateUtil.getSessionFactory().openSession();
     
      session.beginTransaction();
      
      
      insertCategories(session);
      insertBanners(session);
      insertUsers(session);
      insertSuppliers(session);
      insertProducts(session);
      insertItems(session);
      insertInventories(session);
      
     
      session.getTransaction().commit();
      log.info("Successfully populate store database data!");
      System.out.println("Successfully populate store database data!");
    } catch (Throwable t) {
      if (session.getTransaction() != null) {
        session.getTransaction().rollback();
      }
      log.info("Failly populate store database data!");
      System.out.println("Failly populate store database data!");
    } finally {
      if (session != null) session.close();
    }
  }
  
  private static void insertCategories(Session s) {
    log.info("populating Category ...");
    
    Category c = new Category();
    c.setCategoryName("Fish");
    c.setCategoryDesc("<image src=\"images/fish_icon.gif\"><font size=\"5\" color=\"blue\"> Fish</font>");
    
    s.persist(c);
    
    c = null;
    c = new Category();
    c.setCategoryName("DogS");
    c.setCategoryDesc("<image src=\"images/dogs_icon.gif\"><font size=\"5\" color=\"blue\"> Dogs</font>");
    
    s.persist(c);
    
    c = null;
    c = new Category();
    c.setCategoryName("REPTILES");
    c.setCategoryDesc("<image src=\"images/reptiles_icon.gif\"><font size=\"5\" color=\"blue\"> Reptiles</font>");
    
    s.persist(c);
   
    c = null;
    c = new Category();
    c.setCategoryName("Cats");
    c.setCategoryDesc("<image src=\"images/cats_icon.gif\"><font size=\"5\" color=\"blue\"> Cats</font>");
    
    s.persist(c);
    
    c = null;
    c = new Category();
    c.setCategoryName("Birds");
    c.setCategoryDesc("<image src=\"images/birds_icon.gif\"><font size=\"5\" color=\"blue\"> Birds</font>");
    
    s.persist(c);
   
    
    log.info("populating Category end.");
  }
  
  private static void insertBanners(Session s) {
    log.info("populating Banner ...");
    Category c1 = (Category)s.get(Category.class, Long.valueOf(1));
    Category c2 = (Category)s.get(Category.class, Long.valueOf(2));
    Category c3 = (Category)s.get(Category.class, Long.valueOf(3));
    Category c4 = (Category)s.get(Category.class, Long.valueOf(4));
    Category c5 = (Category)s.get(Category.class, Long.valueOf(5));
    
   
    Banner b = new Banner();
    b.setFavCategory(c1);
    b.setBannerName("<image src=\"images/banner_fish.gif\">");
    
    s.persist(b);
   
    b = null;
    b = new Banner();
    b.setFavCategory(c4);
    b.setBannerName("<image src=\"images/banner_cats.gif\">");
    
    s.persist(b);
    
    b = null;
    b = new Banner();
    b.setFavCategory(c3);
    b.setBannerName("<image src=\"images/banner_dogs.gif\">");
    
    s.persist(b);
   
    b = null;
    b = new Banner();
    b.setFavCategory(c2);
    b.setBannerName("<image src=\"images/banner_reptiles.gif\">");
    
    s.persist(b);
    
    b = null;
    b = new Banner();
    b.setFavCategory(c5);
    b.setBannerName("<image src=\"images/banner_birds.gif\">");
    
    s.persist(b);
   
    
    log.info("populating Banner end.");
  }
  
  private static void insertUsers(Session s) {
    log.info("populating Account ...");
    
    Address ad = new Address();
    ad.setAddr1("901 San Antonio Road");
    ad.setAddr2("MS UCUP02-206");
    ad.setCity("Palo Alto");
    ad.setState("CA");
    ad.setZipcode("94303");
    ad.setCountry("USA");
    
    Category c1 = (Category)s.get(Category.class, Long.valueOf(3));
    Category c2 = (Category)s.get(Category.class, Long.valueOf(4));
    
 
    Account a = new Account();
    a.setUsername("j2ee");
    a.setPassword("j2ee");
    a.setEmail("dinesh13284@gmail.com");
    a.setFirstname("ABC");
    a.setLastname("XYX");
    a.setStatus("OK");
    a.setUserAddr(ad);
    a.setPhone("555-555-5555");
    a.setLangPreference("english");
    
    a.setFavCategory(c1);
    a.setDisplayMyList(true);
    a.setDisplayBanner(true);
    
    s.persist(a);
    s.flush();
    
 
    a = null;
    a = new Account();
    a.setUsername("ACID");
    a.setPassword("ACID");
    a.setEmail("dinesh13284@gmail.com");
    a.setFirstname("ABC");
    a.setLastname("XYX");
    a.setStatus("OK");
    a.setUserAddr(ad);
    a.setPhone("555-555-5555");
    a.setLangPreference("english");
    
    a.setFavCategory(c2);
    a.setDisplayMyList(true);
    a.setDisplayBanner(true);
    
    s.persist(a);
    s.flush();
    
    log.info("populating Account end.");
  }
  
  private static void insertSuppliers(Session s) {
    log.info("populating Supplier ...");
  
    Address ad = new Address();
    ad.setAddr1("600 Avon Way");
    ad.setAddr2("");
    ad.setCity("Los Angeles");
    ad.setState("CA");
    ad.setZipcode("94024");
    ad.setCountry("USA");
    

    Supplier sp = new Supplier();
    sp.setSupplierName("XYZ Pets");
    sp.setStatus("AC");
    sp.setSupplierAddr(ad);
    sp.setPhone("212-947-0797");
    
    s.persist(sp);
    s.flush();
    
  
    ad = null;
    ad = new Address();
    ad.setAddr1("700 Abalone Way");
    ad.setAddr2("");
    ad.setCity("San Francisco");
    ad.setState("CA");
    ad.setZipcode("94024");
    ad.setCountry("USA");
    
    sp = null;
    sp = new Supplier();
    sp.setSupplierName("ABC Pets");
    sp.setStatus("AC");
    sp.setSupplierAddr(ad);
    sp.setPhone("415-947-0797");
    
    s.persist(sp);
    s.flush();
    
    log.info("populating Supplier end.");
  }
  
  private static void insertProducts(Session s) {
    log.info("populating Product ...");
    
    Category c1 = (Category)s.get(Category.class, Long.valueOf(1));
    Category c2 = (Category)s.get(Category.class, Long.valueOf(2));
    Category c3 = (Category)s.get(Category.class, Long.valueOf(3));
    Category c4 = (Category)s.get(Category.class, Long.valueOf(4));
    Category c5 = (Category)s.get(Category.class, Long.valueOf(5));
    
  
    Product p = new Product();
    p.setProductNumber("FI-SW-01");
    p.setCategory(c1);
    p.setProductName("Angelfish");
    p.setProductDesc("<image src=\"images/fish1.jpg\">Salt Water fish from Australia");
    
    s.persist(p);
    s.flush();
    
   
    p = null;
    p = new Product();
    p.setProductNumber("FI-SW-02");
    p.setCategory(c1);
    p.setProductName("Tiger Shark");
    p.setProductDesc("<image src=\"images/fish4.jpg\">Salt Water fish from Australia");
    
    s.persist(p);
    s.flush();
    
 
    p = null;
    p = new Product();
    p.setProductNumber("FI-FW-01");
    p.setCategory(c1);
    p.setProductName("Koi");
    p.setProductDesc("<image src=\"images/fish3.gif\">Fresh Water fish from Japan");
    
    s.persist(p);
    s.flush();
    

    p = null;
    p = new Product();
    p.setProductNumber("FI-FW-02");
    p.setCategory(c1);
    p.setProductName("Goldfish");
    p.setProductDesc("<image src=\"images/fish2.gif\">Fresh Water fish from China");
    
    s.persist(p);
    s.flush();
    
  
    p = null;
    p = new Product();
    p.setProductNumber("K9-BD-01");
    p.setCategory(c2);
    p.setProductName("Bulldog");
    p.setProductDesc("<image src=\"images/dog2.gif\">Friendly dog from England");
    
    s.persist(p);
    s.flush();
    
   
    p = null;
    p = new Product();
    p.setProductNumber("K9-PO-02");
    p.setCategory(c2);
    p.setProductName("Poodle");
    p.setProductDesc("<image src=\"images/dog6.gif\">Cute dog from France");
    
    s.persist(p);
    s.flush();
    
   
    p = null;
    p = new Product();
    p.setProductNumber("K9-DL-01");
    p.setCategory(c2);
    p.setProductName("Dalmation");
    p.setProductDesc("<image src=\"images/dog5.gif\">Great dog for a Fire Station");
    
    s.persist(p);
    s.flush();
    
    
    p = null;
    p = new Product();
    p.setProductNumber("K9-RT-01");
    p.setCategory(c2);
    p.setProductName("Golden Retriever");
    p.setProductDesc("<image src=\"images/dog1.gif\">Great family dog");
    
    s.persist(p);
    s.flush();
    
  
    p = null;
    p = new Product();
    p.setProductNumber("K9-RT-02");
    p.setCategory(c2);
    p.setProductName("Labrador Retriever");
    p.setProductDesc("<image src=\"images/dog5.gif\">Great hunting dog");
    
    s.persist(p);
    s.flush();
    
  
    p = null;
    p = new Product();
    p.setProductNumber("K9-CW-01");
    p.setCategory(c2);
    p.setProductName("Chihuahua");
    p.setProductDesc("<image src=\"images/dog4.gif\">Great companion dog");
    
    s.persist(p);
    s.flush();
    
  
    p = null;
    p = new Product();
    p.setProductNumber("RP-SN-01");
    p.setCategory(c3);
    p.setProductName("Rattlesnake");
    p.setProductDesc("<image src=\"images/lizard3.gif\">Doubles as a watch dog");
    
    s.persist(p);
    s.flush();
    
   
    p = null;
    p = new Product();
    p.setProductNumber("RP-LI-02");
    p.setCategory(c3);
    p.setProductName("Iguana");
    p.setProductDesc("<image src=\"images/lizard2.gif\">Friendly green friend");
    
    s.persist(p);
    s.flush();
    
    
    p = null;
    p = new Product();
    p.setProductNumber("FL-DSH-01");
    p.setCategory(c4);
    p.setProductName("Manx");
    p.setProductDesc("<image src=\"images/cat3.gif\">Great for reducing mouse populations");
    
    s.persist(p);
    s.flush();
    
    
    p = null;
    p = new Product();
    p.setProductNumber("FL-DLH-02");
    p.setCategory(c4);
    p.setProductName("Persian");
    p.setProductDesc("<image src=\"images/cat1.gif\">Friendly house cat, doubles as a princess");
    
    s.persist(p);
    s.flush();
    
   
    p = null;
    p = new Product();
    p.setProductNumber("AV-CB-01");
    p.setCategory(c5);
    p.setProductName("Amazon Parrot");
    p.setProductDesc("<image src=\"images/bird4.gif\">Great companion for up to 75 years");
    
    s.persist(p);
    s.flush();
    
    // 16
    p = null;
    p = new Product();
    p.setProductNumber("AV-SB-02");
    p.setCategory(c5);
    p.setProductName("Finch");
    p.setProductDesc("<image src=\"images/bird1.gif\">Great stress reliever");
    
    s.persist(p);
    s.flush();
    
    log.info("populating Product end.");
  }
  
  private static void insertItems(Session s) {

  }
  
  private static void insertInventories(Session s) {

  }
}
