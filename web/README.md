#Codex Trees

**Community :evergreen_tree:** for the learning students and professionals. We provide the `best resources` for learning in the telegram channel for now.

>Future Goals
- [ ] Add mail service to the peoples
- [ ] Host the website for mail subscription
- [ ] Add telegram bot for the channel.
- [ ] Make a centralized sharing point.



##Getting Started

####**Setup**
- Install eclipse IDE
- Install spring boot from eclipse marketplace
- Install git and clone the repository

####**About web project**
- Check for [dependencies](/web/pom.xml)
- Maven as the build tool
- SQLite as the database for now
- Google oauth 2.0 authentication
- Application properties are available in [properties](/web/src/main/resources/application.properties)

####**Development**

Checkout out all the links before getting started

- Spring boot oauth is refered from this [guide](https://spring.io/guides/tutorials/spring-boot-oauth2/).
- To write documentation refer [Basic writing and formatting syntax](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax#section-links).


##**About Code**

The flow goes in the given order.

####**Basic Files**

- Web application is started from the [start file](/web/src/main/java/com/codextrees/web/WebApplication.java).

- Security Configurations for htttp are given in [securty config](/web/src/main/java/com/codextrees/web/SecurityConfig.java).

- Controllers are given in [controllers](/web/src/main/java/com/codextrees/web/HomeController.java).

- Rest Controllers are given in [rest controllers](/web/src/main/java/com/codextrees/web/RestHomeController.java).

- [SQLite Dialect](/web/src/main/java/com/codextrees/web/dialect/SQLiteDialect.javas) includes the SQLite code
 
- [Frontend Readme](/web/Frontend.md) gives the outline for starting with forntend.
####**Custom Oauth files**
- Custom Oauth [User](/web/src/main/java/com/codextrees/web/CustomOAuth2User.java) and [service](/web/src/main/java/com/codextrees/web/CustomOAuth2UserService.java) is given to provide custom functions.

####**User files**
- [User model](/web/src/main/java/com/codextrees/web/User.java) which has the fields of user.

- [My User Details](/web/src/main/java/com/codextrees/web/MyUserDetails.java) contains limited functions.
- [User Service](/web/src/main/java/com/codextrees/web/UserService.java) for providing service for user.

- [User Repository](/web/src/main/java/com/codextrees/web/UserRepository.java) contains the query executions that need to be executed in the database.

- User [Role](/web/src/main/java/com/codextrees/web/Role.java) enumeration has `ADMIN` ,`USER`.
- User [Provider](/web/src/main/java/com/codextrees/web/Provider.java) enumeration has `GOOGLE`, `LOCAL`.

####**Email sender files**

- [Email details](/web/src/main/java/com/codextrees/web/EmailDetails.java) contains the model for sending email.
- [Email Service](/web/src/main/java/com/codextrees/web/EmailService.java) contains sending mail with attachment and without attachment.
