<!-- .slide: class="transition" -->
# OWASP top-10 - A09:2021 - Security Logging and Monitoring Failures



##==##
<!-- .slide: class="quote-slide" -->

## Security Logging and Monitoring Failures

<blockquote>
<cite>
  Detecting and responding to breaches, accountability
</cite>
</blockquote>

Notes:
- accountability: e.g. of a user performing an administrative action



##==##

# Security Logging and Monitoring Failures - Common issues

- No logging of auditable events
- No/bad logging of warnings and errors
- No backups
- No alerting tresholds (or not effective)
- Bad encoding
<!-- .element: class="list-fragment" -->

Notes:
- auditable: logins, failed logins, high-value transactions (e.g. add admin right to user)
- bad logging for warning/errors: unclear, missing valuable info to be useful
- many logs: 
  - not useful if not monitored => automation! 
  - not effective: pentest / sec tools do not triggers alerts
  - near real time!
- Encoding: injection / attacks



##==##

# Security Logging and Monitoring Failures - How to prevent

- Define and use guidelines for what should be logged
- Ensure correct encoding of logs
- Monitoring of logs
<!-- .element: class="list-fragment" -->
