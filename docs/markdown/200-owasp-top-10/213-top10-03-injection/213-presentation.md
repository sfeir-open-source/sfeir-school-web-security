<!-- .slide: class="transition" -->
# OWASP top-10 - A03:2021 - Injection



##==##
<!-- .slide: class="quote-slide" -->

## Injection

<blockquote>
<cite>
  Usage of unsanitized data in queries.
</cite>
</blockquote>



##==##

# Injection - Common vulnerabilities

- Many injections: SQL, NoSQL, OS command, ORM, LDAP, Expression Language...
- Missing escaping
- No validation of user-supplied data
<!-- .element: class="list-fragment" -->

Notes:
- Ex: Spring Expression Language



##==##

# Injection - How to prevent

- Use a safe API
- Input validation
- Dynamic queries: proper escaping
- Avoid user-supplied table/column names
<!-- .element: class="list-fragment" -->

Notes:
- Safe API: parametrized interface, ORM.
