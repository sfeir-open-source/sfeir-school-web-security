# My Shopping App - vulnerabilities

This document lists the vulnerabilities found in the *My Shopping App* application. It tries to be exhaustive, but if you found a vulnerability not in this list, please reach out!


## A01 - Missing access controls

Several endpoints are not checking who is performing the request: renameList, deleteList, and the listItem endpoints. This means any user could use these endpoints to update/delete other users resources.



## A01 - Missing CSRF protection

The Cross-Site Request Forgery (CSRF) protection, included by default in Spring Security, has been disabled.
See `SecurityConfig.java`: `.csrf(AbstractHttpConfigurer::disable)`.

This makes the application vulnerable to CSRF attacks.
As most POST endpoints are requiring body parameters in JSON format, CSRF is not exploitable for them (but see the CORS issue below), as it is not possible to send a POST request with a JSON body using an HTML form (you will need to do a request in JavaScript, but then CORS protection will apply).

But the delete account endpoint does not request any parameter, so this one is vulnerable.
See exploits/csrf-exploit.html: if you are logged in on My Shopping App in your browser, and opens csrf-exploit.html, this will automatically delete your account. So, simply by visiting a specially-crafted web page (or even opening an html attachment received by email), actions can be performed on your account if you were logged-in.



## A01 - Get requests for state-changing actions

Even if the CSRF protection was enabled, some state-changing actions are using GET requests (delete list, delete item).
Thus, actions can be performed by clicking on a link.

For instance, if you access this page: `http://localhost:8085/list/delete/3`, it will delete your list having ID=3. Here, it requires to know the ID of your list (but that one is not necessarily secret, e.g. if you can share read-only links to your lists.
An even better link is `http://localhost:8085/home/checkAccount?return=/home&fbclid=qszazefalqsd-azefqsdfaz-fqsdfgaer-azef&page=%2Flist%2Fdelete%2F3`: you cannot easily see that this link will redirect you on a delete page. That link uses an internal redirection page.

And it is not even necessary to click on any link to your website. If an attacker post a message in a public forum, and includes an image with src = "http://localhost:8085/list/delete/3" (or even several images with incrementing IDs),
and that you visit the public forum, it will perform a request to your website, and thus perform the action.
Note that this will not work in modern browsers, as they will not send your connection cookies with these requests in such a case. However, either with an old browser, or if your connection cookie has SameSite=None explicitly defined, it becomes exploitable.



## A01 - Open redirect

The endpoint /home/checkAccount is vulnerable to open redirect attacks. That endpoint takes a "page" parameter, and in some conditions (you basically just need to be logged in), redirects the user to that page.
It is checked that the given page must start with "/", probably to ensure that the page is a relative page.

However, the URL "//google.com" is a valid one. It is a scheme-relative URL: if a link "//google.com" appears on an HTTPS page, it will use HTTPS, and if it is on an HTTP page, it will use HTTP.

So, `http://localhost:8085/home/checkAccount?page=//google.com` will redirect the user to google.com. This is a risk, as an apparently legitimate link can redirect the user to any website.



## A01 - CORS misconfiguration

CORS is enabled (See `SecurityConfig.java`: `.cors(Customizer.withDefaults())`. Unless there are good reasons to enable it, this is a risk. Also, the default CORS configuration for Spring (when CORS is explicitly enabled like here) is to allow any domain to perform requests.

With a modern browser, the impact is limited, as session cookies will not be sent with the request when it is performed by another domain and that the target domains allows any domain to perform request. But this will not be the case with old browsers.



## A08 - Mass assignment

The endpoint PUT /listitem/{itemId}, to update an item, is vulnerable to mass assignment. From what we can see in the postman collection, this endpoint is used to rename the listitem, and set the check/uncheck status.
However, it is also possible to use it to set the listId field. Using that endpoint, you can for instance move an item from your list into the list of another user (to make him buy some product...).

See exploits/hacks.postman_collection.json > Mass-assignment.



## A03 - Path traversal

The /listitem/logo endpoint is vulnerable to path traversal attacks, but only because of the Mass assignment vulnerability (see above).

When the user defines the item's logo using the /listitem/logo POST endpoint, the received logoId (which is in fact the logo filename) is validated against a whitelist. So these endpoints are not vulnerable as-is (even if it would be even better that the user only send an integer ID, and that the logo filenames are stored in database).

However, thanks to the Mass assignment attack from above, it is possible to erase the logoImageId field of an item, using the PUT /listitem/{itemId} endpoint.

See exploits/hacks.postman_collection.json > Path-traversal: it will set the logoImageId field to "../application.properties". Then, if you execute the Get item logo, and save the response as a txt file, you will see it contains the content of application.properties.
[response.class](..%2F..%2F..%2F..%2F..%2FDownloads%2Fresponse.class)
See also exploits/hacks.postman_collection.json > Path-traversal-2: it will set the field to "../com/sfeir/schools/websecurity/exercices/myshoppingapp/config/SecurityConfig.class". The received logo will be the compiled version of SecurityConfig (which you can de-compile for instance by opening the file with IntelliJ).

This path traversal attack let attackers access any file available in the classpath.



## A05 - Security misconfiguration

DbInitializer.java contains default accounts (including one admin account), with hardcoded passwords, that are created when the application is started. Having such insecure default accounts in production is a big flaw.

Note: you might also consider that DbInitializer.java is there only for the exercise, to have existing data to be able to test the application.



## A06 - Vulnerable components

In the project's dependencies, there is at least the log4j-core dependency which is vulnerable, as we are using the version 2.7, vulnerable to the Log4shell vulnerability.



## A07 - Session duration

In application.properties, the session timeout (server.servlet.session.timeout) is set to 0, which means an infinite session duration. This is a bad practice, as it increase the risk of session theft.



## A07 - Login attempts limitation

The amount of failed login attempts is not limited for any user. This enables brute-force attacks to remain undetected.



## A07 - Weaker password algorithm

The strength of the BCryptPasswordEncoder is set to the lowest possible value (in DbInitializer.java), without any known reason.



## A09 - Missing logs

The application has nearly no logs at all. Several things must be logged, for instance failed login attempts and account deletion.



## A09 - Sensitive data in logs

The admin endpoint /user, when accessed by a non-admin user, logs a warning containing the user data. The toString() method of User object is displaying all user's data, including email and hashed password, which should not be added in logs.



## Redos - Regular Expression Denial of Service

The /user/check-email-format endpoint uses a Regex (Regular Expression) to validate an email. However, that regex is vulnerable to denial of service attack.

If you are able to create a user with an invalid email (e.g. because you do not need to send mails to users), or if the create user endpoint uses the same regex, you can exploit the vulnerability.

Try to update DbInitializer.java: replace "user@example.com" by "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!". Then start the application, login with that user, and try to access http://localhost:8085/user/check-email-format . Open several browser tabs and access that same URL.
You will see that your CPU usage will increase. You can stop/restart the application when you are done.



## Potential other threats

- XSS, template injection: no protection implemented on the backend side. This does not mean the frontend application is vulnerable, but this is a risk.
- Weak passwords are allowed for accounts.
