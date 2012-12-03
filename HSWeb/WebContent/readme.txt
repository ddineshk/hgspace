Before you startup this demo project:
1.Put the Sqlite file named of "1.db" to where you would like your db to be.
2.Modify the hibernate.cfg.xml,change the "connection.url" with the path of your db file.

[Example]
1.Put file "1.db" to "F:\work\workspace\HSWeb\1.db"
2.Modify file "hibernate.cfg.xml" like this:
<property name="connection.url">jdbc:sqlite:F:\work\workspace\HSWeb\1.db</property>