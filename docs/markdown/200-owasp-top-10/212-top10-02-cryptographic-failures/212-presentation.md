<!-- .slide: class="transition" -->
# OWASP top-10 - A02:2021 - Cryptographic Failures



##==##
<!-- .slide: class="quote-slide" -->

## Cryptographic Failures

<blockquote>
<cite>
  Failures related to cryptography, or lack of cryptography.
</cite>
</blockquote>

Notes:
- Often leads to exposure of sensitive data



##==##

# Cryptographic Failures - Common vulnerabilities

- Encryption not enforced or not used
- Usage of weak or deprecated cryptographic / hash functions
- Usage of defaults keys / passwords
- Issues with randomness used for cryptography
- Certificates validation issues
<!-- .element: class="list-fragment" -->

Notes:
- randomness: not enough entropy, bad seed



##==##

# Cryptographic Failures - How to prevent

- Classify (sensitive) data
- Avoid storing data unnecessarily
- Encrypt sensitive data at rest
- Disable caching for responses that includes sensitive data
- ...
<!-- .element: class="list-fragment" -->

Notes:
- data: processed, stored, or transmitted by an application.
