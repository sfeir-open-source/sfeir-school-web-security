<!-- .slide: class="transition" -->
# OWASP top-10 - A07:2021 - Identification and Authentication Failures



##==##
<!-- .slide: class="quote-slide" -->

## Identification and Authentication Failures

<blockquote>
<cite>
  Issues in the processes that confirm the user's identity, including session management.
</cite>
</blockquote>

Notes:
- identification: identify a particular user (e.g. via username)
- authentication: proof of the user's identity (e.g. via password)
- authorization (not this chapter): check that user is allowed


##==##

# Identification and Authentication Failures - Common vulnerabilities

- No monitoring / prevention against automated attacks
- Default, weak and well-known passwords not forbidden
- Weak credential recovery process
- Session identifiers exposed in URLs
- Missing / Ineffective MFA
- Re-usage of session identifiers after login
- Bad invalidation of session IDs
<!-- .element: class="list-fragment" -->

Notes:
- automated attacks: bruteforce
- weak cred recovery: e.g. knowledge-based answers



##==##

# Identification and Authentication Failures - How to prevent

- MFA where possible
- Weak password check
- Adequate rules for passwords
- Harden against account enumeration attacks
- Limit failed login attempts
- Use server-side, secure, built-in session manager
<!-- .element: class="list-fragment" -->

Notes:
- MFA: prevent many automated attacks, e.g. stolen credential reuse
- rules for passwords: not necessarily all type of characters. Better something not simple to guess.
- avoid account enumeration: same answer when account do not exist or unauthorized access
