# Broken Access Control - Path traversal

- Path traversal - no sanitization of user-provided path
<!-- .element: class="list-fragment" -->
- Example: 
  - Photos stored in `/data/photos/<username>/<albumname>/<photoname>`
  - GET /photo?path=myAlbum/photo4.png
  - Server code: 
<!-- .element: class="list-fragment" -->

```js [1|2|3|4]
const basePath = "/data/photos";
const userName = session.getUserName();
const photoPath = queryParams.get("path");
return new Photo("$basePath/$userName/$photoPath")
```
<!-- .element: class="fragment" -->



##==##

# Broken Access Control - Path traversal

- Exploitation:
  - GET /photo?path=../anotherUser/album1/photo1.png
    - `/data/photos/mathieu/../anotherUser/album1/photo1.png`
    - `/data/photos/anotherUser/album1/photo1.png`
  - GET /photo?path=../../../etc/passwd
    - `/data/photos/mathieu/../../../etc/passwd`
    - `/etc/passwd`
- How to secure this ?
<!-- .element: class="list-fragment" -->

Notes:
- several options: 
  - sanitize path
  - or ask album and photo name separately (with no "/" authorized in any of them)
  - better: use ids, and store album + name in database



##==##

# Broken Access Control - Path traversal

- Protection with sanitization
  - Let's remove the "../" from the string
  - `path = path.replaceAll("../", "")`
- But what if...
<!-- .element: class="list-fragment" -->
  - Path: ....//anotherUser/album1/photo1.png
  - Sanitized: ../anotherUser/album1/photo1.png
- Conclusion:
<!-- .element: class="list-fragment" -->
  - Use existing sanitization libraries
  - be cautious when sanitizing yourself
<!-- .element: class="list-fragment" -->



##==##

# Broken Access Control - Cross-Site Request Forgery (CSRF)

- Users may submit unintended requests to the web application
- Example website - https://example.com/admin
<!-- .element: class="list-fragment" -->
  - POST /promoteAdmin , data: { userId: xx }
<!-- .element: class="list-fragment" -->

```HTML [1,4|2,3]
<form action="/promoteAdmin" method="post">
  <input type="number" name="userId"/>
  <input type="submit" name="submit" value="Update"/>
</form>
```
<!-- .element: class="fragment" -->

Notes:
- Transparently, by visiting an attacker's website, or clicking on links
- Ex: Endpoint and page only accessible for admin



##==##

# Broken Access Control - Cross-Site Request Forgery (CSRF)

- Attacker's website (https://attacker.com/):

```HTML [1,4|2,3|5-7]
<form action="https://example.com/promoteAdmin" method="post" id="myForm">
  <input type="number" name="userId" value="133"/>
  <input type="submit" name="submit" value="Update"/>
</form>
<script>
  document.getElementById("myForm").submit();
</script>
```
<!-- .element: class="fragment" -->

Notes:
- If an admin access that page, and is logged in on https://example.com, it will perform the request



##==##

# Broken Access Control - Cross-Site Request Forgery (CSRF)

- Example with GET:
<!-- .element: class="list-fragment" -->
  - https://example.com/deleteAccount

    ```HTML
    Are you sure you want to delete your account ?
    If so, click on delete below.
    <a href="/confirmDelete?confirm=yes">Delete</a>
    ```
    <!-- .element: class="fragment" -->

  - GET /confirmDelete?confirm=xx => deletes the account if xx = yes
<!-- .element: class="list-fragment" -->
- The attacker sends the following link: https://example.com/confirmDelete?confirm=yes
- Or even better, if the login page uses a "redirectTo" param:
<!-- .element: class="list-fragment" -->
  - https://example.com/login?
    `redirect=https%3A%2F%2Fexample.com%2FsomeVeryLongPageNameThatSeemsLegit`
    `&redirectTo=https%3A%2F%2Fexample.com%2FconfirmDelete%3Fconfirm%3Dyes`
<!-- .element: class="list-fragment" -->



##==##

# Broken Access Control - Cross-Site Request Forgery (CSRF)

- Rules:
  - Implement CSRF protection mechanism
  - No GET for state-changing actions
  - Optional: implement CSRF mitigation mechanisms
<!-- .element: class="list-fragment" -->



##==##

# Broken Access Control - Open Redirect

- A user-controlled link input is used, to redirect the user to that link.
- Example:
  - https://example.com/myProfile
  - redirects to https://example.com/login?redirectTo=https%3A%2F%2Fexample.com%2FmyProfile
  - Attacker-crafted URL: https://example.com/login?redirectTo=https%3A%2F%2Fattack.com%2FmyProfile
- How to protect against it ?
<!-- .element: class="list-fragment" -->

Notes:
- avoid redirectTo params
- when not possible, use a strict whitelist
- if a whitelist is not possible, then display a warning to the user



##==##

# Broken Access Control - CORS misconfiguration

- Default browser behaviour
- CORS header - Access-Control-Allow-Origin
- Several other headers (methods, headers, credentials...)
- Bad: `Access-Control-Allow-Origin: *`
<!-- .element: class="list-fragment" -->

Notes:
- bad example => like CSRF, but worse... Attacker can perform several actions easily
