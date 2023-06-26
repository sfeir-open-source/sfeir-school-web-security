# Apache httpd

- Apache HTTP Server Project
- CVE-2019-9517 - Denial of Service
- CVE-2021-26691 - Heap overflow (potential remote code execution, crash)
- CVE-2022-31813 - bypass IP based authentication
<!-- .element: class="list-fragment" -->



##==##

# Wordpress (plugins)

- CVE-2022-21664 - execution of unintended SQL queries
- CVE-2022-21661 - SQL injection if combined with specific plugins
- CVE-2021-44223 - remote code executions for specific plugins
- CVE-2020-28038 - XSS vulnerability
- ... See https://www.cvedetails.com/vulnerability-list.php?product_id=4096&order=3
<!-- .element: class="list-fragment" -->



##==##

# SAP (ERP - Enterprise Resource Planning)

- CVE-2021-38180 - CVS injection (Excel)
- CVE-2020-6191 - missing input validation for admin users
- CVE-2016-6147 - arbitrary OS commands execution
- ... See https://www.cvedetails.com/vulnerability-list/vendor_id-797/cvssscoremin-9/cvssscoremax-/SAP.html
<!-- .element: class="list-fragment" -->



##==##

# Broken Access Control - Open Redirect

- Whitelist example: only authorize relative paths
<!-- .element: class="list-fragment" -->
- Example: https://example.com/login?redirectTo=%2FmyProfile
  - redirectTo: /myProfile
- Verification: check that the url starts with "/" ?
- ... Not secure
- Example: //attacker.com
<!-- .element: class="list-fragment" -->

Notes:
- //attacker.com  is a valid (scheme-relative) URL
- conclusion - again: be cautions when sanitizing



##==##

# Hibernate

- Hibernate (Java ORM)
- CVE-2019-14900 - CVE-2020-25638: SQL injections
<!-- .element: class="list-fragment" -->



##==##

# Nokia

- Accessible cloud environment
- Content: testing environment
- See https://hacken.io/industry-news-and-insights/new-discovery-nokia-left-its-cloud-environment-open-config-details-exposed/
<!-- .element: class="list-fragment" -->



##==##

# xWiki

- xWiki: opensource enterprise wiki
- Open source software, managed by a development team
- CVE-2023-32071 - XSS vulnerability, discovered on 09/05/2023, exists since at least version 2.3 (2011)
<!-- .element: class="list-fragment" -->

Notes:
- several maintainer does not imply fully secure, but always better than not maintained project


##==##

# PCI DSS (full slide)

- Payment Card Industry Data Security Standard
- defined by Visa, MasterCard, American Express, Discover Card, JCB
- Data security standards to handle credit cards
- 6 goals, 12 main requirements
<!-- .element: class="list-fragment" -->
- Build and Maintain a Secure Network and Systems
- Protect Cardholder Data
- Maintain a Vulnerability Management Program
- Implement Strong Access Control Measures
- Regularly Monitor and Test Networks
- Maintain an Information Security Policy
<!-- .element: class="list-fragment" -->

Notes:
- Initially: each card provider had his own program
- secure network: firewall, no defaults for passwords and security params
- protect data: encryption at rest and in transit
- vuln management program: anti-virus, dev and maintain secure systems and apps
- access control: restrict access to data, authenticate all accesses, restrict physical access
- monitor/test: monitor network and data access, test security systems and process
- policy: security for the whole company



##==##

# Insecure Design - Sensitive information storage

- in persistent cookie
- in browser cache
- in GET parameters
- in generated error messages
- missing encryption
<!-- .element: class="list-fragment" -->



##==##

# Vulnerable and Outdated Components - JavaScript libraries

- JQuery
- AngularJS
- Angular / React / Vue / ***
- npm transitive dependencies
<!-- .element: class="list-fragment" -->

Notes:
- Jquery: still maintained (and still there on many websites)
- AngularJS: not maintained anymore...
- npm: npm audit fix ; force versions of transitive dependencies in package.json (but risk of incompatibilities).


