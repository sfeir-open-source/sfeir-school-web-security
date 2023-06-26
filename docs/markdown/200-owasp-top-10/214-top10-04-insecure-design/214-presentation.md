<!-- .slide: class="transition" -->
# OWASP top-10 - A04:2021 - Insecure Design



##==##
<!-- .slide: class="quote-slide" -->

## Insecure Design

<blockquote>
<cite>
  Risks related to design and architectural flaws.
</cite>
</blockquote>

Notes:
- Objective: more threat modeling, secure design patterns, reference architecture
- Related to: secure by design principle
- New category for OWASP top10 2021



##==##

# Insecure Design

- Insecure design vs insecure implementation
- Often: lack of business risk profiling
- Business requirements collection - security requirements
  - confidentiality, integrity, availability and authenticity of all data assets
  - is the app exposed ?
- Secure design: constantly evaluates threats
  - Initial requirements, refinement, changes...
- Secure Development Lifecycle
<!-- .element: class="list-fragment" -->

Notes:
- insecure design vs impl: different cause and remediation
- business risk: evaluate it! depending on the data, users, context, etc.
  - to determine the required security design
- secure design: methodology



##==##

# Insecure Design - How to prevent

- Establish and use a secure development lifecycle
- Define and use secure design patterns for your applications
- Define and use reference architecture
- Use threat modeling
- Integrate security language and controls into user stories
- Write tests to validate flows against threats
<!-- .element: class="list-fragment" -->

Notes:
- secure dev lifecycle: define it with AppSec professionals!
- Reference architecture: many existing ones, eg in cloud
- threat modeling: for critical auth, access control, business logic..
