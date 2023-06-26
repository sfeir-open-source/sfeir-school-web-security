<!-- .slide: class="transition" -->
# OWASP top-10 - A10:2021 - Server-Side Request Forgery (SSRF)



##==##
<!-- .slide: class="quote-slide" -->

## Server-Side Request Forgery (SSRF)

<blockquote>
<cite>
  Occurs whenever a web application is fetching a remote resource without validating the user-supplied URL.
</cite>
</blockquote>

Notes:
- A new entry in the top-10 in 2021. A specific vulnerability.
- allows an attacker to send crafted request to unexpected destinations
- use-cases: image/avatar on external server, webhook...


##==##

# Server-Side Request Forgery (SSRF) - Common issues / exploitations

- Access unprotected http-accessible data on internal server
- Port scan internal network
- file:///etc/passwd
- Cloud: http://169.254.169.254/
- Exploit flaws on internal services
<!-- .element: class="list-fragment" -->

Notes:
- 169.254.169.254: ip link-local, used in azure/aws to get instance metadata



##==##

# Server-Side Request Forgery (SSRF) - How to prevent

- Move functionality to a separate network
- deny by default firewall policy
- enforce url schema, port, destination (whitelist)
- filter private networks range IPs, link-local addresses...
- Do not send raw responses to clients
- Disable HTTP redirections
- More information: [owasp cheatsheet](https://cheatsheetseries.owasp.org/cheatsheets/Server_Side_Request_Forgery_Prevention_Cheat_Sheet.html)
<!-- .element: class="list-fragment" -->
