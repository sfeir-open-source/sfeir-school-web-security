<!-- .slide: class="transition" -->
# OWASP top-10 - A08:2021 - Software and Data Integrity Failures



##==##
<!-- .slide: class="quote-slide" -->

## Software and Data Integrity Failures

<blockquote>
<cite>
  Code and infrastructure that does not protect against integrity violations
</cite>
</blockquote>



##==##

# Software and Data Integrity Failures - Common vulnerabilities

- Untrusted dependencies
- Insecure CI/CD
- Auto-update
- Insecure deserialization
<!-- .element: class="list-fragment" -->

Notes:
- Relying on plugin/libs from untrusted sources, repo, CDNs.
- CI/CD: unauthorized access, malicious code..
- Auto-update: need to do specific integrity check
- deserialization: of untrusted data



##==##

# Software and Data Integrity Failures - How to prevent

- Digital signatures
- Use trusted repositories
- Use software supply chain security tools
- review process for code and config changes
- Add integrity-check to serialized data
<!-- .element: class="list-fragment" -->

Notes:
- signature: to verify software updates / data
- repos: e.g. for npm: if high risk, use internal repo
- tools: eg owasp dependency check, see later
