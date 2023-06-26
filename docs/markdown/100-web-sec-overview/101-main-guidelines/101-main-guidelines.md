<!-- .slide: class="transition" -->
# Web security overview



##==##

# Web security - Why is it a big thing ?

- Applications mostly accessible from anywhere
<!-- .element: class="list-fragment" -->
- the 2000s: 
  - No general security awareness
  - Less "security by default"
<!-- .element: class="list-fragment" -->
- today:
  - Complex environments
  - Complex attacks
  - Old applications to maintain and upgrade
<!-- .element: class="list-fragment" -->

Notes:
- Easy target
- No sec awareness among users nor "sunday developers"
- sql injections everywhere: custom blogs, local authority sites...
- Today: zero-trust, secure by default, but complex (ci/cd, big apps, many dependencies, complex frameworks, several layers...)



##==##

# Objectives

- Protect data
  - Users / Clients
  - Company
  - Service providers
- Business continuity
<!-- .element: class="list-fragment" -->

Notes:
- Why securing websites ? Impact can be broader than imagined (more on this later)



##==##

<!-- .slide: class="quote-slide" -->
## Secure by default

<blockquote class="fragment">
<cite>
The default software configuration settings are the most secure settings possible.
</cite>
</blockquote>

Notes:
- For frameworks (Spring/Angular), for libraries (xml parsers), for programs (web server), for OSes...
- Means: no default users "admin/password", disable risky or potentially unused features...



##==##

<!-- .slide: class="quote-slide" -->
## Zero-trust (Architecture)

<blockquote>
<cite>
"Never trust, always verify": users and devices should not be trusted by default, even if they were previously verified
</cite>
</blockquote>

Notes:
- Implies strong identify verification (not only VPN), least privilege access principle...



##==##

# Some general rules

- Least privilege principle
- Deny by default
- Always validate user inputs
- Encryption
- Backup, restoration process
<!-- .element: class="list-fragment" -->



##==##

# Users education

- Passwords
  - Not too easy, not on a post-it, not the same everywhere...
  - Security vs usability
  - Multi-factor authentication !
- Phishing
- Up-to-date browsers and software
- Implement protection measures
<!-- .element: class="list-fragment" -->

Notes:
- Passwords "one" good policy", but at least choose one!
- Phishing: detection, and warning
- If user already has malware: hard to protect the user (but stop propagation)
- Measures: detect auth token re-usage, use MFA when appropriate..
