# gestionScolaire-WEB-EJB-EAR

==============

Ce projet permet la gestion scolaire avec les opérations de base  CRUD 

---
# Configuration du projet

[wildfly](https://www.wildfly.org/news/2023/01/18/WildFly2613-Released/)


Ajout du mysql-connector dans le répertoire wildfly\modules\system\layers\base\com\mysql\main

https://dev.mysql.com/downloads/connector/j/

Vous devez  crééer de la base de donnée depuis mysql searchjob

### Répertoire wildfly/standalone/configuration/standalone.xml


Vous ajoutez la configuration suivant de ce répertoire ci-dessus 

````
<datasource jta="true" jndi-name="java:/MySqlDS" pool-name="MySqlDS" statistics-enabled="true">
   <connection-url>jdbc:mysql://localhost:3306/gestionScolaire</connection-url>
   <driver-class>com.mysql.cj.jdbc.Driver</driver-class>
   <driver>mysql</driver>
   <security>
      <user-name>root</user-name>
   </security>
   <validation>
      	<valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"/>
	<validate-on-match>true</validate-on-match>
	<exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"/>
    </validation>
</datasource>
````



## Création d'un utilisateur 
#### Run `call wildfly/bin/add-user.bat`
````
What type of user do you wish to add?
 a) Management User (mgmt-users.properties)
 b) Application User (application-users.properties)
 (a):
````
Run `a`
````
Enter the details of the new user to add.
Using realm 'ManagementRealm' as discovered from the existing property files.
Username :
````
### Entrer le nom d'utilisateur

````

Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password :
````
Entrer le mot de passe et confirmer après

````
-----

## Usage 

En fin, lancez votre nativation puis tapez cette url
 ````
 http://localhost:8080/gestionScolaire`
````
-------
