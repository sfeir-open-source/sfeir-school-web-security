<!-- .slide: class="transition" -->
# Tools



##==##

# SAST - Static Application Security Testing

- Statically analyzing the application source code
- Effective for finding many vulnerabilities
- ... And many false positives
<!-- .element: class="list-fragment" -->

Notes:
- only checks source code, do not execute anything. white-box.
- can enable to discover potential SQL injections, bad practices, etc.



##==##

# SAST - Static Application Security Testing

- SonarQube / SonarLint
- Gitlab SAST / GitHub Advanced Security
- Snyk Code
- Semgrep Code
- ...
<!-- .element: class="list-fragment" -->

Notes:
- SonarQube:
  - IDE integration (sonarlint)
  - branch analysis, pull/merge-request decoration
  - custom rules
  - supports many languages



##==##

# DAST - Dynamic Application Security Testing

- Dynamic analysis - perform attacks
- Sophisticated scans
- Used by penetration testers
<!-- .element: class="list-fragment" -->

Notes:
- Black-box
- to discover XSS, SQL injection, DoS, memory corruption, CSRF...



##==##

# DAST - Dynamic Application Security Testing

- Burp Suite Professional
- Nessus
- Invicti (NetSparker)
- ...
<!-- .element: class="list-fragment" -->

Notes:
- burp suite (even community edition): to craft requests
- craft simple GET/post requests: Postman & similar REST tools



##==##

# OWASP Dependency-Check

- Software Composition Analysis (SCA) tool
- Detect publicly disclosed vulnerabilities in dependencies
- Uses CVE data
- Also finds false positives
<!-- .element: class="list-fragment" -->

Notes:
- for each CVE: several CPE (Common Platform Enumeration)



##==##

# Other tools

- Monitoring / Observability
  - Datadog
  - Dynatrace
  - Elasticsearch-Logstash-Kibana (ELK)
  - ...
- Web Application Firewalls: 
  - ModSecurity (+OWASP coreruleset)
  - Cloudflare WAF
  - Cloud providers WAF
- Network monitoring
- Penetration testing tools
- ...
<!-- .element: class="list-fragment" -->

Notes:
- WAF: can also detect SQL injection / XSS



##==##

<!-- .slide: class="transition" -->
# Any tools to share ?
