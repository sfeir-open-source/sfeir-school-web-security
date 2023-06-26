<!-- .slide: class="transition" -->
# OWASP top-10 - A05:2021 - Security Misconfiguration



##==##
<!-- .slide: class="quote-slide" -->

## Security Misconfiguration

<blockquote>
<cite>
  Insecure (default) software configuration.
</cite>
</blockquote>



##==##

# Security Misconfiguration - Common vulnerabilities

- Missing security hardening
- Security settings not correctly set
- Improperly configured permissions (e.g. cloud)
- Unnecessary features
- Default accounts
- Issues in error handling
- Missing security headers/directives
<!-- .element: class="list-fragment" -->

Notes:
- Hardening: for instance for an OS
- features: ports, services, pages, accounts...
- error handling: reveal stack traces (overly informative)


##==##

# Security Misconfiguration - How to prevent

- Secure installation process
- Secure development/testing environments
- No unused features/components/documentation/...
- Explicitly review security configuration
- Use security headers
- Automated process to check configuration
<!-- .element: class="list-fragment" -->

Notes:
- install process: include security config and hardening. automatised
- review: also when patches/updates

