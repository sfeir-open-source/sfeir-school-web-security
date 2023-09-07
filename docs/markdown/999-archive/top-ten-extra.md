# Broken Access Control - Open Redirect

- Whitelist example: only authorize relative paths
<!-- .element: class="list-fragment" -->
- Example: https://example.com/login?redirectTo=%2FmyProfile
  - redirectTo: /myProfile
- Verification: check that the url starts with "/" ?
- ... Not secure
- Example: //attacker.com
<!-- .element: class="list-fragment" -->

Notes:
- //attacker.com  is a valid (scheme-relative) URL
- conclusion - again: be cautions when sanitizing



##==##

# Insecure Design - Sensitive information storage

- in persistent cookie
- in browser cache
- in GET parameters
- in generated error messages
- missing encryption
<!-- .element: class="list-fragment" -->



##==##

# Vulnerable and Outdated Components - JavaScript libraries

- JQuery
- AngularJS
- Angular / React / Vue / ***
- npm transitive dependencies
<!-- .element: class="list-fragment" -->

Notes:
- Jquery: still maintained (and still there on many websites)
- AngularJS: not maintained anymore...
- npm: npm audit fix ; force versions of transitive dependencies in package.json (but risk of incompatibilities).
