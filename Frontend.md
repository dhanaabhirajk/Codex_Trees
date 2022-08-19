#Frontend

##About

Starts with the [index page](/web/src/main/resources/static/index.html). It is the welcome of the user. [Templates](/web/src/main/resources/templates/) folder contains the views with thymeleaf.

###Dependencies used

- jquery
- cookies
- thymeleaf

###FLow
>[Index.html](/web/src/main/resources/static/index.html)

It is in static folder. It has two views with `authentication` and `without authentication`. After successful athentication, there are two roles [`ADMIN`](/web/src/main/java/com/codextrees/web/models/Role.java), [`USER`](/web/src/main/java/com/codextrees/web/models/Role.java). 

[`Users`](/web/src/main/java/com/codextrees/web/models/Role.java) are able to logout, subscribe and unsubscribe in the home page.

>[sendMailAll.html](/web/src/main/resources/templates/admin/sendMailAll.html)

It is the page where the [`ADMIN`](/web/src/main/java/com/codextrees/web/models/Role.java) is able to send mails to all the subscribed `Users`. To send mail to respective users, it is implemented with thymeleaf MVC in [sendMail.html](/web/src/main/resources/templates/admin/sendMail.html).

>[contactForm.html](/web/src/main/resources/templates/contactForm.html) 

This is the page where the user can send resources or queries and stored in the database. It is only for authenticated users.

>[footer.html](/web/src/main/resources/static/footer.html)

It contains the footer for all html pages where the links and contact information is provided.

>[header.html](/web/src/main/resources/static/header.html)

It contains the sections with name and profile if authenticated.

>[profile.html](/web/src/main/resources/templates/profile.html)

Get the profile details from the database and show the details. Show the options like subscribe , logout, unsubscribe.

>[todaymessesge.html](/web/src/main/resources/templates/todaymessege.html)

Display the today's messege extracted from the database. Need to be in the form of template as it is used as a template for sending today's messege in mail. It would be convvient and easy.

>[allmesseges.html](/web/src/main/resources/static/allmesseges.html)

The page contains the last one week messeges. If needed it shows all the messeges.

>[developers.html](/web/src/main/resources/static/allmesseges.html)

This page shows all the members in the team with their position.
