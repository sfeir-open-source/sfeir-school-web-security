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
