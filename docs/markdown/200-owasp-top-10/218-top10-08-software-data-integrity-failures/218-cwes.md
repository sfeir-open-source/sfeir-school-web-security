# Software and Data Integrity Failures - Untrusted Source

- Inclusion of Web Functionality from an Untrusted Source

```
<script src="https://somecdn.example.com/myLib-v4.3.1.js"></script>
```
<!-- .element: class="fragment" -->

- New risks:
<!-- .element: class="list-fragment" -->
  - Maybe somecdn.example.com is not as secure as your website
  - somecdn is a bigger target
<!-- .element: class="list-fragment" -->




##==##

# Software and Data Integrity Failures - Untrusted Source

- Solution: host it yourself...
- Or: Subresource Integrity (SRI)
<!-- .element: class="list-fragment" -->

```html [1,2,5|3,4]
<script
  src="https://somecdn.example.com/myLib-v4.3.1.js"
  integrity="sha384-q8abi/X+abqVgRVzp9641JH+8abtTSt5DzO0rT7bzo5smXKp4YfRvKQIAE1Pi6jizo"
  crossorigin="anonymous">
</script>
```
<!-- .element: class="fragment" -->

Notes:
- host yourself: not good for the user... loose advantage of cdn server.
- SRI: also possible for scripts on same website



##==##

# Software and Data Integrity Failures - Deserialization of Untrusted Data

- serialized object stored in cookie, user-provided file/data.
- Risks
<!-- .element: class="list-fragment" -->
  - Autorization bypass
  - Remote Code Execution
<!-- .element: class="list-fragment" -->



##==##

# Software and Data Integrity Failures - Mass Assignment

- Automated mapping

```html [1,5,6|2-4]
<form method="POST">
     <input name="userid" type="text">
     <input name="password" type="text">
     <input name="email" text="text">
     <input type="submit">
</form>
```

- `POST /addUser  userid=someId&password=pwd&email=mail@example.com`
<!-- .element: class="list-fragment" -->





##==##

# Software and Data Integrity Failures - Mass Assignment

- Automated mapping

``` [1|2-5|7-13]
@RequestMapping(value = "/addUser", method = RequestMethod.POST)
public String submit(User user) {
   userService.add(user);
   return "successPage";
}

public class User {
   private String userid;
   private String password;
   private String email;
   private boolean isAdmin;
   ...
}
```



##==##

# Software and Data Integrity Failures - Mass Assignment

- Automated mapping - exploit

```
POST /addUser  userid=someId&password=pwd&email=mail@example.com&isAdmin=true
```

Notes:
- use DTOs (Data Transfer Objects)
- Or allow-list of non-sensitive fields that can be mapped
