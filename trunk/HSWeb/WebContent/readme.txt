Before you startup this project:
1.Place the Sqlite file named of "college.db" where you would like your db to be.
2.Modify the hibernate.cfg.xml,change the "connection.url" with the path of your db file.

[Example]
1.Enter in file "college.db" to "C:\workspace\HSWeb\resources\college.db"
2.Modify file "hibernate.cfg.xml" like this:
<property name="connection.url">jdbc:sqlite:C:\workspace\HSWeb\resources\college.db</property>