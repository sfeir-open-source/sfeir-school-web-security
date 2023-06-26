<!-- .slide: class="transition" -->
# OWASP top Ten... What's next ?


Notes:
- Owasp = main vulnerabilities, but not all of them. Not a (complete) framework.
- Next... or ideally at the same time,
- define / follow frameworks and methodologies



##==##

# SDLC

- SDLC - Software Development Life Cycle
- Different models: Waterfall, Iterative, Scrum / Agile...
<!-- .element: class="list-fragment" -->

Notes:
- steps to develop software



##==##

# SDLC - Phases

- Plan
- Design
- Implement
- Test
- Deploy
- Maintain
<!-- .element: class="list-fragment" -->

Notes:
- one example, can vary.
- plan: goal => costs, schedule, resource estimation
- design: analyze requirements, define solution to create software (pre-existing modules ? custom dev ? tools ? integration with existing ?)
- implement: code
- test: automated and manual, find bugs, check that it meets customer requirements
- deploy: ship to production
- maintain: fix bug, implement changes, monitoring (perf, security)



##==##

# Secure SDLC

- Security, at all stages
- To avoid accumulating security issues from previous steps
- Benefits:
<!-- .element: class="list-fragment" -->
  - More secure software, continuous improvement
  - More structured and effective security approach
  - Cost reduction
  - Regulatory compliance
<!-- .element: class="list-fragment" -->

Notes:
- hint from OWASP Top Ten: A04 Insecure design
- costs more to find issues just before release (or after)



##==##

<!-- .slide: class="transition" -->
# Secure SDLC - Some guidelines



##==##
# Secure SDLC - Plan

- Define and use a Secure SDLC
- Define security requirements, analyse risk
- Define roles and responsibilities
- Plan for automation
- Define metrics
<!-- .element: class="list-fragment" -->

Notes:
- ssdlc: doc, but also checklists for day-to-day!
- requirements: known by everyone. Then keep it updated during project.
- roles: ideally also inside the dev team
- automation: implies toolchain



##==##
# Secure SDLC - Design

- Design with secure by design architectures, patterns
- Ensure design meets security requirements
- Define security test plans
- Reuse software
<!-- .element: class="list-fragment" -->

Notes:
- reuse: of course, assess if relevant and if already secure!



##==##
# Secure SDLC - Implement

- Secure coding practices
- Secure development environment, CI/CD
- Protect code from unauthorized access/update
- Protect released artifacts integrity
- Educate development team
<!-- .element: class="list-fragment" -->
  - But also project managers, testers, maintainers !
<!-- .element: class="list-fragment" -->

Notes:
- secure coding practices: input validation, least privilege principle, intuitive but effective code, deny by default, code quality, coding standards...
  - no 50 page document... checklist!
- secure env: internal and external threats.
- education: security awareness


##==##
# Secure SDLC - Test

- Code reviews, code scanning tools
- Check dependencies for vulnerabilities
- Security-related unit/integration tests
<!-- .element: class="list-fragment" -->

Notes:
- to be done at the same time as development ("shift-left testing")



##==##
# Secure SDLC - Deploy

- Penetration testing
- Infrastructure security
  - Compartmentalise
  - Minimise attack surface
- Monitoring
<!-- .element: class="list-fragment" -->



##==##
# Secure SDLC - Maintain

- Follow third-party components vulnerabilities
- Bug bounties
<!-- .element: class="list-fragment" -->

Notes:
- bug bounty: not a good idea if the app is full of vulnerabilities



##==##

# Secure SDLC - Methodologies

- SAMM - OWASP Software Assurance Maturity Model
- NIST SSDF (NIST 800-218) - Secure Software Development Framework
- BSIMM - Building Security in Maturity Model
- Microsoft Security Development Lifecycle
- BSA Framework for Secure Software
- ...
<!-- .element: class="list-fragment" -->

Notes:
- SAMM: open-source, owasp, prescriptive model (you should follow specific actions and practices)
- SSDF: open source, includes guidelines from BSIMM, SAMM, OWASP, ASVS...
  - descriptive (describe practices, but no details on how to implement them)
- BSIMM: proprietary
  - also descriptive



##==##
<!-- .slide: class="transition" -->

# Other frameworks



##==##

# ISO/IEC 27001

- International standard to manage information security
- ISMS - Information Security Management System
<!-- .element: class="list-fragment" -->
  - assess information security risk (threats, vulnerabilities, impacts)
  - define suite of information security controls
    - Physical
    - Procedural
    - Technical
    - Legal
  - management process
<!-- .element: class="list-fragment" -->

Notes:
- so more generic than SDLC: info sec in whole company level
- controls: safeguards / countermeasures to avoid/detect/minimize security risk
  - physical controls (doors, locks, fire...), 
  - procedural controls (incident response), 
  - technical controls (antivirus software, firewalls...), 
  - legal controls
- management process: to ensure the controls meet the security needs continuously



##==##

# ISO/IEC 27000 family

- ISO 27001 - Requirements
- ISO 27002 - Best practices
- ISO 27003 - How to implement
- ISO 27005 - Risk management
- ISO 27017 - Security controls for cloud services
- ISO 27018 - Personally identifiable information (PII) collection
- ...
<!-- .element: class="list-fragment" -->

Notes:
- requirements: to be certified



##==##

# NIST Cyber-Security Framework (CSF)

- by NIST - National Institute of Standards and Technology (USA)
- Guidelines for mitigating cyber-security risks
<!-- .element: class="list-fragment" -->
  - Identify cyber risk
  - Protect
  - Detect
  - Respond
  - Recover
<!-- .element: class="list-fragment" -->



##==##

# PCI DSS

- Payment Card Industry Data Security Standard
- defined by Visa, MasterCard, American Express, Discover Card, JCB
- Data security standards to handle credit cards
- 6 goals, 12 main requirements
<!-- .element: class="list-fragment" -->

Notes:
- Initially: each card provider had his own program
- Goals: secure network, protect data, manage vulnerabilities, access control, monitoring, security policies


##==##

# Cloud

- ISO 27001, NIST CSF, SSDLC Frameworks are still valid!
- NIST - cloud-specific standards (e.g. SP-800-210)
- Cloud Security Alliance (CSA) - Cloud Controls Matrix (CCM)
  - Security controls
  - Mappings (to other frameworks)
  - Implementation Guidelines
- Cloud providers - Well-Architected Framework
<!-- .element: class="list-fragment" -->
  - AWS Well-Architected Framework
  - Microsoft Azure Well-Architected Framework
  - Google Cloud Architecture Framework
<!-- .element: class="list-fragment" -->

Notes:
- well-arch frameworks: guidelines relevant for the cloud provider
  - practices, services to uses, things to avoid...
  - and reference architectures.
