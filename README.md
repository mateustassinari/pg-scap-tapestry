# pg-scap-tapestry
To run the project we will need:

* Eclipse IDE
* Tomcat 9.0
* MySQL Community 
* MySQL Connector/J JDBC Driver
* MySQL Workbench 

# Set-up Eclipse to work with Tomcat
To deploy our application in Tomcat during development more easily, it's recommended to integrate the IDE Eclipse with the application server Tomcat. This is done with some tools, which can now be installed in a more straightforward way in the latest Eclipse version:

1. Open Eclipse;

2. Open the Servers view (if not visible, use the Window > Show View menu);

3. Click on the "No servers are available. Click this link to create a new server..." link, which is shown when the Servers view is empty. Alternatively, right-click the blank space at the Servers view and select New > Server;

4. Open the Apache folder and select Tomcat v9.0 Server;

5. Fill in the server's directory ($TOMCAT_HOME) and click Finish.

# Set-up Tomcat to connect to MySQL
1. In the folder $TOMCAT_HOME/lib, unpack the MySQL Connector/J JDBC Driver you downloaded earlier and copy the file mysql-connector-java-5.1.42-bin.jar. If you downloaded a different version of Connector/J, adjust the name accordingly;

You should now be ready to develop a Java EE project in Eclipse, deploying it in Tomcat and configuring it to use MySQL database for persistence. 

# Database creation and set-up
We will use JPA (Java Persistence API), one of the Java EE standards, persisting our objects in a relational database stored in the MySQL server. We need, therefore, to:

1. Create a database schema named scap2;

2. Create a database user named scap2 with password scap2;

3. Give user scap full permission for the schema scap2.

# Datasource configuration in Tomcat
While we could configure JPA to connect to the database we have just created in a configuration file in our project, creating a datasource for it in Tomcat allows us to use JTA (Java Transaction API), another standard from Java EE, which provides us with automatic transaction management.

To create a JTA datasource for Scap in Tomcat, open the file $TOMCAT_HOME/conf/context.xml. Add a datasource for the scap database in MySQL:
```xml
<Resource name="jdbc/Scap_tapestry" auth="Container" type="javax.sql.DataSource" maxTotal="100" maxIdle="30" maxWaitMillis="10000" username="scap2" password="scap2" driverClassName="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/scap2"/>
```

# Running the project
1. Open the Servers view, right-click the tomcat and click Add and Remove, choose the Scap_tapestry project and finish;

2. Run Tomcat and open localhost:8080/Scap_tapestry
