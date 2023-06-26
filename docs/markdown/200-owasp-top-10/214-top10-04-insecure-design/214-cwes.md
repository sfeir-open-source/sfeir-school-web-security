# Insecure Design - Improper isolation or compartmentalization

- of data between users
- of shared resources
- of admin and user data/features
<!-- .element: class="list-fragment" -->



##==##

# Insecure Design - Reliance on security through obscurity

- Protection mechanism whose strength depends heavily on its obscurity

Notes:
- rely on that introduce risk, if attacker reverse engineer the mechanism / code leak / **



##==##

# Insecure Design - Improper control of interaction frequency

- No limitation of the amount of requests for a given actor
<!-- .element: class="list-fragment" -->

Notes:
- brute force, denial of service, compromise program logic, etc.



##==##

# Insecure Design - Client-Side Enforcement of Server-Side Security

- a server that relies on the client to implement a mechanism that is intended to protect the server
<!-- .element: class="list-fragment" -->
