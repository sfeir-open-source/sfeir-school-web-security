# Security Misconfiguration - Sensitive data storage

- In cookie without HttpOnly flag
- In cookie without secure flag
- In unencrypted cookie
- In environment variables
<!-- .element: class="list-fragment" -->

Notes:
- environment variables: accessible to other processes (incl child processes), can be inserted in logs...



##==##

# Security Misconfiguration - No custom error page

- Default error pages

![](./assets/images/200-owasp-top-10/tomcat-stack-trace.png)


Notes:
- use custom error pages!
- and of course: disable developer mode / enable production mode
