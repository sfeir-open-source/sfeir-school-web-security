<!-- .slide: class="transition" -->
# OWASP top-10 - A01:2021 - Broken Access Control

Notes:
- most of the content of this section is based on the website https://owasp.org/Top10



##==##
<!-- .slide: class="quote-slide" -->

## Broken Access Control

<blockquote>
<cite>
  Access control enforces policy such that users cannot act outside of their intended permissions.
</cite>
</blockquote>

Notes:
- Impact: information disclosure, data modification/destruction



##==##

# Broken Access Control - Common vulnerabilities

- unprotected endpoint (forced browsing)
- Elevation of privilege
- Violation of the principle of least privilege / deny by default
- Bypass access control checks (update URL / app state / requests)
- Insecure direct object reference (IDOR)
<!-- .element: class="list-fragment" -->

Notes:
- IDOR: provide another userId in the request, and you can access its data



##==##

# Broken Access Control - How to prevent

- Deny by default
- Shared access control mechanisms
- Secure session management
- Secure web root directory
- Log access control failures
- ...
<!-- .element: class="list-fragment" -->

Notes:
- secure web root directory: no unintended files (backup, metadata), disable directory listing
