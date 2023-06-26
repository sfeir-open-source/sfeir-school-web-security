# Identification and Authentication Failures - Authentication Bypass by Spoofing

- Authentication by IP / DNS names
- How to bypass
<!-- .element: class="list-fragment" -->

Notes:
- can be used for server-to-server communication
- IP spoofing, DNS cache poisoning.



##==##

# Identification and Authentication Failures - Authentication Bypass by Assumed-Immutable Data

- Gain privileges by updating the value of specific cookies / hidden form field
<!-- .element: class="list-fragment" -->

Notes:
- several examples: set a cookie to true => authenticated
- Same for hidden form field



##==##

# Identification and Authentication Failures - Session Fixation

- No invalidation of old session identifiers
<!-- .element: class="list-fragment" -->

Notes:
- sessions with no expiration
- several sessions for the same user (in same device+browser / or not)
- session leakage: logs, xss, self-xss...
