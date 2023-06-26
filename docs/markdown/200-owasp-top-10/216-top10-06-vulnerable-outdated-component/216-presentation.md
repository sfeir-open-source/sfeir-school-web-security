<!-- .slide: class="transition" -->
# OWASP top-10 - A06:2021 - Vulnerable and Outdated Components



##==##
<!-- .slide: class="quote-slide" -->

## Vulnerable and Outdated Components

<blockquote>
<cite>
  Usage of vulnerable, outdated, unsupported, abandoned components - directly, or as nested dependency.
</cite>
</blockquote>

Notes:
- Libraries, OS, app server, database, application, API...



##==##

# Vulnerable and Outdated Components - How to prevent

- Remove unused dependencies/features/components/***
- Continuous inventory of external components versions
- Get components for official sources
- Upgrade on a risk-based fashion
- Monitor / replace unmaintained components
<!-- .element: class="list-fragment" -->

Notes:
- inventory: automated! owasp dependency check, retire.js, etc.
  - monitor versions, known vulns, email alerts for security vulns
- official sources - pay attention to package name in npm for instance
- risk-based: so not just "upgrade every (3) months" => eg Log4shell.
