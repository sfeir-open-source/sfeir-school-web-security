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
