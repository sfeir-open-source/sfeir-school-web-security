# Cryptographic Failures - Password hashing

- Hash function ?
- Hash your users passwords !
- Why not just encrypting passwords ?
- Flaws:
  - Weak Hash algorithm
  - No salt usage
  - Not enough computational effort
- Good example: bcrypt!
<!-- .element: class="list-fragment" -->
  - But: pay attention to denial-of-service attacks
<!-- .element: class="list-fragment" -->

Notes:
- hash func: maps any data to fixed-size output; not invertible, deterministic.
- Of course, no passwords in clear. Better hash!
- Encrypting: useless risk (if key is compromised => users re-using even strong passwords on several sites are very much at risk).
- md5, sha1: weaks!



##==##

# Cryptographic Failures - Cleartext transmission of sensitive information

- Network traffic can be sniffed by attackers
- Use and enforce HTTPS, SFPT...
<!-- .element: class="list-fragment" -->

Notes:
- for emails, APIs, even DNS (dns over https / dns over tls)
  - (DNSSEC: identity check, no encryption)


##==##

# Cryptographic Failures - HSTS

- HTTP Strict Transport Security / HSTS
- Enforce HTTPS!
- At domain / subdomain level
- HSTS preload list
<!-- .element: class="list-fragment" -->

Notes:
- prerequisite: no http-only page on the domain!



##==##

# Cryptographic Failures - Certificate validation

- Certificate: private key, public key, digital signature
- Can be self-signed
- Usually signed by another certificate
- Chain of trust:
<!-- .element: class="list-fragment" -->

<div class="fragment">

  ![w-800](./assets/images/200-owasp-top-10/certificate-chain-of-trust.png)

  [source](https://playbooks.idmanagement.gov/piv/cert-trust/)
</div>

Notes:
- root certificates: stored at OS/Browser level
- if you need to validate a certificate in a software : check carefully the whole chain of certificates. And none should be self-signed (except the last, trusted one)



##==##

# Cryptographic Failures - Certificate validation

- Browser warning

![w-1000](./assets/images/200-owasp-top-10/chrome-warning-bad-certificate.png)



##==##

# Cryptographic Failures - Certificate validation

- Browser warning


Notes:
Reasons:
- certificate not valid anymore (expired)
- Self-signed (parent) certificate not known by OS/Browser
- Captive portal on free Wifi!
- ...
- But also man in the middle attack



##==##

# Cryptographic Failures - Certificate validation

- Do not teach your employees/users to blindly ignore this warning

![w-700](./assets/images/200-owasp-top-10/chrome-warning-bad-certificate-skip.png)



##==##

# Cryptographic Failures - Certificate validation

- Do not teach your employees/users to blindly ignore this warning

Notes:
- and with HSTS: even harder to skip on some browsers (Chrome: type "thisisunsafe")
